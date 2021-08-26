import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:navigation/controller.dart';
import 'package:navigation/message.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
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
  TextEditingController? _messageBox;
  String _lampImage = 'images/on.png';

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _messageBox = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        leading: Material(
          child: IconButton(
            onPressed: () {
              print("Home button is clicked");
            },
            icon: Icon(Icons.home),
          ),
        ),
        middle: Text(
          'Main 화면',
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
        trailing: Material(
          child: IconButton(
              onPressed: () {
                Message.contents = _messageBox!.text;
                Navigator.push(context, CupertinoPageRoute(builder: (context) {
                  return Controller();
                })).then((value) => getData());
              },
              icon: Icon(Icons.edit)),
        ),
      ), // 화면쪽 디자인은 NavigationBar에서 끝남!
      child: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              child: Row(
                children: [
                  SizedBox(
                    width: 55,
                  ),
                  Text(
                    "Message",
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                ],
              ),
            ),
            SizedBox(
              height: 20,
            ),
            Container(
              child: CupertinoTextField(
                controller: _messageBox,
                maxLines: 1,
                textAlign: TextAlign.left,
                keyboardType: TextInputType.text,
                placeholder: "Message를 입력 하세요!",
              ),
              width: 300,
            ),
            Image.asset(
              _lampImage,
              width: 150,
              height: 300,
            )
          ],
        ),
      ),
    );
  }

  void getData() {
    _messageBox!.text = Message.contents;
    if (Message.lampStatus) {
      setState(() {
        _lampImage = 'images/on.png';
      });
    } else {
      setState(() {
        _lampImage = 'images/off.png';
      });
    }
  }
} // <—