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

/*
  context : Widget에 대한 meta정보나 widget tree의 위치를 나타냄.
*/

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Alert Dialog with Gesture"),
      ),
      body: Center(
        child: GestureDetector(
          onTap: () {
            _showDialog(context); // _는 프라이빗!
          },
          child: Text("Hello World"),
        ),
      ),
    );
  }
}

void _showDialog(BuildContext context) {
  showDialog(
    context: context,
    builder: (BuildContext context) {
      return AlertDialog(
        title: Text("Alert Title"),
        content: Text('Hello World를 Touch했습니다.'),
        actions: [
          ElevatedButton(
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Colors.blue),
            ),
            onPressed: () {
              Navigator.of(context).pop();
            },
            child: Text("종료"),
          ),
        ],
      );
    },
  );
}
