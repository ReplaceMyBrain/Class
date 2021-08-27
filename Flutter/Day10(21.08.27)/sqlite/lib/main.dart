import 'package:flutter/material.dart';
import 'databaseHandler.dart';
import 'insertStudents.dart';
import 'students.dart';
import 'updateStudents.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.deepOrange,
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
  late DatabaseHandler handler;

  @override
  void initState() {
    super.initState();
    // 1st Action
    handler = DatabaseHandler();
    // handler.initializeDB().whenComplete(() async {
    //   await addStudents();
    //   setState(() {});
    // });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('SQLite for Students'),
        actions: [
          IconButton(
            icon: Icon(Icons.add_outlined),
            onPressed: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return InsertStudents();
              })).then((value) => reloadData());
            },
          )
        ],
      ),
      body: FutureBuilder(
          future: handler.queryStudents(),
          builder:
              (BuildContext context, AsyncSnapshot<List<Students>> snapshot) {
            if (snapshot.hasData) {
              return ListView.builder(
                  itemCount: snapshot.data?.length,
                  itemBuilder: (BuildContext context, int index) {
                    return Dismissible(
                        direction: DismissDirection.endToStart,
                        background: Container(
                          color: Colors.red,
                          alignment: Alignment.centerRight,
                          padding: EdgeInsets.symmetric(horizontal: 10.0),
                          child: Icon(
                            Icons.delete_forever,
                            size: 70,
                            color: Colors.white,
                          ),
                        ),
                        key: ValueKey<int>(snapshot.data![index].id!),
                        onDismissed: (DismissDirection direction) async {
                          await handler
                              .deleteStudents(snapshot.data![index].id!);
                          setState(() {
                            snapshot.data!.remove(snapshot.data![index]);
                          });
                        },
                        child: GestureDetector(
                          child: Card(
                            child: Column(
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Row(
                                    children: [
                                      Text(
                                        "Code :",
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold),
                                      ),
                                      Text(snapshot.data![index].code)
                                    ],
                                  ),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Row(
                                    children: [
                                      Text(
                                        "Name :",
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold),
                                      ),
                                      Text(snapshot.data![index].name)
                                    ],
                                  ),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Row(
                                    children: [
                                      Text(
                                        "Dept :",
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold),
                                      ),
                                      Text(snapshot.data![index].dept)
                                    ],
                                  ),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(8.0),
                                  child: Row(
                                    children: [
                                      Text(
                                        "Phone :",
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold),
                                      ),
                                      Text(snapshot.data![index].phone)
                                    ],
                                  ),
                                )
                              ],
                            ),
                          ),
                          onTap: () {
                            Navigator.push(context,
                                MaterialPageRoute(builder: (context) {
                              return UpdateStudents(
                                  rcode: snapshot.data![index].code,
                                  rname: snapshot.data![index].name,
                                  rdept: snapshot.data![index].dept,
                                  rphone: snapshot.data![index].phone);
                            })).then((value) => reloadData());
                          },
                        ));
                  });
            } else {
              return Center(
                child: CircularProgressIndicator(),
              );
            }
          }),
    );
  }

  Future<int> addStudents() async {
    Students firstStudent =
        Students(code: '1111', name: '유비', dept: '컴퓨터공학과', phone: '1111');
    Students secondStudent =
        Students(code: '2222', name: '관우', dept: '심리학과', phone: '2222');
    Students thirdStudent =
        Students(code: '3333', name: '장비', dept: '시각디자인학과', phone: '3333');

    List<Students> listOfStudents = [firstStudent, secondStudent, thirdStudent];
    return await handler.insertStudents(listOfStudents);
  }

  void reloadData() {
    setState(() {
      handler.queryStudents();
    });
  }
} // _MyHomePageState
