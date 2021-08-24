import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      title: 'Flutter Demo',
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
  TextEditingController? num1;
  TextEditingController? num2;
  TextEditingController? add;
  TextEditingController? sub;
  TextEditingController? mul;
  TextEditingController? div;

  String result = "환영합니다!";

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    num1 = TextEditingController();
    num2 = TextEditingController();
    add = TextEditingController();
    sub = TextEditingController();
    mul = TextEditingController();
    div = TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Padding(
                padding: const EdgeInsets.only(bottom: 50),
                child: Text(
                  "두개의 숫자연산",
                  style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30),
                ),
              ),
              Column(
                children: [
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('첫번째 숫자 :'),
                          width: 90,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: num1,
                            keyboardType: TextInputType.number,
                            maxLines: 1,
                            placeholder: '숫자를 입력하세요!',
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('두번째 숫자 :'),
                          width: 90,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: num2,
                            keyboardType: TextInputType.number,
                            maxLines: 1,
                            placeholder: '숫자를 입력하세요!',
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  CupertinoButton(
                      child: Text('계산하기'),
                      onPressed: () {
                        setState(() {
                          if (num1!.text.isEmpty || num2!.text.isEmpty) {
                            result = "숫자를 입력하세요";
                          } else {
                            int int1 = int.parse(num1!.text);
                            int int2 = int.parse(num2!.text);
                            add!.text = (int1 + int2).toString();
                            sub!.text = (int1 - int2).toString();
                            mul!.text = (int1 * int2).toString();
                            div!.text = (int1 / int2).toString();
                            result = "계산이 완료되었습니다";
                          }
                        });
                      }),
                  SizedBox(
                    height: 20,
                  ),
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('덧셈결과 :'),
                          width: 90,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: add,
                            keyboardType: TextInputType.text,
                            readOnly: true,
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('뺄셈결과 :'),
                          width: 90,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: sub,
                            keyboardType: TextInputType.text,
                            readOnly: true,
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('곱셈결과 :'),
                          width: 90,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: mul,
                            keyboardType: TextInputType.text,
                            readOnly: true,
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          child: Text('나눗셈 결과 :'),
                          width: 90,
                        ),
                        Container(
                          child: CupertinoTextField(
                            controller: div,
                            keyboardType: TextInputType.text,
                            readOnly: true,
                            textAlign: TextAlign.right,
                          ),
                          width: 150,
                        ),
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 30,
                  ),
                  Text(
                    "$result",
                    style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                        color: Colors.red),
                  )
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}
