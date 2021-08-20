import 'package:flutter/material.dart';
import 'package:textfield_login_app/bitcoin.dart';
import 'package:textfield_login_app/home.dart';

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
  final idController = TextEditingController();
  final pwController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Log In"),
      ),
      body: Center(
        child: Column(
          children: [
            Padding(
              padding: const EdgeInsets.all(20.0),
              child: CircleAvatar(
                backgroundImage: AssetImage("images/lee.jpeg"),
                radius: 100.0,
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(30.0),
              child: TextField(
                controller: idController,
                decoration: InputDecoration(labelText: "사용자 ID 입력하세요"),
                keyboardType: TextInputType.text,
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(30.0),
              child: TextField(
                controller: pwController,
                decoration: InputDecoration(labelText: "패스워드를 입력하세요"),
                keyboardType: TextInputType.text,
                obscureText: true,
              ),
            ),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  if (idController.text.isEmpty || pwController.text.isEmpty) {
                    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                      content: Text("사용자ID와 암호를 입력하세요!"),
                      duration: Duration(seconds: 1),
                      backgroundColor: Colors.red,
                    ));
                  } else if (idController.text == "qw" &&
                      pwController.text == "123") {
                    okAlert(context);
                  } else {
                    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                      content: Text("사용자ID나 암호가 맞지 않습니다!"),
                      duration: Duration(seconds: 1),
                      backgroundColor: Colors.blue,
                    ));
                  }
                });
              },
              child: Text("Log In"),
            ),
          ],
        ),
      ),
    );
  }

  void okAlert(BuildContext context) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text("환영합니다"),
          content: Text('신분이 확인되었습니다'),
          actions: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.blue),
              ),
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return home();
                }));
              },
              child: Text("OK"),
            ),
          ],
        );
      },
    );
  }
}
