import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      title: 'Flutter Demo',
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
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                'Alert와 Action Sehht',
                style: TextStyle(
                  fontSize: 20.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CupertinoButton(
                      child: Text("Alert"),
                      onPressed: () {
                        setState(() {
                          _showAlert(title: "Title", message: "Message");
                        });
                      }),
                  SizedBox(
                    width: 20,
                  ),
                  CupertinoButton(
                      child: Text("Action Sheet"),
                      onPressed: () {
                        setState(() {
                          _showActionSheet(title: "Title", message: "Message");
                        });
                      }),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }

  void _showAlert({String? title, String? message}) {
    showCupertinoDialog(
        context: context,
        builder: (context) {
          return CupertinoAlertDialog(
            title: Text(title!),
            content: Text(message!),
            actions: [
              CupertinoDialogAction(
                isDefaultAction: true,
                child: Text("Action Default"),
                onPressed: () {
                  print("Alert : Action Default");
                  Navigator.pop(context);
                },
              ),
              CupertinoDialogAction(
                isDestructiveAction: true,
                child: Text("Action Destructive"),
                onPressed: () {
                  print("Alert : Action Destructive");
                  Navigator.pop(context);
                },
              ),
              CupertinoDialogAction(
                child: Text(
                  "Action Cancel",
                  style: TextStyle(fontWeight: FontWeight.bold),
                ),
                onPressed: () {
                  print("Alert : Action Destructive");
                  Navigator.pop(context);
                },
              ),
            ],
          );
        });
  }

  void _showActionSheet({String? title, String? message}) {
    showCupertinoModalPopup(
        context: context,
        builder: (context) {
          return CupertinoActionSheet(
            title: Text(title!),
            message: Text(message!),
            actions: [
              CupertinoActionSheetAction(
                isDefaultAction: true,
                child: Text("Action Default"),
                onPressed: () {
                  print("Alert : Action Default");
                  Navigator.pop(context);
                },
              ),
              CupertinoActionSheetAction(
                isDestructiveAction: true,
                child: Text("Action Destructive"),
                onPressed: () {
                  print("Alert : Action Destructive");
                  Navigator.pop(context);
                },
              ),
            ],
            cancelButton: CupertinoActionSheetAction(
              child: Text(
                "Action Cancel",
                style: TextStyle(fontWeight: FontWeight.bold),
              ),
              onPressed: () {
                print("Alert : Action Destructive");
                Navigator.pop(context);
              },
            ),
          );
        });
  }
}
