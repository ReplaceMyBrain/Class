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
  List flower = [
    "flower_01.png",
    "flower_02.png",
    "flower_03.png",
    "flower_04.png",
    "flower_05.png",
    "flower_06.png"
  ];
  int num = 0;
  int count = 0;

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                flower[count],
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
              Image.asset(
                "images/${flower[count]}",
                width: 300,
                height: 500,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CupertinoButton(
                    child: Text("이전"),
                    onPressed: () {
                      count -= 1;
                      setState(() {
                        change();
                      });
                    },
                  ),
                  CupertinoButton(
                    child: Text("다음"),
                    onPressed: () {
                      count += 1;
                      setState(() {
                        change();
                      });
                    },
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  void change() {
    if (count == -1) {
      count = 5;
    } else if (count == 6) {
      count = 0;
    }
  }
}
