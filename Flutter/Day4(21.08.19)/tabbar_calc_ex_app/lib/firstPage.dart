import 'package:flutter/material.dart';

class FirstPage extends StatefulWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  _FirstPageState createState() => _FirstPageState();
}

class _FirstPageState extends State<FirstPage> {
  TextEditingController input1 = TextEditingController();
  TextEditingController input2 = TextEditingController();
  int num1 = 0;
  int num2 = 0;
  String result = "";

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        FocusScope.of(context).unfocus(); // 아무곳 눌렀을때 키보드 내려가기
      },
      child: Scaffold(
        // appBar: AppBar(
        //   title: Text("덧셈 구하기"),
        // ),
        body: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Center(
            child: Column(
              children: [
                TextField(
                  controller: input1,
                  decoration: InputDecoration(labelText: "첫번째 숫자를 입력하세요"),
                  keyboardType: TextInputType.number,
                ),
                TextField(
                  controller: input2,
                  decoration: InputDecoration(labelText: "두번째 숫자를 입력하세요"),
                  keyboardType: TextInputType.number,
                ),
                ElevatedButton(
                  onPressed: () {
                    setState(() {
                      if (input1.text.isEmpty || input2.text.isEmpty) {
                        errorSnackBar(context);
                        result = "";
                      } else {
                        num1 = int.parse(input1.text);
                        num2 = int.parse(input2.text);
                        result = "입력하신 숫자의 합은 ${num1 + num2}입니다";
                      }
                    });
                  },
                  child: Text("덧셈계산"),
                ),
                Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Text(
                    "$result",
                    style: TextStyle(color: Colors.red, fontSize: 20),
                  ),
                )
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
      content: Text("숫자를 입력하세요!"),
      duration: Duration(seconds: 2),
      backgroundColor: Colors.red,
    ),
  );
}
