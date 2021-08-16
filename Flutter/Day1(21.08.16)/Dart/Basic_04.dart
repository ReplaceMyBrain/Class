void main() {
  checkVersion();
  print('end process');
}

// 비동기 함수 (Future async await)
Future checkVersion() async {
  print("--------");
  // asynic 는 await 가 존재 (await는 나를 호출한 함수의 기능이 끝날 때까지 대기한다는 것을 의미)
  // await 에 있는 게 asynic
  var version = await lookUpVersion();
  // await 이후의 코드는 main 이 끝난 후, 나옴!
  print("--------");
  print(version);
}

int lookUpVersion() {
  return 12;
}