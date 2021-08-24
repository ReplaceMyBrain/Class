import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      title: 'Flutter Demo',
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  TextEditingController? _multilines;
  TextEditingController? _singleline;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _multilines = TextEditingController();
    _singleline = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Padding(
                padding: const EdgeInsets.fromLTRB(0, 0, 0, 20),
                child: Text(
                  "여러줄 출력",
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 20,
                  ),
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Container(
                    child: CupertinoTextField(
                      controller: _singleline,
                      maxLines: 1,
                      textAlign: TextAlign.left,
                      keyboardType: TextInputType.text,
                      placeholder: "글자를 입력하세요!",
                    ),
                    width: 280,
                  ),
                  CupertinoButton(
                      child: Text("추가"),
                      onPressed: () {
                        setState(() {
                          insertLines();
                        });
                      })
                ],
              ),
              Padding(
                padding: const EdgeInsets.fromLTRB(20, 0, 20, 20),
                child: CupertinoTextField(
                  controller: _multilines,
                  maxLines: 10,
                  textAlign: TextAlign.left,
                  decoration: BoxDecoration(color: Colors.amber[100]),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  void insertLines() {
    _multilines!.text += _singleline!.text + "\n";
  }
}
