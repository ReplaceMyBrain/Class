import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert'; // for json

class UpdateStudent extends StatefulWidget {
  final String rcode;
  final String rname;
  final String rdept;
  final String rphone;

  const UpdateStudent(
      {Key? key,
      required this.rcode,
      required this.rname,
      required this.rdept,
      required this.rphone})
      : super(key: key);

  @override
  _UpdateStudentState createState() =>
      _UpdateStudentState(rcode, rname, rdept, rphone);
}

class _UpdateStudentState extends State<UpdateStudent> {
  TextEditingController codeController = TextEditingController();
  TextEditingController nameController = TextEditingController();
  TextEditingController deptController = TextEditingController();
  TextEditingController phoneController = TextEditingController();

  // Create Constructor
  _UpdateStudentState(String rcode, String rname, String rdept, String rphone) {
    this.code = rcode;
    this.name = rname;
    this.dept = rdept;
    this.phone = rphone;
  }

  late String code;
  late String name;
  late String dept;
  late String phone;
  late String result;

  @override
  void initState() {
    super.initState();
    codeController.text = this.code;
    nameController.text = this.name;
    deptController.text = this.dept;
    phoneController.text = this.phone;
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        FocusScope.of(context).unfocus();
      },
      child: Scaffold(
        appBar: AppBar(
          title: Text("Update for CRUD"),
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
                      decoration: InputDecoration(labelText: '학번 입니다.'),
                      readOnly: true,
                      keyboardType: TextInputType.text,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextField(
                      controller: nameController,
                      decoration: InputDecoration(labelText: '성명을 수정하세요'),
                      keyboardType: TextInputType.text,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextField(
                      controller: deptController,
                      decoration: InputDecoration(labelText: '전공을 수정하세요'),
                      keyboardType: TextInputType.text,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextField(
                      controller: phoneController,
                      decoration: InputDecoration(labelText: '전화번호을 수정하세요'),
                      keyboardType: TextInputType.phone,
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
                        // _showDialog(context);
                      },
                      child: Text('수정')),
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
        'http://localhost:8080/Flutter/student_update_return_flutter.jsp?code=$code&name=$name&dept=$dept&phone=$phone');
    var response = await http.get(url);
    setState(() {
      var dataConvertedJSON = json.decode(utf8.decode(response.bodyBytes));
      result = dataConvertedJSON['result'];
    });
    if (result == 'OK') {
      _showDialog(context);
    } else {
      errorSnackBar(context);
    }
  }
}

void _showDialog(BuildContext context) {
  showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text("수정 결과"),
          content: Text("수정이 완료 되었습니다."),
          actions: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.blue),
              ),
              onPressed: () {
                Navigator.of(context).pop();
                Navigator.pop(context); // Main화면으로 이동
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
