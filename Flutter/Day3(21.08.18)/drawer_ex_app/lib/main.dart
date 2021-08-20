import 'package:drawer_ex_app/Mail.dart';
import 'package:drawer_ex_app/ReceiveMail.dart';
import 'package:drawer_ex_app/SendMail.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: {
        '/': (context) {
          return Mail();
        },
        '/SendMail': (context) {
          return SendMail();
        },
        '/ReceiveMail': (context) {
          return ReceiveMail();
        },
      },
    );
  }
}
