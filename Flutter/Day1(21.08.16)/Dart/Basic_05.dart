import 'Basic_04.dart';

void main() async{ // async 가 있어야 await 가 들어갈 수 있음 (main에는 Future를 적지 않음)
  // value 가 나타나면 value를 출력 하겠다는 의미
  // 화면이 새로 다시 돌아왔을 때 db를 새로 읽을 경우 then을 많이 사용
  await getVersionName().then((value) => {print(value)});
  print("end process");
}

Future<String> getVersionName() async {
  var versionName = await lookUpVersionName();
  return versionName;
}

String lookUpVersionName() {
  return "Flutter";
}