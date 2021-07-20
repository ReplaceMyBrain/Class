//
//  main.swift
//  Day02
//
//  Created by RayAri on 2021/07/15.
//

import Foundation

// nil 때문에 에러가 많이 걸리는데 이를 방지해주고자 nil을 사용하는 것임!

var str1: String

str1 = "Apple"
str1 = "Google"
// str1 = nil -> nil 값 못들어감! (nil은 optional 변수에만 들어감)

print(str1)

var str2: String?
str2 = "Apple"
str2 = "Google"
// Optional("Google") 이라고 출력됨!
// str2 = nil
// nil은 nil로 출력됨!
print(str2!) // Google 만 출력하고자 ! 사용함!!

str2 = "123"
// optional을 변환시키면 또 optional 나오기 때문에 즉, data는 풀렸지만 타입은 여전히 optional 이기 때문에 한 번 더 풀어줘야 하는 것임
// String -> Int 이거 먼저 풀고 또 optional 풀어줘야 함!
// 변환자에는 ! 을 한 번 더 써줘야 사용이 가능함! (변환했기 때문)
// 근데 보통 이렇게 안쓴다!
var int1: Int = Int(str2!)!
print(int1 + 10)

var string1: String?
string1 = "Apple"
string1 = nil
// print(string1!)

// var string2: String!
// string2 = nil
// print(string2)
// nil은 아무것도 없기에 그냥 print(string2) 하기만 하면 되는 것임!
// nil을 방지하려고 만든게 optional인데 그걸 풀어버리면 오류난다!
// 실행할 때 nil을 안만나려고 만든 게 optional임!

//var string3: String
//print(string3)

// 비교 연산자 (true, false 값 등장)
print(1 == 1)

// tuple에서의 비교 연산 (제일 처음에서 비교가 되면 두 번째꺼는 비교하지 않음)
// 원래는 z 가 더 크긴하지만 이미 1과 2에서 판단되어버렸기 때문에 true 값 등장
print((1, "zebra") < (2, "apple"))
// 3이 같기에 비교할 수 없으므로 2번째 꺼끼리 비교
print((3, "apple") < (3, "bird"))

// 삼항 조건 연산자
let contentHeight = 40
let hasHeader = true

// true 일 경우 50을 실행, false일 경우 20을 실행
let rowHeight = contentHeight + (hasHeader ? 50 : 20)
print(rowHeight)
// text?.isEmpty 이 부분 옵셔널이 아니고 삼항연산자임!!!

// 범위 연산자
// 닫힌 범위 연산자
// 1...10 : 1부터 10까지라는 의미임 (Slicing)
for i in 1...10{
    print(i)
}

var sum: Int = 0
for i in 1...10{
    sum += i
}

print("1~10의 합계는 \(sum) 입니다.")

// 구구단 출력
for i in 1...9{
    print("5 X \(i) = \(i*5)")
}

// 반닫힌 연산자
// 배열의 길이 사용할 때 많이 사용!
for i in 1..<10{
    print("5 X \(i) = \(i*5)")
}

let names = ["Anna", "Alex", "Brian", "Jack"]
// 배열의 개수
print(names.count)

for i in 0..<names.count{
    print("Person \(i+1) is called \(names[i])")
}

// Optional
// : 값이 있을 수도 있고 없을 수도 있다!
// : nil 값을 포함할 수도 있고, 포함하지 않을 수도 있다는 의미

// type정하지 않고 데이터 넣으면 nil 사용 불가!
// var constantNum = 100
// constantNum = nil

// 처음에는 선언자는 ?, 언래핑할 때는 ! 사용했는데 이제는 마음대로 다 사용가능해짐
var constantNum: Int? = 100
constantNum = nil
var constantNum2: Int! = 100
//constantNum2 = nil
print(constantNum2)
// 혼자 쓸 때만 Optional(100) 이런식으로 출력되고 뒤에 숫자나 다른 게 오면 알아서 벗겨서 출력됨!
print(constantNum2 + 10)

// Optional Unwrapping
var myName: String? = nil
print(myName as Any)

// Optional Binding
// if let
if let name: String = myName{
    // nil이 아닐 경우
    print((name))
}else{
    // nil일 경우
    print("myName is nil")
}
// 이 작업이 끝나고 name이라는 변수 사용 시 ! 사용 안해줘도 됨!

var yourName: String! = nil
if let name: String = yourName{
    // nil이 아닐 경우
    print((name))
}else{
    // nil일 경우
    print("yourNmae is nil")
}

var myName2: String? = "James"
var yourName2: String? = nil

if let name = myName2, let friend = yourName2{
    // 둘 다 nil이 아닐 경우 (, 는 and 조건임)
    print("\(name) and \(friend)")
}

