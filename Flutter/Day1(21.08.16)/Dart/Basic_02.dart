void main() {
  String str = "abc";
  print(str);

  var name = "def";
  print(name);

  // 문자열 보간법
  int intNum1 = 179;
  int intNum2 = 70;

  print("intNum1과 intNum2의 합은 $intNum1 + $intNum2 입니다.");
  print("intNum1과 intNum2의 합은 ${intNum1 + intNum2} 입니다.");

  dynamic name1 = "장비";
  print(name1);

  name1 = 10;
  print(name1);
}
