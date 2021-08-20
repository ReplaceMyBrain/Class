import 'package:flutter/material.dart';
import 'package:listview_ex_app/countryIitem.dart';
import 'package:listview_ex_app/firstPage.dart';
import 'package:listview_ex_app/secondPage.dart';

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

class _MyHomePageState extends State<MyHomePage>
    with SingleTickerProviderStateMixin {
  //tabbar임
  late TabController controller;
  List<country> countryList = [];

  @override
  void initState() {
    // 켜질때
    // TODO: implement initState
    super.initState();
    controller = TabController(length: 2, vsync: this);

    countryList
        .add(country(countryName: "america", imagePath: "images/america.png"));
    countryList
        .add(country(countryName: "austria", imagePath: "images/austria.png"));
    countryList
        .add(country(countryName: "belgium", imagePath: "images/belgium.png"));
    countryList
        .add(country(countryName: "canada", imagePath: "images/canada.png"));
    countryList
        .add(country(countryName: "estonia", imagePath: "images/estonia.png"));
    countryList
        .add(country(countryName: "france", imagePath: "images/france.png"));
    countryList
        .add(country(countryName: "germany", imagePath: "images/germany.png"));
    countryList
        .add(country(countryName: "greece", imagePath: "images/greece.png"));
    countryList
        .add(country(countryName: "hungary", imagePath: "images/hungary.png"));
    countryList
        .add(country(countryName: "italy", imagePath: "images/italy.png"));
    countryList
        .add(country(countryName: "korea", imagePath: "images/korea.png"));
    countryList
        .add(country(countryName: "latvia", imagePath: "images/latvia.png"));
    countryList.add(
        country(countryName: "lithuania", imagePath: "images/lithuania.png"));
    countryList.add(
        country(countryName: "luxemburg", imagePath: "images/luxemburg.png"));
    countryList.add(
        country(countryName: "netherland", imagePath: "images/netherland.png"));
    countryList
        .add(country(countryName: "romania", imagePath: "images/romania.png"));
    countryList
        .add(country(countryName: "turkey", imagePath: "images/turkey.png"));
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
        title: Text("국가명 맞추기"),
      ),
      body: TabBarView(
        children: [
          FirstPage(
            list: countryList,
          ),
          SecondPage(
            list: countryList,
          ),
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
