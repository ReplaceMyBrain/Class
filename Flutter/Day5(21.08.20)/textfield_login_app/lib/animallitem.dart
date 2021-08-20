class Animal {
  late String imagePath;
  late String animalName;
  late String kind;
  late bool flyExist;

  Animal(
      // map 스타일 구성 (dictionary 스타일 구성)
      {required this.animalName,
      required this.kind,
      required this.imagePath,
      required this.flyExist});
}
