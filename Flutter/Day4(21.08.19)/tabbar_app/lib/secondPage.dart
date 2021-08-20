import 'package:flutter/material.dart';

class SecondPage extends StatelessWidget {
  const SecondPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // appBar: AppBar(
      //   title: Text("second Page"),
      // ),
      body: Center(
        child: Text("두번째 페이지"),
      ),
    );
  }
}
