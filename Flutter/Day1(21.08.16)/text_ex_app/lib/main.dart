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
      debugShowCheckedModeBanner: false,
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Text Ecercise01"),
        backgroundColor: Colors.lightGreen,
        centerTitle: false,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Divider(
              height: 30.0,
              color: Colors.grey[700],
              thickness: 0.5,
            ),
            Text("yubi"),
            Text("kwanwoo"),
            Text("jangbi"),
            // SizedBox(
            //   height: 20.0,
            // ),
            Divider(
              height: 30.0,
              color: Colors.grey[700],
              thickness: 0.5,
            ),
            Text(
              "jojo",
              style: TextStyle(
                color: Colors.blue,
                letterSpacing: 5.0,
                fontSize: 28.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            Text("yeopo"),
            Text("dongtak"),
            Divider(
              height: 30.0,
              color: Colors.grey[700],
              thickness: 0.5,
            ),
          ],
        ),
      ),
    );
  }
}
