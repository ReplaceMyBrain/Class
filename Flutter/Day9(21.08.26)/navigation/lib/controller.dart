import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:navigation/message.dart';

class Controller extends StatefulWidget {
  const Controller({Key? key}) : super(key: key);

  @override
  _ControllerState createState() => _ControllerState();
}

class _ControllerState extends State<Controller> {
  TextEditingController? _messageBox;
  bool _switch = true;
  String switchText = 'On';

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _messageBox = TextEditingController();
    _messageBox!.text = Message.contents;

    if (Message.lampStatus) {
      setState(() {
        _switch = true;
        switchText = 'On';
      });
    } else {
      setState(() {
        _switch = false;
        switchText = 'Off';
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
          navigationBar: CupertinoNavigationBar(
            leading: CupertinoNavigationBarBackButton(
              previousPageTitle: 'Main 화면',
              onPressed: () {
                Message.contents = _messageBox!.text;
                Navigator.pop(context);
              },
            ),
            middle: Text('수정화면'),
          ),
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  child: CupertinoTextField(
                    controller: _messageBox,
                    maxLines: 1,
                    textAlign: TextAlign.left,
                    keyboardType: TextInputType.text,
                  ),
                  width: 300,
                ),
                Padding(
                  padding: const EdgeInsets.fromLTRB(55, 20, 0, 0),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(
                        switchText,
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      CupertinoSwitch(
                          value: _switch,
                          onChanged: (value) {
                            setState(() {
                              _switch = value;
                              decisionOnOff();
                            });
                          }),
                    ],
                  ),
                )
              ],
            ),
          )),
    );
  }

  void decisionOnOff() {
    setState(() {
      if (_switch) {
        Message.lampStatus = true;
        switchText = "On";
      } else {
        Message.lampStatus = false;
        switchText = "Off";
      }
    });
  }
}
