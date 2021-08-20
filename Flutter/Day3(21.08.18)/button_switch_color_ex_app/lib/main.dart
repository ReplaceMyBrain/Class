import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
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
  var switchValue = false;
  Color color = Colors.blue;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Changed Button Color on Swithch"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Padding(
              padding: const EdgeInsets.all(50.0),
              child: ElevatedButton(
                onPressed: () {},
                child: Text("Flutter"),
                style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(color)),
              ),
            ),
            Switch(
                value: switchValue,
                onChanged: (value) {
                  setState(() {
                    switchValue = value;
                    if (switchValue == true) {
                      color = Colors.red;
                    } else {
                      color = Colors.blue;
                    }
                  });
                }),
          ],
        ),
      ),
    );
  }
}
