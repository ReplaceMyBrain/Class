import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

class myToast extends StatelessWidget {
  const myToast({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: ElevatedButton(
          style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Colors.blue)),
          onPressed: () {
            toastAction();
          },
          child: Text("Toast Button")),
    );
  }

  void toastAction() {
    Fluttertoast.showToast(
        msg: "Toast Button is clicked",
        backgroundColor: Colors.black,
        textColor: Colors.white,
        fontSize: 14.0,
        toastLength: Toast.LENGTH_SHORT,
        gravity: ToastGravity.TOP);
  }
}
