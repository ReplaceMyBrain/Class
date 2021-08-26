import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:tab_bar/firstPage.dart';
import 'package:tab_bar/secondPage.dart';

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
  late CupertinoTabBar tabBar;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    tabBar = CupertinoTabBar(
      items: <BottomNavigationBarItem>[
        BottomNavigationBarItem(
          label: "a",
          icon: Icon(CupertinoIcons.star),
        ),
        BottomNavigationBarItem(
          label: "b",
          icon: Icon(CupertinoIcons.star),
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoTabScaffold(
        tabBar: tabBar,
        tabBuilder: (context, value) {
          if (value == 0) {
            return FirstPage();
          } else {
            return SecondPage();
          }
        },
      ),
    );
  }
}
