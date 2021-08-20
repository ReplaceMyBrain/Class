import 'package:flutter/material.dart';
import 'package:listview_ex_app/countryIitem.dart';

class FirstPage extends StatelessWidget {
  final List<country> list;
  const FirstPage({Key? key, required this.list}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // appBar: AppBar(
      //   title: Text("First Page"),
      // ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: ListView.builder(
            itemBuilder: (context, position) {
              return GestureDetector(
                child: Card(
                  child: Row(
                    children: [
                      Image.asset(
                        list[position].imagePath,
                        height: 100,
                        width: 100,
                        fit: BoxFit.contain,
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(10, 0, 0, 0),
                        child: Text("${list[position].countryName[0]}____"),
                      )
                    ],
                  ),
                ),
                onTap: () {
                  _showDialog(context, list[position].countryName);
                },
              );
            },
            itemCount: list.length,
          ),
        ),
      ),
    );
  }
}

void _showDialog(BuildContext context, String countryName) {
  showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text("국가명"),
          content: Text("이 국가는 $countryName 입니다."),
          actions: [
            ElevatedButton(
                style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.teal)),
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: Text("종료")),
          ],
        );
      });
}
