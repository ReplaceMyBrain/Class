import 'package:flutter/material.dart';
import 'package:listview_ex_app/countryIitem.dart';

class SecondPage extends StatefulWidget {
  final List<country> list;
  const SecondPage({Key? key, required this.list}) : super(key: key);

  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  final nameController = TextEditingController();
  var _imagePath;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Container(
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                TextField(
                  controller: nameController,
                  decoration: InputDecoration(labelText: "나라를 입력하세요"),
                  keyboardType: TextInputType.text,
                  maxLines: 1,
                ),
                Container(
                  height: 100,
                  child: ListView(
                    scrollDirection: Axis.horizontal,
                    children: [
                      GestureDetector(
                        child: Image.asset(
                          "images/america.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/america.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/austria.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/austria.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/belgium.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/belgium.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/canada.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/canada.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/estonia.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/estonia.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/france.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/france.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/france.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/germany.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/greece.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/greece.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/hungary.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/hungary.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/italy.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/italy.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/korea.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/korea.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/latvia.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/latvia.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/lithuania.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/lithuania.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/luxemburg.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/luxemburg.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/netherland.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/netherland.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/romania.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/romania.png";
                        },
                      ),
                      GestureDetector(
                        child: Image.asset(
                          "images/turkey.png",
                          width: 80,
                        ),
                        onTap: () {
                          _imagePath = "images/turkey.png";
                        },
                      ),
                    ],
                  ),
                ),
                ElevatedButton(
                    style: ButtonStyle(
                      backgroundColor: MaterialStateProperty.all(Colors.blue),
                    ),
                    onPressed: () {
                      var countrys = country(
                          countryName: nameController.text,
                          imagePath: _imagePath);
                      AlertDialog dialog = AlertDialog(
                        title: Text("문제 추가하기"),
                        content: Text(
                          "이 나라의 이름은 ${countrys.countryName} 입니다.\n"
                          "이 문제를 추가하시겠습니까?",
                          style: TextStyle(fontSize: 17.0),
                        ),
                        actions: [
                          ElevatedButton(
                              style: ButtonStyle(
                                backgroundColor:
                                    MaterialStateProperty.all(Colors.blue),
                              ),
                              onPressed: () {
                                widget.list.add(countrys);
                                Navigator.of(context).pop();
                              },
                              child: Text("에")),
                          ElevatedButton(
                              style: ButtonStyle(
                                backgroundColor:
                                    MaterialStateProperty.all(Colors.blue),
                              ),
                              onPressed: () {
                                Navigator.of(context).pop();
                              },
                              child: Text("아니요")),
                        ],
                      );
                      showDialog(
                          context: context,
                          builder: (BuildContext context) {
                            return dialog;
                          });
                    },
                    child: Text("문제 추가하기")),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
