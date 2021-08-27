import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class DetailList extends StatefulWidget {
  final String rcontentList;
  const DetailList({Key? key, required this.rcontentList}) : super(key: key);

  @override
  _DetailListState createState() => _DetailListState(rcontentList);
}

class _DetailListState extends State<DetailList> {
  late String contentList;
  // Create Constructor
  _DetailListState(String rcontentList) {
    this.contentList = rcontentList;
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        navigationBar: CupertinoNavigationBar(
          leading: CupertinoNavigationBarBackButton(
            previousPageTitle: "Main View",
            onPressed: () {
              Navigator.pop(context);
            },
          ),
          middle: Text('Detail View'),
        ),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [Text(contentList)],
          ),
        ),
      ),
    );
  }
}
