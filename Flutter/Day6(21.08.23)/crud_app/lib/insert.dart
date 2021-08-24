import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert'; // for

class Insert extends StatefulWidget {
  const Insert({Key? key}) : super(key: key);

  @override
  _InsertState createState() => _InsertState();
}

class _InsertState extends State<Insert> {
  TextEditingController codeController = TextEditingController();
  TextEditingController nameController = TextEditingController();
  TextEditingController deptController = TextEditingController();
  TextEditingController phoneController = TextEditingController();

  late String code;
  late String name;
  late String dept;
  late String phone;
  late String result;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        FocusScope.of(context).unfocus();
      },
      child: Scaffold(
        appBar: AppBar(
          title: Text("Insert & return for CRUD"),
        ),
        body: SingleChildScrollView(
          child: Center(
            child: Padding(
              padding: const EdgeInsets.all(30.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextField(
                      controller: codeController,
                      decoration: InputDecoration(labelText: '학번을 입력하세요'),
                      keyboardType: TextInputType.text,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextField(
                      controller: nameController,
                      decoration: InputDecoration(labelText: '성명을 입력하세요'),
                      keyboardType: TextInputType.text,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextField(
                      controller: deptController,
                      decoration: InputDecoration(labelText: '전공을 입력하세요'),
                      keyboardType: TextInputType.text,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextField(
                      controller: phoneController,
                      decoration: InputDecoration(labelText: '전화번호을 입력하세요'),
                      keyboardType: TextInputType.text,
                    ),
                  ),
                  SizedBox(
                    height: 30,
                  ),
                  ElevatedButton(
                      onPressed: () {
                        code = codeController.text.toString();
                        name = nameController.text.toString();
                        dept = deptController.text.toString();
                        phone = phoneController.text.toString();
                        getJSONData();
                      },
                      child: Text('입력')),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }

  void getJSONData() async {
    var url = Uri.parse(
        'http://localhost:8080/Flutter/student_insert_return_flutter.jsp?code=$code&name=$name&dept=$dept&phone=$phone');
    var response = await http.get(url);
    setState(() {
      var dataConvertedJSON = json.decode(utf8.decode(response.bodyBytes));
      result = dataConvertedJSON['result'];
      // print(result);
    });
    if (result == 'OK') {
      _showDialog(context);
    } else {
      errorSnackBar(context);
    }

    // _showDialog(context);
  }
}

void _showDialog(BuildContext context) {
  showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text("입력 결과"),
          content: Text("입력이 완료 되었습니다."),
          actions: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.blue),
              ),
              onPressed: () {
                Navigator.of(context).pop();
                Navigator.pop(context);
              },
              child: Text('OK'),
            ),
          ],
        );
      });
}

void errorSnackBar(BuildContext context) {
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      content: Text('사용자 정보 입력에 문제가 발생 하였습니다.'),
      duration: Duration(seconds: 2),
      backgroundColor: Colors.red,
    ),
  );
}
