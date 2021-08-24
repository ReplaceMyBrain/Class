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
                  "구구단 출력",
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
                      keyboardType: TextInputType.number,
                      placeholder: "숫자입력",
                    ),
                    width: 80,
                  ),
                  CupertinoButton(
                      child: Text("단 출력"),
                      onPressed: () {
                        setState(() {
                          insertLines();
                        });
                      })
                ],
              ),
              Container(
                padding: const EdgeInsets.fromLTRB(20, 0, 20, 20),
                child: CupertinoTextField(
                  controller: _multilines,
                  maxLines: 10,
                  textAlign: TextAlign.left,
                  decoration: BoxDecoration(color: Colors.amber[100]),
                ),
                width: 300,
              ),
            ],
          ),
        ),
      ),
    );
  }

  void insertLines() {
    _multilines!.text = "";
    int num1 = int.parse(_singleline!.text);
    for (int i = 0; i < 10; i++) {
      _multilines!.text += "$num1 X $i = ${num1 * i}\n";
    }
  }
}
