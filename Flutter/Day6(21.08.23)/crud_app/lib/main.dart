import 'package:crud_app/delete.dart';
import 'package:crud_app/insert.dart';
import 'package:crud_app/select.dart';
import 'package:crud_app/update.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/select',
      // 제일 처음 뜨는 화면 정의
      routes: {
        '/select': (context) {
          return Select();
        },
        '/insert': (context) {
          return Insert();
        },
        '/update': (context) {
          return UpdateStudent(rcode: "", rname: "", rdept: "", rphone: "");
        },
        '/delete': (context) {
          return Delete(rcode: "", rname: "", rdept: "", rphone: "");
        },
      },
    );
  }
}
