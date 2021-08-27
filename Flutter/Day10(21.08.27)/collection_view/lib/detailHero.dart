import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class DetailHero extends StatefulWidget {
  final String hero;
  const DetailHero({Key? key, required this.hero}) : super(key: key);

  @override
  _DetailHeroState createState() => _DetailHeroState(hero);
}

class _DetailHeroState extends State<DetailHero> {
  late String hero;
  _DetailHeroState(String hero) {
    this.hero = hero;
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        navigationBar: CupertinoNavigationBar(
          leading: CupertinoNavigationBarBackButton(
            previousPageTitle: "삼국지인물",
            onPressed: () {
              Navigator.pop(context);
            },
          ),
          middle: Text('인물보기'),
        ),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [Text(hero)],
          ),
        ),
      ),
    );
  }
}
