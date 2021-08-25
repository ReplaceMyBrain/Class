import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
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
  final Completer<WebViewController> _webViewController =
      Completer<WebViewController>();

  bool isLoading = true; // for indicator
  TextEditingController textController = TextEditingController();
  String site = "http://www.daum.net";
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        toolbarHeight: 130,
        backgroundColor: Colors.amber[100],
        title: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                Container(
                  width: 300,
                  child: CupertinoTextField(
                    controller: textController,
                    keyboardType: TextInputType.text,
                  ),
                ),
                Container(
                    width: 70,
                    child: CupertinoButton(
                        child: Text("Go"),
                        onPressed: () {
                          setState(() {
                            site = "http://" + textController.text;
                            print(site);
                            _webViewController.future
                                .then((value) => value.loadUrl(site));
                          });
                        })),
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                CupertinoButton(
                    child: Text("Google"),
                    onPressed: () {
                      setState(() {
                        _webViewController.future.then((value) =>
                            value.loadUrl("https://www.google.com/"));
                      });
                    }),
                CupertinoButton(
                    child: Text("Naver"),
                    onPressed: () {
                      setState(() {
                        _webViewController.future.then(
                            (value) => value.loadUrl("https://www.naver.com/"));
                      });
                    }),
              ],
            )
          ],
        ),
      ),
      body: Center(
        child: Stack(
          children: [
            WebView(
              initialUrl: site,
              javascriptMode: JavascriptMode.unrestricted,
              onWebViewCreated: (WebViewController webViewController) {
                _webViewController.complete(webViewController);
              },
              onPageFinished: (finish) {
                setState(() {
                  isLoading = false;
                });
              },
              onPageStarted: (start) {
                setState(() {
                  isLoading = true;
                });
              },
            ),
            isLoading
                ? Center(
                    child: CupertinoActivityIndicator(
                    radius: 20.0,
                  ))
                : Stack(),
          ],
        ),
      ),
      persistentFooterButtons: [
        Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              IconButton(
                onPressed: () {},
                icon: Icon(Icons.stop),
                color: Colors.blue,
              ),
              SizedBox(
                width: 15,
              ),
              IconButton(
                onPressed: () {
                  // _webViewController!.reload();
                  setState(() {
                    _webViewController.future
                        .then((value) => value.loadUrl(site));
                  });
                },
                icon: Icon(Icons.replay),
                color: Colors.blue,
              ),
              SizedBox(
                width: 15,
              ),
              navigationButton(
                  Icons.fast_rewind, (controller) => goBack(controller)),
              SizedBox(
                width: 15,
              ),
              navigationButton(
                  Icons.fast_forward, (controller) => goForward(controller))
            ],
          ),
        )
      ],
      backgroundColor: Colors.amber[50],
    );
  }

  Widget navigationButton(
      IconData icon, Function(WebViewController) onPressed) {
    return FutureBuilder(
        future: _webViewController.future,
        builder: (context, AsyncSnapshot<WebViewController> snapshot) {
          if (snapshot.hasData) {
            return IconButton(
                icon: Icon(
                  icon,
                  color: Colors.blue,
                ),
                onPressed: () => onPressed(snapshot.data!));
          } else {
            return Container();
          }
        });
  }

  void goBack(WebViewController controller) async {
    final canGoBack = await controller.canGoBack();

    if (canGoBack) {
      await controller.goBack();
    }
  }

  void goForward(WebViewController controller) async {
    final canGoForward = await controller.canGoForward();

    if (canGoForward) {
      await controller.goForward();
    }
  }
}
