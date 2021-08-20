import 'package:flutter/material.dart';

class FirstPage extends StatelessWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // appBar: AppBar(
      //   title: Text("First Page"),
      // ),
      body: Center(
        child: Text("첫번째 페이지"),
      ),
    );
  }
}
