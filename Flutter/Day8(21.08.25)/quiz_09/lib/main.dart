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
  List _num = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  int _selectedItem = 0;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _multilines = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "${_num[_selectedItem]}단",
                style: TextStyle(fontSize: 20.0, fontWeight: FontWeight.bold),
              ),
              Container(
                child: CupertinoPicker(
                    backgroundColor: Colors.white,
                    itemExtent: 30,
                    scrollController:
                        FixedExtentScrollController(initialItem: 0),
                    onSelectedItemChanged: (value) {
                      setState(() {
                        _selectedItem = value;
                        gugu();
                      });
                    },
                    children: [
                      Text("${_num[0]}단"),
                      Text("${_num[1]}단"),
                      Text("${_num[2]}단"),
                      Text("${_num[3]}단"),
                      Text("${_num[4]}단"),
                      Text("${_num[5]}단"),
                      Text("${_num[6]}단"),
                      Text("${_num[7]}단"),
                      Text("${_num[8]}단"),
                    ]),
                width: 300,
                height: 250,
              ),
              Padding(
                padding: const EdgeInsets.all(50.0),
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

  void gugu() {
    _multilines!.text = "";
    int num = _num[_selectedItem];
    for (int i = 1; i < 10; i++) {
      _multilines!.text += " $num X $i = ${num * i} \n";
    }
  }
}
