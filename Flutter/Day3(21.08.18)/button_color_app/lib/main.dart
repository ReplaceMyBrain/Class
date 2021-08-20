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
  String buttonText = "Hello";
  Color _color = Colors.blue;

  // String? buttonText1;
  // Color? _color1;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Change button color & text"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () {
                if (_color == Colors.blue) {
                  setState(() {
                    //변경되는 부분만 적어주면 됨!
                    buttonText = "Flutter";
                    _color = Colors.amber;
                  });
                } else {
                  setState(() {
                    buttonText = "Hello";
                    _color = Colors.blue;
                  });
                }
              },
              child: Text('$buttonText'),
              style: ButtonStyle(
                  backgroundColor: MaterialStateProperty.all(_color)),
            ),
          ],
        ),
      ),
    );
  }
}
