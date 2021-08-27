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
  List map = [
    ["혜화문", 37.5878892, 127.0037098],
    ["홍인지문", 37.5711907, 127.009506],
    ["창의문", 37.5926027, 126.9664771],
    ["숙정문", 37.5956584, 126.9810576]
  ];

  List<Marker> markers = [];

  MapController mapController = MapController();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    makeMarker();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: fluttermap(),
    );
  }

  Widget fluttermap() {
    return FlutterMap(
      mapController: mapController,
      options: MapOptions(
          center: latlng.LatLng(37.5878892, 127.0037098), zoom: 13.0),
      layers: [
        TileLayerOptions(
          urlTemplate: "http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
          subdomains: ['a', 'b', 'c'],
        ),
        MarkerLayerOptions(
          markers: markers,
        ),
      ],
    );
  }

  void makeMarker() {
    for (var i = 0; i < map.length; i++) {
      Marker marker = Marker(
        width: 80.0,
        height: 80.0,
        point: latlng.LatLng(map[i][1], map[i][2]),
        builder: (ctx) => Container(
            child: Column(
          children: [
            Text(map[i][0]),
            Icon(
              Icons.pin_drop,
              size: 50,
              color: i % 2 == 0 ? Colors.blue : Colors.red,
            ),
          ],
        )),
      );
      setState(() {
        markers.add(marker);
      });
    }
  }
}
