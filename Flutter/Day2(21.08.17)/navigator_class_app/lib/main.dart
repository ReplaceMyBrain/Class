import 'package:flutter/material.dart';
import 'package:navigator_class_app/screen.dart';
import 'package:navigator_class_app/screen1st.dart';
import 'package:navigator_class_app/screen2nd.dart';

void main() {
  runApp(MyApp());
}

//컨트롤 만들기
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: {
        '/': (context) {
          return Screen();
        },
        '/1st': (context) {
          return Screen1st();
        },
        '/2st': (context) {
          return Screen2st();
        },
      },
    );
  }
}
