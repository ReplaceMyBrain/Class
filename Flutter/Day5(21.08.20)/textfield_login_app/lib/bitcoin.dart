import 'package:flutter/material.dart';

class bitcoin extends StatelessWidget {
  final String id;
  const bitcoin({Key? key, required this.id}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        title: Text("$id 님! 환영합니다"),
      ),
      body: Center(
        child: CircleAvatar(
          backgroundImage: AssetImage("images/bitcoin.png"),
          radius: 100,
        ),
      ),
    );
  }
}
