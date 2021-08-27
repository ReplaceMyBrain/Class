import 'package:collection_view/detailHero.dart';
import 'package:collection_view/insertHero.dart';
import 'package:collection_view/message.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

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
  late List<String> heroList = [];

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    heroList.add("유비");
    heroList.add("관우");
    heroList.add("조조");
    heroList.add("여포");
    heroList.add("초선");
    heroList.add("손견");
    heroList.add("장양");
    heroList.add("손책");
    heroList.add("장비");
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        middle: Text("삼국지인물"),
        trailing: Material(
          child: IconButton(
            icon: Icon(Icons.add),
            onPressed: () {
              Navigator.push(context, CupertinoPageRoute(builder: (context) {
                return InsertHero();
              })).then((value) => rebuildData());
            },
          ),
        ),
      ),
      child: GridView.builder(
          itemCount: heroList.length,
          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 3,
            crossAxisSpacing: 10,
            mainAxisSpacing: 10,
          ),
          itemBuilder: (context, index) {
            return Container(
              height: 50,
              color: Colors.grey,
              child: GestureDetector(
                child: Card(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [Text(heroList[index])],
                  ),
                  color: Colors.yellow,
                ),
                onTap: () {
                  Navigator.push(context, MaterialPageRoute(builder: (context) {
                    return DetailHero(hero: heroList[index]);
                  }));
                },
              ),
            );
          }),
    );
  }

  void rebuildData() {
    setState(() {
      if (Message.humanName == null) {
        heroList.add(Message.humanName);
      }
    });
  }
}
