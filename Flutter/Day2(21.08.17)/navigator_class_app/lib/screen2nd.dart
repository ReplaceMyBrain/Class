import 'package:flutter/material.dart';

class Screen2st extends StatelessWidget {
  const Screen2st({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Screen 2st'),
          backgroundColor: Colors.green,
        ),
        body: Center(
            child: Text(
          'screen 2nd',
          style: TextStyle(fontSize: 20),
        )));
  }
}
