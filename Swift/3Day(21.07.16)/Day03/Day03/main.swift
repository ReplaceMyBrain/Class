//
//  main.swift
//  Day03
//
//  Created by RayAri on 2021/07/16.
//

import Foundation

// Dicitionary
// Key와 Value로 구성됨

// key : String, value : Int 로 쓸꺼야 = 데이터는 이렇게 만들어줘!
var scoreDictionary1: Dictionary<String, Int> = [String: Int]() // 가장 표준 타입
var scoreDictionary2: [String: Int] = [:] // 이렇게 많이 사용함!
// Dictionary는 순서가 없다! (append 이런거 불가능)
// 순서가 Dictionary에서는 key라고 생각하기!
scoreDictionary2["유비"] = 100
scoreDictionary2["관우"] = 90
scoreDictionary2["장비"] = 80
print(scoreDictionary2)

// 초기값을 가지는 Dictionary
let initializedDictionary: [String: String] = ["name":"James", "gender":"male"]
print(initializedDictionary)

// Set
// Set은 집합연산에 사용되고, 중복 데이터를 적용하지 않는다.
// 중복 체크할 때 사용하면 좋음!
let oddDigits: Set = [1,3,5,7,9,9,9,9,9,9]
print(oddDigits) // 순서와 상관없이 출력해줌
let evenDigits: Set = [0,2,4,6,8]
let singleDigitPrimeNumbers: Set = [2,3,5,7]

// 합집합 (파이썬에서 했던 것처럼 + 불가능)
print(oddDigits.union(evenDigits))
print(oddDigits.union(evenDigits).sorted()) // 정렬하기

// 교집합
print(oddDigits.intersection(evenDigits).sorted()) // 교집합 없으면 [] 빈 값 출력

// 차집합
print(oddDigits.subtracting(singleDigitPrimeNumbers).sorted())

// Set의 동등 비교
let houseAnimals: Set = ["dog", "cat"]
let farmAnimals: Set = ["cow", "chicken", "sheep", "dog", "cat"]
let cityAnimals: Set = ["duck", "rabbit"]

// farmAnimal의 subset인지 물어보는 것 - 즉, 부분집합인지 물어보는 것 (전체 데이터가 완전하게 포함되어야 true가 나옴)
print(houseAnimals.isSubset(of: farmAnimals))
// 모집합인지 물어보는 것 (위에 것을 거꾸로 물어본 것!)
print(farmAnimals.isSuperset(of: houseAnimals))
// 서로 아무 관련이 없는지 (완전 데이터가 틀린지) 물어보는 것!
print(farmAnimals.isDisjoint(with: cityAnimals))
// set을 검색 시 사용하면 좋음!

// If
var isCar = true
var isNew = true

if isCar, isNew{
    print("New Car")
}

isCar = true
isNew = false

// , 는 and 조건!!!
if isCar, isNew{
    print("New Car")
}else{
    print("Old Car")
}

// switch (ios 는 if 문보다 switch를 많이 사용)
// Before Switch
let personAge = 14
if personAge < 1{
    print("baby")
}else if personAge < 3{
    print("toddler")
}else if personAge < 5{
    print("preschooler")
}else if personAge < 13{
    print("gradeschooler")
}else if personAge < 18{
    print("teen")
}else{
    print("adult")
}

// After using Switch statement (switch 에서 where 도 사용 가능)
// switch는 기본이 흘러내려가지 않는다임! 그래서 break 사용 안해도 됨! (자바와 반대)
switch personAge{
// switch case 에 범위를 줄 수 있음!
case 0..<1:
    print("baby")
case 1..<3:
    print("toddler")
case 3..<5:
    print("preschooler")
case 5..<13:
    print("gradeschooler")
case 13..<18:
    print("teen")
default: // default 안쓰면 오류 걸림
    print("adult")
}

let someInteger = 123456
switch someInteger{
case 0:
    print("zero")
case 1..<100:
    print("1~99")
case 101...Int.max: // 정수가 표현할 수 있는 최대값까지!
    print("over 100")
default:
    print("unknown")
}

print(Int.max) // 9223372036854775807
// Double의 max는 없음! 대신 최대값 찾는 것만 있음
print(Double.maximum(10.0, 20.0))

let aCharacter: Character = "a"
switch aCharacter {
// 여기에서 , 는 or 조건임!
// 나는 소문자 a든 대문자 A든 The letter A 출력할거야!
case "a", "A":
    print("The letter A")
default:
    print("Not the letter A")
}

// 국어, 영어, 수학 함수로 총점 평균을 구하고 등급을 정하기
let name = "유비"
let kor = 91
let eng = 97
let math = 95

var tot = 0
// Int가 큰 범위이기 때문에 데이터 줄 때 0.0이 아닌 0을 줘도 됨!
var avg: Double = 0

