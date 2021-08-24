import 'package:crud_app/delete.dart';
import 'package:crud_app/insert.dart';
import 'package:crud_app/update.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert'; // for json

class Select extends StatefulWidget {
  const Select({Key? key}) : super(key: key);

  @override
  _SelectState createState() => _SelectState();
}

class _SelectState extends State<Select> {
  String result = '';
  late List data;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    data = [];
    data.clear();
    getJSONData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("CRUD for Students"),
        actions: [
          IconButton(
            icon: Icon(Icons.add_outlined),
            onPressed: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return Insert();
              })).then((value) => getJSONData());
            },
          ),
        ],
      ),
      body: Container(
        child: Center(
          child: data.length == 0
              ? Text(
                  '데이터가 없습니다.',
                  style: TextStyle(fontSize: 20),
                  textAlign: TextAlign.center,
                )
              : Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: GestureDetector(
                    child: ListView.builder(
                      itemBuilder: (context, index) {
                        return GestureDetector(
                          onTap: () {
                            Navigator.push(context,
                                MaterialPageRoute(builder: (context) {
                              return UpdateStudent(
                                  rcode: data[index]['code'].toString(),
                                  rname: data[index]['name'].toString(),
                                  rdept: data[index]['dept'].toString(),
                                  rphone: data[index]['phone'].toString());
                            })).then((value) => getJSONData());
                          },
                          onLongPress: () {
                            Navigator.push(context,
                                MaterialPageRoute(builder: (context) {
                              return Delete(
                                  rcode: data[index]['code'].toString(),
                                  rname: data[index]['name'].toString(),
                                  rdept: data[index]['dept'].toString(),
                                  rphone: data[index]['phone'].toString());
                            })).then((value) => getJSONData());
                          },
                          child: Card(
                            child: Container(
                              child: Column(
                                children: [
                                  Row(
                                    children: [
                                      Text(
                                        "Code : ",
                                        style: TextStyle(
                                            fontSize: 15,
                                            fontWeight: FontWeight.bold),
                                      ),
                                      Text(
                                        data[index]['code'],
                                        style: TextStyle(fontSize: 15),
                                      ),
                                    ],
                                  ),
                                  SizedBox(
                                    height: 10,
                                  ),
                                  Row(
                                    children: [
                                      Text(
                                        "Name : ",
                                        style: TextStyle(
                                            fontSize: 15,
                                            fontWeight: FontWeight.bold),
                                      ),
                                      Text(
                                        data[index]['name'],
                                        style: TextStyle(fontSize: 15),
                                      ),
                                    ],
                                  ),
                                  SizedBox(
                                    height: 10,
                                  ),
                                  Row(
                                    children: [
                                      Text(
                                        "Dept : ",
                                        style: TextStyle(
                                            fontSize: 15,
                                            fontWeight: FontWeight.bold),
                                      ),
                                      Text(
                                        data[index]['dept'],
                                        style: TextStyle(fontSize: 15),
                                      ),
                                    ],
                                  ),
                                  SizedBox(
                                    height: 10,
                                  ),
                                  Row(
                                    children: [
                                      Text(
                                        "Phone : ",
                                        style: TextStyle(
                                            fontSize: 15,
                                            fontWeight: FontWeight.bold),
                                      ),
                                      Text(
                                        data[index]['phone'],
                                        style: TextStyle(fontSize: 15),
                                      ),
                                    ],
                                  ),
                                ],
                              ),
                            ),
                          ),
                        );
                      },
                      itemCount: data.length,
                    ),
                  ),
                ),
        ),
      ),
    );
  }

  Future<String> getJSONData() async {
    data.clear();
    var url =
        Uri.parse('http://localhost:8080/Flutter/student_query_flutter.jsp');
    var response = await http.get(url);

    setState(() {
      var dataConvertedJSON = json.decode(utf8.decode(response.bodyBytes));
      List result = dataConvertedJSON['results'];
      data.addAll(result);
    });

    // return response.body 넣어줘도 가능!!
    return "a";
  }
}
