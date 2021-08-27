import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:table/message.dart';

class InsertList extends StatefulWidget {
  const InsertList({Key? key}) : super(key: key);

  @override
  _InsertListState createState() => _InsertListState();
}

class _InsertListState extends State<InsertList> {
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
              previousPageTitle: 'Main View',
              onPressed: () {
                Navigator.pop(context);
              },
            ),
            middle: Text("Add VIew"),
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
      Message.insertImagepath = 'images/pencil.png';
      Message.insertData = _messagesBox!.text.toString();
      Navigator.pop(context);
    });
  }
}
