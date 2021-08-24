import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: MyHomePage(),
      title: 'Flutter Demo',
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String text = "Welcome!";
  int count = 0;

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text("$text"),
              CupertinoButton(
                  child: Text("Name"),
                  onPressed: () {
                    setState(() {
                      count += 1;
                      if (count % 2 == 0) {
                        text = "Welcome!";
                      } else {
                        text += "kenny";
                      }
                    });
                  }),
            ],
          ),
        ),
      ),
    );
  }
}
