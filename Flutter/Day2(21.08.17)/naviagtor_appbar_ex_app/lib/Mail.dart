import 'package:flutter/material.dart';

class Mail extends StatelessWidget {
  const Mail({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Navigator_AppBar'),
        actions: [
          IconButton(
              onPressed: () {
                Navigator.pushNamed(context, '/SendMail');
              },
              icon: Icon(Icons.email_rounded)),
          IconButton(
              onPressed: () {
                Navigator.pushNamed(context, '/ReceiveMail');
              },
              icon: Icon(Icons.email_outlined)),
        ],
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.green),
              ),
              onPressed: () {
                Navigator.pushNamed(context, '/SendMail');
              },
              child: Text("보낸편지함"),
            ),
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.red),
              ),
              onPressed: () {
                Navigator.pushNamed(context, '/ReceiveMail');
              },
              child: Text("받은 편지함"),
            ),
          ],
        ),
      ),
    );
  }
}
