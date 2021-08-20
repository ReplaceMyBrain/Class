import 'package:flutter/material.dart';

class SecondPage extends StatelessWidget {
  const SecondPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Second Page"),
        backgroundColor: Colors.pink,
        centerTitle: false,
      ),
      body: Center(
        child: Text("2번째 페이지 입니다"),
      ),
    );
  }
}
