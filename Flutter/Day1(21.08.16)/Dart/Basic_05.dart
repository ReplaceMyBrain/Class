void main() async {
  await getVersionName().then((value) => {print(value)}); // 
  print("end process");
}

Future<String> getVersionName() async {
  var versionName = await lookupVersionName();
  return versionName;
}

String lookupVersionName() {
  return "Flutter";
}
