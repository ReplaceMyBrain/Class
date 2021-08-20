import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

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
  String result = '';
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("http Exercise"),
        ),
        body: Container(
          child: Center(
            child: Text("$result"),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () async {
            //async 비동기
            var url = Uri.parse('https://www.google.com');
            var response = await http.get(url); //await 다른거 끝날때까지 기다려줌
            setState(() {
              result = response.body;
            });
          },
          child: Icon(Icons.file_download),
        ));
  }
}
