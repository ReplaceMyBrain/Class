//
//  main.swift
//  Day01
//
//  Created by Hyeji on 2021/07/14.
//

import Foundation

// comment
/*
 --------
 화면 출력
 --------
 */

// 문자 출력
print("안녕하세요")

// 숫자 출력
print(12345)

// 계산 출력
print(123 + 456)

/*
 Swift에는 상수와 변수 존재
 상수와 변수의 작명 규칙 (App Store 올릴 때 제일 중요)
 - Camel Case : 소문자로 시작하고 이어지는 단어는 대문자!
                function, method, variable, constant
                ex) studentName, studentAge, ...
 - Pascal Case : 대문자로 시작! (Upper Camel Case)
                 class, struct, enum, extension, ...
                 ex) Student, Prouduct
 - Snack Case : underbar로 연결하여 사용 (apple에서는 좋아하지 않음)
 - 대소문자 구분
 - 첫 글자를 숫자나 특수문자로 시작하면 안되나, underbar(_)로 시작 가능 (특수 용도)
 */

// 상수 : 한 번 선언된 값에 대해 변경이 불가능
/*
 let 으로 시작하면 상수라고 생각
 let <variable name> : <type> = <value> 이게 기본 타입
 */

// 세 가지 방법 모두 가능 (단, 초기값 없이 사용 시 type 꼭 지정해줘야 함!)
let intLetNum1: Int = 200
let intLetNum2 = 100
let intLetNum3: Int
intLetNum3 = 200
// intLetNum1 = 2000 : 바로 오류 등장

let sum: Int
sum = intLetNum1 + intLetNum2 // 초기 값이기 때문에 가능
// sum = intLetNum2 + intLetNum3 초기 값이 위에서 선언되었기 때문에 값을 바꿀 수 없음!

// 변수 : 한 번 선언된 값에 대해 변경이 가능
var intLetNum4: Int = 20
intLetNum4 = 2000
var nickName : String
nickName = "유비"
// nickName = 100 type이 String으로 정의되었는데 Int로 변경하는 건 불가능
// , 있으면 같이 선언 가능
var aNum = 9, bNum = 10

/*
 문자열 보간법 (String Interpolation)
 */
let studentName = "홍길동"
// type 출력하기
print(type(of: studentName))

// 출력방법
// java ver.
print("name : " + studentName)
// python ver.
print("name :", studentName)
// swift ver. (String Interpolation) : 괄호 안에 문자 집어 넣어도 되고, 숫자도 되고 사칙연산도 가능
print("name : \(studentName)")

let age: Int = 10
print("저는 \(age)살 입니다.")
print("저희 형은 \(age + 4)살 입니다.")

var name1 = "유비"
var age1 = 34
var gender1 = "남자"

// 회원의 이름은 유비이고 나이는 34살이며 성별은 남자입니다.
print("회원의 이름은 \(name1)이고 나이는 \(age1)이며 성별은 \(gender1)입니다.")

// Data Type
// Bool Type (True, False)
var someBool: Bool = true

// Int Type
var someInt: Int = -100
someInt = 100_000 // 100000임! 보기 편하게 쓰기 위해 저렇게 작성

// Float Type (자리수 차이 Float : 소수점 이하 6글자)
var someFloat: Float = 3.134

// Double (자리수 차이 Float : 소수점 이하 15글자)
var someDouble: Double = 3.12

// 숫자 타입 변환 (Double -> Int)
let doubleNum = 4.99999
print(Int(doubleNum))
// rounded : 반올림 (즉, 반올림한 것을 정수로 변환한다의 의미)
print(Int(doubleNum.rounded()))

// Character Type (한 글자 표현하는 것) 홑따옴표 사용 안하고 쌍따옴표만 사용!
var someCharacter: Character = "a"
// 이모지는 글자임!
someCharacter = "😝"
print(someCharacter)

var someString: String = "🥰😍"
print(someString)

let temp = "b"
print(type(of: temp)) // Default 타입이 string

// 쌍따옴표 바로 뒤나 바로 앞에 쓰면 오류걸림 (그 다음 줄부터 적자!)
var someMultiString = """
    1234
    abcd
    가나다라
"""

print(someMultiString)

// 문자열과 특수문자
// \n, \t, \"(쌍따옴표 표시), \'(홑따옴표 표시)
print("aa\tbb\ncc")
let wiseWords = "\"Imagination is more than the knowledge\" - Einstein"
print(wiseWords)

//
var name: String
var size: Int
var weight: Double
var bag: Bool
var color: Character

name = "맥북프로"
size = 16
weight = 2.56
bag = false
color = "은"

print("이름: \(name)")
print("크기: \(size)")
print("무게: \(weight)")
print("가방: \(bag)")
print("색상: \(color)")




//문자열 수정
var variableString = "Horse"
variableString += " and carriage"
print(variableString)

var string1 = "hello"
var string2 = " there"
var welcom = string1 + string2
print(welcom)

string1.append(string2)
print(string1)


// 문자길이
let str = "1234567890"
print("str has \(str.count) characters")

if str.count == 0 {
    print("Data가 없습니다.")
}else{
    print("Data는 \(str)입니다. ")
}

// Any, nil
// Any : Swift의 모든 타입을 지칭하는 키워드
// nil : null, Null, None

// Any
// Any타입은 Any타입 끼리만 가능 좋지 않음!
var someAny : Any = 100
someAny = "Type"
print(someAny)
someAny = 123.12
print(someAny)

var someDouble1 : Double = 111.1
print(someAny as! Double + someDouble1)

//?값을 주면 null값이 가능하다!
var someNil: String?
someNil = nil

// Tuple
// Tuple 사용전
var dialCode = 82
var isoCode = "KR"
var countryName = "Korea"

print(dialCode, isoCode, countryName)

// Tuple사용
var country = (82, "KR", "Korea")
print(country.0, country.1, country.2)

var country1 = (dialCode1 : 82, isoCode1: "KR", countryName1: "Korea")
print(country1.dialCode1, country1.isoCode1, country1.countryName1)

//Type 별칭
typealias MyInt = Int
let age2: MyInt = 20

typealias  person = (name: String, height: Int, marriage: Bool)

var p1 : person = ("유비", 180, true)
print(p1.name)

//Tuple을 사용하여 직사각형의 넓이와 둘레를 출력
typealias Rectangle = (a: String, height: Int, weight: Int, area: Int, border: Int)
var r1: Rectangle = ("직사각형",5,6,0,0)

r1.area = r1.height * r1.weight
r1.border = (r1.height + r1.weight) * 2
print(r1)

// 연산자
let (x1, y1) = (1,"Kim")
print(x1)

//사칙연산자 (정수는 정수만 주고 실수는 실수만 줌!)
print(10 / 3)
print(10.0 / 3.0)

//단항 음수 연산자
let one = 1
let minusOne = -one





















