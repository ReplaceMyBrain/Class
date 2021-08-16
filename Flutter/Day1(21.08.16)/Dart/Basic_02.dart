void main() {
  String str = "abc";
  print(str);

  // type을 모를 때 사용하는 게 var
  var name = "def";
  print(name);

  // 문자열 보간법
  int intNum1 = 179;
  int intNum2 = 70;

  print("intNum1과 intNum2의 합은 $intNum1 + $intNum2 입니다.");
  print("intNum1과 intNum2의 합은 ${intNum1 + intNum2} 입니다.");

  // dynamic type은 문자나 숫자 모두 사용가능하나, 권장하지 않음 (var를 많이 사용)
  dynamic name1 = "장비";
  print(name1);

  name1 = 10;
  print(name1);
}