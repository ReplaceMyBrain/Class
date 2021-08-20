import 'package:flutter/material.dart';
import 'package:textfield_login_app/animallitem.dart';
import 'package:textfield_login_app/firstPage.dart';
import 'package:textfield_login_app/secondPage.dart';

class home extends StatefulWidget {
  const home({Key? key}) : super(key: key);

  @override
  _homeState createState() => _homeState();
}

class _homeState extends State<home> with SingleTickerProviderStateMixin {
  //tabbar임
  late TabController controller;
  List<Animal> animalList = [];

  @override
  void initState() {
    // 켜질때
    // TODO: implement initState
    super.initState();
    controller = TabController(length: 2, vsync: this);

    animalList.add(Animal(
        animalName: '벌',
        kind: '곤충',
        imagePath: 'images/bee.png',
        flyExist: true));
    animalList.add(Animal(
        animalName: '고양이',
        kind: '포유류',
        imagePath: 'images/cat.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '젖소',
        kind: '포유류',
        imagePath: 'images/cow.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '강아지',
        kind: '포유류',
        imagePath: 'images/dog.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '여우',
        kind: '포유류',
        imagePath: 'images/fox.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '원숭이',
        kind: '포유류',
        imagePath: 'images/monkey.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '돼지',
        kind: '포유류',
        imagePath: 'images/pig.png',
        flyExist: false));
    animalList.add(Animal(
        animalName: '늑대',
        kind: '포유류',
        imagePath: 'images/wolf.png',
        flyExist: false));
  }

  @override
  void dispose() {
    // 죽을때
    // TODO: implement dispose
    controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("list Test"),
      ),
      body: TabBarView(
        children: [
          FirstPage(
            list: animalList,
          ),
          SecondPage(
            list: animalList,
          )
        ],
        controller: controller,
      ),
      bottomNavigationBar: TabBar(
        labelColor: Colors.blueAccent,
        tabs: [
          Tab(
            icon: Icon(
              Icons.looks_one,
              color: Colors.blue,
            ),
            text: 'Page #1',
          ),
          Tab(
            icon: Icon(
              Icons.looks_two,
              color: Colors.red,
            ),
            text: 'Page #1',
          ),
        ],
        controller: controller,
      ),
    );
  }
}
