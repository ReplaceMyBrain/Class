import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

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
  TextEditingController inputNum1 = TextEditingController();
  TextEditingController inputNum2 = TextEditingController();
  int num1 = 0;
  int num2 = 0;

  TextEditingController add = TextEditingController();
  TextEditingController sub = TextEditingController();
  TextEditingController mul = TextEditingController();
  TextEditingController div = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        FocusScope.of(context).unfocus();
      },
      child: Scaffold(
        appBar: AppBar(
          title: Text('간단한 계산기'),
        ),
        body: SingleChildScrollView(
          // 키보드가 걸릴경우 이것만 추가해주면 끝!
          child: Center(
            child: Padding(
              padding: const EdgeInsets.all(20.0),
              child: Column(
                children: [
                  TextField(
                    controller: inputNum1,
                    decoration: InputDecoration(labelText: '첫번째 숫자를 입력하세요'),
                    keyboardType: TextInputType.number,
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  TextField(
                    controller: inputNum2,
                    decoration: InputDecoration(labelText: '첫번째 숫자를 입력하세요'),
                    keyboardType: TextInputType.number,
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      ElevatedButton(
                          onPressed: () {
                            num1 = int.parse(inputNum1.text);
                            num2 = int.parse(inputNum2.text);
                            setState(() {
                              add.text = "${num1 + num2}";
                              sub.text = "${num1 - num2}";
                              mul.text = "${num1 * num2}";
                              div.text = "${num1 / num2}";
                            });
                          },
                          child: Text("계산하기")),
                      SizedBox(
                        width: 30,
                      ),
                      ElevatedButton(
                        onPressed: () {
                          setState(() {
                            inputNum1.text = "";
                            inputNum2.text = "";
                            add.text = "";
                            sub.text = "";
                            mul.text = "";
                            div.text = "";
                          });
                        },
                        child: Text("지우기"),
                        style: ButtonStyle(
                            backgroundColor:
                                MaterialStateProperty.all(Colors.redAccent)),
                      ),
                    ],
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  TextField(
                    controller: add,
                    decoration: InputDecoration(labelText: '덧셈결과'),
                    readOnly: true,
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  TextField(
                    controller: sub,
                    decoration: InputDecoration(labelText: '뺄셈결과'),
                    readOnly: true,
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  TextField(
                    controller: mul,
                    decoration: InputDecoration(labelText: '곱셈결과'),
                    readOnly: true,
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  TextField(
                    controller: div,
                    decoration: InputDecoration(labelText: '나눗셈결과'),
                    readOnly: true,
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}

void calc(String num1, String num2) {}

void clear() {}
