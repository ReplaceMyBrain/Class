import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert'; // for json

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
      home: Insert(),
    );
  }
}

class Insert extends StatefulWidget {
  const Insert({Key? key}) : super(key: key);

  @override
  _InsertState createState() => _InsertState();
}

class _InsertState extends State<Insert> {
  final codeComtroller = TextEditingController();
  final nameComtroller = TextEditingController();
  final deptComtroller = TextEditingController();
  final phoneComtroller = TextEditingController();
  late String result;
  late String code;
  late String name;
  late String dept;
  late String phone;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Insert & retrun for CRUD"),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: codeComtroller,
              decoration: InputDecoration(labelText: "학번을 입력하세요"),
              keyboardType: TextInputType.text,
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: nameComtroller,
              decoration: InputDecoration(labelText: "성명을 입력하세요"),
              keyboardType: TextInputType.text,
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: deptComtroller,
              decoration: InputDecoration(labelText: "전공을 입력하세요"),
              keyboardType: TextInputType.text,
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: phoneComtroller,
              decoration: InputDecoration(labelText: "전화번호를 입력하세요"),
              keyboardType: TextInputType.number,
            ),
          ),
          ElevatedButton(
            onPressed: () {
              setState(() {
                getJSONData();
              });
            },
            child: Text("입력"),
          )
        ],
      ),
    );
  }

  void _showAlert(BuildContext context) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text("입력결과"),
          content: Text('입력이 완료되었습니다'),
          actions: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.blue),
              ),
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text("OK"),
            ),
          ],
        );
      },
    );
  }

  void _showSnackBar(BuildContext context) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text("사용자 정보 입력에 문제가 발생 하였습니다."),
        duration: Duration(seconds: 2),
        backgroundColor: Colors.red,
      ),
    );
  }

  Future<String> getJSONData() async {
    code = codeComtroller.text;
    name = nameComtroller.text;
    dept = deptComtroller.text;
    phone = phoneComtroller.text;

    var url = Uri.parse(
        "http://localhost:8080/Flutter/student_insert_return_flutter.jsp?code=${code}&name=${name}&dept=${dept}&phone=${phone}");
    var response = await http.get(url);
    print(response.body);
    print(url);
    setState(() {
      var dataConvertedJSON = json.decode(utf8.decode(response.bodyBytes));
      result = dataConvertedJSON['result'];
      print(result);
    });
    if (result == "OK") {
      _showAlert(context);
    } else {
      _showSnackBar(context);
    }

    return "s";
  }
}
