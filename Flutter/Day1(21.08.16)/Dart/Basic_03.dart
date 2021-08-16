void main() {
  // 베열 선언
  List threeKingdoms = [];
  threeKingdoms.add("위");
  threeKingdoms.add("촉");
  threeKingdoms.add("오");

  print(threeKingdoms);

  // 변경
  threeKingdoms[0] = "We";
  print(threeKingdoms);

  // 삭제
  // remove 는 Data 값
  threeKingdoms.remove("We");
  print(threeKingdoms);
  // removeAt 은 몇 번지
  threeKingdoms.removeAt(0);
  print(threeKingdoms);
  // 배열 개수 파악
  print(threeKingdoms.length);
  
  // List는 타입 없음 (문자든 숫자든 다 넣을 수 있음)
  threeKingdoms.add(1);
  threeKingdoms.add(2);
  print(threeKingdoms);

  // <> Generic 있으면 해당 데이터 타입만 들어갈 수 있음
  List<String> threeKingdoms2 = [];
  threeKingdoms2.add("위");
  threeKingdoms2.add("촉");

  // 홑따옴표 쌍따옴표 둘 중 아무거나 사용해도 됨
  List<String> threeKingdoms3 = ['위', '촉', '오'];
  print(threeKingdoms3);

  // Map 은 키와 value 값이 있음 (dictionary 라고 생각)
  Map<String, int> fruitPrice = {
    'apple': 1000,
    'grape' : 2000,
    'watermelon': 3000
  };

  print(fruitPrice['apple']);

  // Optional : Null Safety
  int num1 = 10;
  // int num1; -> 불가능
  int? num2 = null;
  // int num2; -> 가능
  // ??= 의 의미는 num2가 null 이면 num2는 8이다!
  // num2 = 2 -> print num2 시 2로 나옴!
  num2 ??= 8;
  print(num2);

  List<int> list1 = [1, 3, 5, 7, 9];
  int sum = 0;
  // for 문 사용 시 범위로 쓸 수 있고 자바처럼 for 문 사용하는 것도 가능함!
  for(int i in list1) {
    sum += i;
  }

  print("합계 : $sum");
}