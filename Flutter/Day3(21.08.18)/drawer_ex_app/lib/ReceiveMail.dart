import 'package:flutter/material.dart';

class ReceiveMail extends StatelessWidget {
  const ReceiveMail({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('ReceiveMail'),
        backgroundColor: Colors.red,
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.fromLTRB(10, 50, 0, 0),
          child: Column(
            children: [
              Row(children: [Text("유비에게 받은 메일")]),
              Row(children: [Text("관우에게 받은 메일")]),
              Row(children: [Text("장비에게 받은 메일")]),
            ],
          ),
        ),
      ),
    );
  }
}
