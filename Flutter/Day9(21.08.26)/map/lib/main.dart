import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart' as latlng;

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
/*
  서울상상나라	    37.54945787  / 127.0862609
  둘리뮤지엄        37.65243153 / 127.0276397
  서대문형무소역사관	37.57244171 /	126.9595412

  */

  int _kindChoice = 0;

  // Segment Widget
  Map<int, Widget> segmentWidgets = {
    0: SizedBox(
      child: Text(
        '서울상상나라',
        textAlign: TextAlign.center,
        style: TextStyle(fontSize: 12),
      ),
    ),
    1: SizedBox(
      child: Text(
        '둘리뮤지엄',
        textAlign: TextAlign.center,
        style: TextStyle(fontSize: 12),
      ),
    ),
    2: SizedBox(
      child: Text(
        '서대문형무소역사관',
        textAlign: TextAlign.center,
        style: TextStyle(fontSize: 12),
      ),
    ),
  };

  double latData = 37.54945787;
  double longData = 127.0862609;

  MapController mapController = MapController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.amber[50],
        title: Center(
          child: Column(
            children: [
              CupertinoSegmentedControl(
                  groupValue: _kindChoice,
                  children: segmentWidgets,
                  onValueChanged: (value) {
                    setState(() {
                      _kindChoice = value as int;
                      if (_kindChoice == 0) {
                        latData = 37.54945787;
                        longData = 127.0862609;
                        mapController.move(
                            latlng.LatLng(latData, longData), 16.0);
                      } else if (_kindChoice == 1) {
                        latData = 37.65243153;
                        longData = 127.0276397;
                        mapController.move(
                            latlng.LatLng(latData, longData), 16.0);
                      } else {
                        latData = 37.57244171;
                        longData = 126.9595412;
                        mapController.move(
                            latlng.LatLng(latData, longData), 16.0);
                      }
                    });
                  })
            ],
          ),
        ),
        toolbarHeight: 100,
      ),
      body: Center(
        child: Column(children: [
          Container(
            child: fluttermap(),
            width: 300,
            height: 300,
          ),
        ]),
      ),
    );
  }

  Widget fluttermap() {
    return FlutterMap(
      mapController: mapController,
      options: MapOptions(center: latlng.LatLng(latData, longData), zoom: 16.0),
      layers: [
        TileLayerOptions(
          urlTemplate: "http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
          subdomains: ['a', 'b', 'c'],
        ),
        MarkerLayerOptions(markers: [
          Marker(
              width: 80.0,
              height: 80.0,
              point: latlng.LatLng(latData, longData),
              builder: (ctx) => Container(
                    child: Icon(
                      Icons.pin_drop_rounded,
                      size: 30.0,
                      color: Colors.red,
                    ),
                  ))
        ])
      ],
    );
  }
}//<<