tot = kor + eng + math
// 왼쪽에 있는 타입에 맞춰야함! -> avg가 Double이므로 tot를 Double로 바꿔줘야 함
avg = Double(tot) / 3
print(avg)

// 점수 등급 출력
var grade: String

// if 문 이용하여 등급 출력 (ios 에서는 if 문 많이 안씀!)
if avg >= 90{
    grade = "A"
}else if avg >= 80{
    grade = "B"
}else if avg >= 70{
    grade = "C"
}else if avg >= 60{
    grade = "D"
}else if avg >= 50{
    grade = "E"
}else{
    grade = "F"
}

// switch 문을 이용하여 등급 출력
// 비교할 대상 switch 옆에 적고, case에서는 비교할 대상 적지 않고 데이터만 작성
switch avg{
case 90...100:
    grade = "A"
case 80..<90:
    grade = "B"
case 70..<80:
    grade = "C"
case 60..<70:
    grade = "D"
case 50..<60:
    grade = "E"
default:
    grade = "F"
}

// 삼항 연산자를 이용하여 등급 출력
grade = avg >= 90 ? "A" :
        avg >= 80 ? "B" :
        avg >= 70 ? "C" :
        avg >= 60 ? "D" :
        avg >= 50 ? "E" : "F"

// 배열과 반복문
//var score = [90.0, 80.0, 70.0, 60.0, 50.0]
var score = [90, 80, 70, 60, 50]
var level = ["A", "B", "C", "D", "E", "F"]

for i in 0..<score.count{
    if avg >= Double(score[i]){
    // if avg >= score[i]{
        grade = level[i]
        print(grade)
        break
    }
}

// 반복문
let names = ["Anna", "Alex", "Brian", "Jack"]
// 문자의 경우 이런 방식으로 사용하지 않음
for i in 0..<name.count{
    print((names[i]))
}
// 이 방법 사용
for name in names{
    print(name)
}

// Dictionary 반복문 (Dictionary 순서가 없다!)
let numberOfLegs = ["Spider" : 8, "Ant" : 6, "Cat" : 4]
// Tuple 사용
for (animalName, legCount) in numberOfLegs{
    print("\(animalName) have \(legCount) legs")
}

let seq1 = 1...5
for i in seq1{
    print("\(i) * 5 = \(i*5)")
}
// let seq1 = 5...1 // 이렇게 사용 불가능!! 초기값이 작은 값으로 시작해야 함!
for i in seq1.reversed(){ // seq1 순서 반대로 시작
    print("\(i) * 5 = \(i*5)")
}

let minutes = 60
let hourInterval = 5
// stride 함수 사용 : 0부터 minutes까지 증가치는 hourInterval
// 60이 안나옴
for tickMark in stride(from: 0, to: minutes, by: hourInterval){
    print(tickMark)
}
// 60까지 나옴
for tickMark in stride(from: 0, through: minutes, by: hourInterval){
    print(tickMark)
}

for tickMark in stride(from: 0, to: minutes, by: hourInterval).reversed(){
    print(tickMark)
}

for tickMark in stride(from: 0, through: minutes, by: hourInterval).reversed(){
    print(tickMark)
}

// while
var startIndex = 0
var endIndex = 100
var sum = 0

// 0부터 100까지의 합
while startIndex <= endIndex{
    sum += startIndex
    startIndex += 1
}
print(sum)

// 1부터 100까지의 짝수의 합 (단, if문 사용 금지)
var startNum = 0
var endNum = 100
var total = 0

while startNum <= endNum{
    total += startNum
    startNum += 2
}
print(total)

// 입력한 한 자릿수의 정수의 합 구하기
// terminator 옆에다 주는 것 (end 같은 역할)
print("Enter an integer(0~9):", terminator: " ")
// readLine 값은 옵셔널임!
var number = Int(readLine()!)
var intNumber = number!
var sumOfDigits = 0

while intNumber > 0 {
    sumOfDigits += intNumber % 10
    intNumber = intNumber / 10
}
print("Sum of digits =", sumOfDigits)

print("Enter an integer(0~9):", terminator: " ")
var repNum = 0
var remainder = 0
var sumNo = 0

// _ : 문법상에 의해 변수는 잡아놓았지만 사용하지 않을 경우 _ 사용
var inputNum = Int(readLine()!)
if let _: Int = inputNum{
    // repNum = i 쓰고 위에 _아닌 i 주는 것도 가능!
    repNum = inputNum!
    while repNum != 0 {
        remainder = repNum % 10
        sumNo += remainder
        repNum /= 10
    }
    print("Sum of digits = \(sumNo)")
}else{
    // nil 값이거나 문자 넣은 경우
    print("Input value is wrong!")
}
