import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:table/detailList.dart';
import 'package:table/insertList.dart';
import 'package:table/message.dart';
import 'package:table/todoList.dart';

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
  late List<TodoList> todoList = [];

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    todoList.add(TodoList(imagePath: 'images/cart.png', workList: '책구매'));
    todoList.add(TodoList(imagePath: 'images/clock.png', workList: '철수와약속'));
    todoList
        .add(TodoList(imagePath: 'images/pencil.png', workList: '스터디 준비하기'));
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        middle: Text("Main View"),
        trailing: Material(
          child: IconButton(
            onPressed: () {
              Navigator.push(context, CupertinoPageRoute(builder: (context) {
                return InsertList();
              })).then((value) => rebuildData());
            },
            icon: Icon(Icons.add),
          ),
        ),
      ),
      child: ListView.builder(
          itemCount: todoList.length,
          itemBuilder: (context, index) {
            return Padding(
              padding: const EdgeInsets.all(8.0),
              child: Container(
                child: GestureDetector(
                  child: Card(
                    child: Column(
                      children: [
                        Row(
                          children: [
                            Image.asset(
                              todoList[index].imagePath,
                              fit: BoxFit.contain,
                              width: 40,
                              height: 40,
                            ),
                            SizedBox(
                              width: 10,
                            ),
                            Text(todoList[index].workList)
                          ],
                        )
                      ],
                    ),
                  ),
                  onTap: () {
                    Navigator.push(context,
                        MaterialPageRoute(builder: (context) {
                      return DetailList(
                          rcontentList: todoList[index].workList.toString());
                    }));
                  },
                ),
                height: 50,
              ),
            );
          }),
    );
  }

  void rebuildData() {
    setState(() {
      todoList.add(TodoList(
          imagePath: Message.insertImagepath, workList: Message.insertData));
    });
  }
}//<
