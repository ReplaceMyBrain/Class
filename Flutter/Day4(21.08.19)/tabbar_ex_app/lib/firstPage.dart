import 'package:flutter/material.dart';

class FirstPage extends StatelessWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.red[200],
      // appBar: AppBar(
      //   title: Text("First Page"),
      // ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            CircleAvatar(
              backgroundColor: Colors.white,
              backgroundImage: AssetImage('images/p1.png'),
              radius: 50.0,
            ),
            CircleAvatar(
              backgroundColor: Colors.white,
              backgroundImage: AssetImage('images/p2.png'),
              radius: 50.0,
            ),
            CircleAvatar(
              backgroundColor: Colors.white,
              backgroundImage: AssetImage('images/p3.png'),
              radius: 50.0,
            ),
          ],
        ),
      ),
    );
  }
}
