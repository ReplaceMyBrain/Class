//
//  main.swift
//  Day04
//
//  Created by RayAri on 2021/07/19.
//

import Foundation

// 함수

func interSum(a: Int, b:Int) -> Int { // 지정할때 변수는 아규먼트라고 함.
    return a + b
}

//변수 지정은 최대한 하지말것! 이유는 pc가 아니라 phone 이기 때문에! 메모리를 많이 먹음.
print(interSum(a: 5, b: 8)) //쓰이는 변수는 파라미터

func greet(person: String) -> String {
    let greeting = "Hello, \(person)!"
    return greeting
}

print(greet(person: "Anna"))
print(greet(person: "Brian"))


//아규먼트 없이 가능
func sayHelloWorld() -> String {
    return "Hello, World!"
}

print(sayHelloWorld())



//내부적으로 보여주기 위해서 앞에 적어준다
//_사용시 사려준다 중요한것 띄어쓰기 꼭하기!
//디폴트값 지정했을 때 사용방법 nil 허용 안할 떈 사용 ? 사용x

func buildAddress(_ name: String, address:String, city: String, 우편번호 zipCode:String, country: String? = "USA") -> String {
    return """
        \(name)
        \(address)
        \(city)
        \(zipCode)
        \(country ?? "")
        """
}

print(buildAddress("유비", address: "중국", city : "상하이", 우편번호: "123", country: "China"))
print(buildAddress("장비", address: "중국", city: "북경", 우편번호: "234")) // 안적으면 디폴트
print(buildAddress("유비", address: "중국", city: "상하이", 우편번호: "234",country: nil))


// 가변 매개변수
// ...사용시 여러개 사용 가능!
func sayHelloFriends(me: String, friend: String...) -> String {
    return "Hello \(friend)! i'm \(me)."
}

print(sayHelloFriends(me: "초선", friend: "손견", "손책", "장양"))


// 복수의 값을 반환하는 함수
func getCountry() -> (dialCode: Int, isoCode: String, name: String){
    let country = (dialCode: 82, isoCode: "KR", name: "Korea")
    return country
}
let ret = getCountry()
print(ret)
print(ret.dialCode)


// 시작 숫자 부터 끝 숫자 까지의 합계를 구하는 함수
// 1) for 문
//func addRange(start: Int, end: Int) -> String {
//    var result = 0
//
//    for i in start...end {
//        result += i
//    }
//    return "\(start)부터 \(start)까지의 합은 \(result)입니다."
//}

// 2) while 문
func addRange(start: Int, end: Int) -> String {
    var result = 0
    var i = start
    
    while i<=end {
       result += i
        i += 1
    }
    return "\(start)부터 \(start)까지의 합은 \(result)입니다."
}


print(addRange(start:1, end:100))
//1부터 100까지의 합은 5050입니다.


//Overloading : 함수의 이름은 중복되도 parameter의 갯수로 구분이 가능

//도형의 면적과 둘레를 구하는 함수
//원
func shape(_ r: Double){
    let pi = 3.14
    let area = pi * r * r
    let border = 2 * pi * r
    print("원 \(area), \(border)")
}

//직사각형
func shape(_ w: Int, _ h:Int){
    let area = w * h
    let border = (w + h) * 2
    print("직사각형 : \(area), \(border)")
}

//직각 삼각형
func shape(_ a: Int, _ b:Int, _ c:Int){
    let area = a * b / 2
    let border = a + b + c		
    print("직사각형 : \(area), \(border)")
}

shape(5)
shape(5, 6)
shape(5, 6, 7)


/*
 
 Class : 전통적인 OOP관점에서의 클래스
 - 단일 상속
 - property
 - constructor
 - method
 - 참조 타입 선언(Call by refernece)
 
 Struct
 - 상속 불가
 - property
 - constructor
 - method
 - 값 타입 선언(Call by value)
 
 */

struct ValueType{
    var property = 1
}

class ReferenceType{
    var property = 1
}

//스트럭트 // 1개만 1로 바뀜
let firstStructInstance: ValueType = ValueType()
var seconStructInstance = firstStructInstance
seconStructInstance.property = 2

print("first : \(firstStructInstance.property)" )
print("second : \(seconStructInstance.property)" )


//클라스 // 두개가 2로 바뀜. 즉 클라스의 경우 복제했을 경우 똑같은 값을 가진다!
let firstClassInstacne : ReferenceType = ReferenceType()
var secondClassInstance = firstClassInstacne
secondClassInstance.property = 2

print("first : \(firstClassInstacne.property)" )
print("second : \(secondClassInstance.property)" )
