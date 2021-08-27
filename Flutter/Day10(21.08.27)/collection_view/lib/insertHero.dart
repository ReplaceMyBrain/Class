import 'package:collection_view/message.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class InsertHero extends StatefulWidget {
  const InsertHero({Key? key}) : super(key: key);

  @override
  _InsertHeroState createState() => _InsertHeroState();
}

class _InsertHeroState extends State<InsertHero> {
  TextEditingController? _messagesBox;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _messagesBox = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
          navigationBar: CupertinoNavigationBar(
            leading: CupertinoNavigationBarBackButton(
              previousPageTitle: '삼국지인물',
              onPressed: () {
                Navigator.pop(context);
              },
            ),
            middle: Text("인물추가"),
          ),
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  child: CupertinoTextField(
                    controller: _messagesBox,
                    maxLines: 1,
                    textAlign: TextAlign.left,
                    keyboardType: TextInputType.text,
                  ),
                  width: 300,
                ),
                CupertinoButton(
                    child: Text("Add"),
                    onPressed: () {
                      addList();
                    })
              ],
            ),
          )),
    );
  }

  void addList() {
    setState(() {
      Message.humanName = _messagesBox!.text.toString();
      print(Message.humanName);
      print(_messagesBox!.text.toString());
      Navigator.pop(context);
    });
  }
}
