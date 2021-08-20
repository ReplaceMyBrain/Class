import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Mail(),
    );
  }
}

class Mail extends StatelessWidget {
  const Mail({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Drawer"),
        centerTitle: true,
        actions: [
          IconButton(
              onPressed: () {
                print("Shopping cart is clicked");
              },
              icon: Icon(Icons.shopping_cart)),
          IconButton(
              onPressed: () {
                print("Search cart is clicked");
              },
              icon: Icon(Icons.search)),
        ],
      ),
      drawer: Drawer(
        child: ListView(
          children: [
            UserAccountsDrawerHeader(
              currentAccountPicture: CircleAvatar(
                backgroundImage: AssetImage("images/p1.png"),
                backgroundColor: Colors.white,
              ),
              accountName: Text('Pikachu'),
              accountEmail: Text('Pikachu@naver.com'),
              onDetailsPressed: () {
                print("main page is clicked");
              },
              decoration: BoxDecoration(
                color: Colors.red[400],
                borderRadius: BorderRadius.only(
                  bottomLeft: Radius.circular(40.0),
                  bottomRight: Radius.circular(40.0),
                ),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.email_rounded,
                color: Colors.blue,
              ),
              title: Text('보낸편지함'),
              onTap: () {
                Navigator.pushNamed(context, '/SendMail');
              },
            ),
            ListTile(
              leading: Icon(
                Icons.email_outlined,
                color: Colors.red,
              ),
              title: Text('받은 편지함'),
              onTap: () {
                Navigator.pushNamed(context, '/ReceiveMail');
              },
            ),
          ],
        ),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.green),
              ),
              onPressed: () {
                Navigator.pushNamed(context, '/SendMail');
              },
              child: Text("보낸편지함"),
            ),
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.red),
              ),
              onPressed: () {
                Navigator.pushNamed(context, '/ReceiveMail');
              },
              child: Text("받은 편지함"),
            ),
          ],
        ),
      ),
    );
  }
}
