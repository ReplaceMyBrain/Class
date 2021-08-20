import 'package:flutter/material.dart';

class SecondPage extends StatefulWidget {
  const SecondPage({Key? key}) : super(key: key);

  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  TextEditingController input1 = TextEditingController();
  TextEditingController input2 = TextEditingController();
  int num1 = 0;
  int num2 = 0;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        FocusScope.of(context).unfocus(); // 아무곳 눌렀을때 키보드 내려가기
      },
      child: Scaffold(
        // appBar: AppBar(
        //   title: Text("간단한 덧셈 계산기"),
        // ),
        body: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Center(
            child: Column(
              children: [
                Text("덧셈결과 : ${num1 + num2}"),
                TextField(
                  controller: input1,
                  keyboardType: TextInputType.number,
                ),
                TextField(
                  controller: input2,
                  keyboardType: TextInputType.number,
                ),
                ElevatedButton(
                  onPressed: () {
                    setState(() {
                      if (input1.text.isEmpty || input2.text.isEmpty) {
                        errorSnackBar(context);
                      }
                      num1 = int.parse(input1.text);
                      num2 = int.parse(input2.text);
                    });
                  },
                  child: Row(
                    children: [
                      Icon(Icons.add),
                      SizedBox(
                        width: 20,
                      ),
                      Text("덧셈계산"),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

void errorSnackBar(BuildContext context) {
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      content: Text("글자를 입력하세요!"),
      duration: Duration(seconds: 2),
      backgroundColor: Colors.red,
    ),
  );
}
