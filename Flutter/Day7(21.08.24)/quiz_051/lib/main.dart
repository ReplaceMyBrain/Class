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
      debugShowCheckedModeBanner: false,
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
  String _lampImage = "images/lamp_on.png";
  double _lampwidth = 150;
  double _lampHeight = 300;
  bool _lampSize = false;
  bool _switch = true;

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            children: [
              Container(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Image.asset(
                      _lampImage,
                      width: _lampwidth,
                      height: _lampHeight,
                    )
                  ],
                ),
                width: 350,
                height: 650,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Column(
                    children: [
                      Text(
                        '전구확대',
                        style: TextStyle(fontSize: 12.0),
                      ),
                      CupertinoSwitch(
                        value: _lampSize,
                        onChanged: (value) {
                          setState(() {
                            _lampSize = value;
                            decisionLampSize();
                          });
                        },
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      Text(
                        '전구스위치',
                        style: TextStyle(fontSize: 12.0),
                      ),
                      CupertinoSwitch(
                        value: _switch,
                        onChanged: (value) {
                          setState(() {
                            _switch = value;
                            decisionOnOff();
                          });
                        },
                      ),
                    ],
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  void decisionLampSize() {
    if (_lampSize) {
      _lampwidth = 300;
      _lampHeight = 600;
    } else {
      _lampwidth = 150;
      _lampHeight = 300;
    }
  }

  void decisionOnOff() {
    if (_switch) {
      _lampImage = "images/lamp_on.png";
    } else {
      _lampImage = "images/lamp_off.png";
    }
  }
}
