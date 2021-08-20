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

class MyHomePage extends StatelessWidget {
  // 생성자가 Dictionary(Map) 타입으로 구성되어있음
  // 화면 전환 시 데이터 넘길 때 Map으로 넘겨줌
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Scaffold 는 안드로이드 포맷 (쿠퍼티노가 iOS 포맷)
      backgroundColor: Colors.red[200],
      appBar: AppBar(
        title: Text('Image 01'),
        backgroundColor: Colors.red,
      ),
      body: Center(
        child: Padding(
          // all 말고 from~ 줄 수 있음
          padding: const EdgeInsets.all(10.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              CircleAvatar(
                backgroundImage: AssetImage('images/p1.png'),
                radius: 50.0,
              ),
              SizedBox(
                height: 10,
              ),
              CircleAvatar(
                backgroundImage: AssetImage('images/p2.png'),
                radius: 50.0,
              ),
              SizedBox(
                height: 10,
              ),
              CircleAvatar(
                backgroundImage: AssetImage('images/p3.png'),
                radius: 50.0,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