// Force Unwrapping
print(myName2!)
// if let을 쓰는 이유
myName2 = nil
// print(myName2!) 이거 쓰면 오류가 걸림! 그렇기에 nil인지 아닌지 체크먼저 해주고 출력해주는 if let 필요한 것임
// 아니면 if let 사용하지 말고 data 가 있는지 없는지 체크한 후에 ! 사용하는 것도 간결하게 쓸 수 있는 코드 (권장)
print(myName2 as Any)

// Collection : 여러 값들을 묶어서 하나의 변수로 사용
/*
 Array : 순서가 있는 리스트 컬렉션 (자바에서의 ArrayList라고 생각)
 Dictionary : Key와 Value의 쌍으로 이루어진 컬렉션
 Set : 순서가 없고 멤버(value)가 유일한 컬렉션, 집합연산
 */

// Array
// 빈 Array 생성 (var가 아닌 let으로 만들면 한 번 만들고 나서 변경 불가능한 Array라는 의미)
var intVariable: Array<Int> = Array<Int>() // :뒤 클라스 = 생성자
var intVariable2: [Int] = [Int]()
var intVariable3: [Int] = [] // 제일 많이 사용함! 보통 이렇게 다들 사용함 (데이터 있으면 [1,2,3] 이렇게 적으면 됨)
// append로 데이터 추가하기 (순서대로 0,1,2 번지로 들어감)
intVariable3.append(1)
intVariable3.append(10)
intVariable3.append(100)
intVariable3.append(1000)

print(intVariable3)
print(intVariable3[0])
// print 시 범위연산자 사용가능
print(intVariable3[0...2])
print(intVariable3[0...2][1])

// 해당 값이 있는지 묻는 것 (true, false 로 값 나옴)
print(intVariable3.contains(100))
print(intVariable3.contains(90))

// 데이터 값 제거
intVariable3.remove(at: 0)
// 맨 끝에 있는 데이터 값 제거 (First는 처음 값)
intVariable3.removeLast()
// 마지막에서 몇 번째 데이터 지우기 (First는 처음에서 몇 번째 값)
 intVariable3.removeLast(1)
// removeAll 은 다 지우기
intVariable3.removeAll()
print(intVariable3)

// 이게 removeAll과 같은 역할임
intVariable3 = []

// 기본 값으로 배열 생성하기
// 코딩할 때는 많이 사용 안하고 데이터 분석 시 많이 사용함 (생성자에 Dictionary 사용 - 요즘 이게 유행)
// 0.0 을 3번 반복하겠다!
var threeDouble = Array(repeating: 0.0, count: 3)
print(threeDouble)
var anotherDouble = Array(repeating: 2.5, count: 3)
// 배열끼리 연결시켜주기
var sixDouble = threeDouble + anotherDouble
print(sixDouble)

let intVariable4 = [1,2,3]
// Array<Int> 으로 등장 -> Int Array이구나!
print(type(of: intVariable4))
// intVariable4.append(4) 이거 에러걸림 (왜? let이니까!!! let으로 잡은 Array는 final!)

// 문자열 배열
var shoppingList = ["Eggs", "Milk"]
print(shoppingList.count)
if shoppingList.isEmpty{
    shoppingList.append("Melon")
}else{
    shoppingList.append("WaterMelon")
}
print(shoppingList)

// 여러 항목 추가하기
shoppingList += ["Baking Powder"]
shoppingList += ["Chocolate", "Cheese", "Butter"]
print(shoppingList)

// 배열의 특정 위치 데이터 변경 및 제거
shoppingList[0...3] = ["Banana1", "Banana2", "Banana3", "Banana4", "Banana5", "Banana6"]
print(shoppingList)

// 0번에 "Apple"을 추가
// _ 쓰는 건 변수명이 안보이고, _ 안쓴건 변수명이 보임 (즉, 여기에서 "Apple"쪽은 _쓰고, at은 안썼을 것)
shoppingList.insert("Apple", at: 0)
print(shoppingList)

// 배열의 값과 인덱스가 필요한 경우 (index, value) 이거는 각자 변수명 선언해주면 됨!
for (index, value) in shoppingList.enumerated(){
    print("Item \(index+1) : \(value)")
}
print(shoppingList.enumerated())

// data 값이 오는 경우 합계 구하기
var tot = 0.0
for i in sixDouble{
    tot += i
}
print(tot)

// 최대값 찾기 (optional임! 그래서 optional 제거하려면 ! 사용하기)
// print(sixDouble.max()) : Optional(2.5) 출력
print(sixDouble.max()!)
// 최소값 찾기
print(sixDouble.min()!)

