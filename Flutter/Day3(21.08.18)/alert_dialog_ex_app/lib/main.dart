import 'package:alert_dialog_ex_app/SecondPage.dart';
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
        title: Text("Alert and push"),
        centerTitle: false,
      ),
      body: Center(
        child: GestureDetector(
          onTap: () {
            _showDialog(context); // _는 프라이빗!
          },
          child: Text("Move the 2nd page"),
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
        title: Text("Page 이동"),
        content: Text('아래의 버튼을 누르면 페이지 이동을 합니다'),
        actions: [
          ElevatedButton(
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Colors.blue),
            ),
            onPressed: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return SecondPage();
              }));
            },
            child: Text("페이지 이동"),
          ),
        ],
      );
    },
  );
}
