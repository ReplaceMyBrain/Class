//
//  main.swift
//  Day05
//
//  Created by RayAri on 2021/07/20.
//

import Foundation

// --------
// 구조체 : Structure
// : Swift에서 Data Type을 정의

struct Sample {
    var sampleProperty: Int = 10 // 가변 프로퍼티
    let fixedSampleProperty: Int = 100 // 불편 프로퍼티
    static var typeProperty: Int = 1000 // 타입 프로퍼티
    
    //생성자를 만들어 내는것 안적어도됨!
    init(){
        
    }
    
    func instanceMethod(){
        print("instance method")
    }
    
    static func typeMethod(){
        print("type method")
    }
}

//Structure사용
//class는 한 화면에 하나가 좋음. 나머지는 스트럭처를 사용하는게 가장 좋다! 더 빠르다!

var samp: Sample = Sample()
print(samp.sampleProperty)
samp.sampleProperty = 100
print(samp.sampleProperty) //여기서만 변경!

var samp1 = Sample()
print(samp1.sampleProperty)
//고정값으로 나오는 것을 확인!


//Type Property
Sample.typeMethod()
print(Sample.typeProperty)

//학생 구조체
struct Student {
    var name: String = "unknown"
    var `class` : String = "Swift"
    
    static func selfIntroduce(){
        print("학생 타입 입니다.")
    }
    
    func selfIntroduce(){
        print("저는 \(`class`)반 \(name)입니다)")
        print("저는 \(self.class)반 \(name)입니다)")
    }
    
}


Student.selfIntroduce()

var student: Student = Student()
student.name = "James"
student.class = "스위프트"
student.selfIntroduce()

let cathy: Student = Student()
//cathy.name = "Cathy"


//학생 구조체
class Student1 {
    var name: String = "unknown"
    var `class`: String = "Swift"
    
    static func selfIntroduce(){
        print("학생 타입 입니다.")
    }
    
    func selfIntroduce(){
        print("저는 \(`class`)반 \(name)입니다)")
        print("저는 \(self.class)반 \(name)입니다)")
    }
    
}

Student1.selfIntroduce()
var student1: Student1 = Student1()

//---------------
class Shape {

    func input(_ r: Double) {
        let pi = 3.14
        let area = pi * r * r
        let border = 2 * pi * r
        print("원의 면적은 \(area) 이고 , 둘레는 \(border) 입니다." )
        
    }
    
    func input(_ w: Int, _ h: Int) {
        let area = w * h
        let border = (w + h) * 2
        print("직사각형의 면적은 \(area)이고 , 둘레는 \(border) 입니다.")
        
    }
    
    func input(_ w: Int, _ h: Int, _ hy: Int ) {
        let area = w * h / 2
        let border = w + h + hy
        print("직사각형의 면적은 \(area)이고, 둘레는 \(border) 입니다")
        
    }
    
}

let sh1: Shape = Shape()
let sh2: Shape = Shape()
let sh3: Shape = Shape()

sh1.input(5) // 원의 면적과 둘레 구하기
// 원의 면적은 __이고 둘레는 __입니다.
sh2.input(5, 6) // 직사각형의 면적과 둘레 구하기
sh3.input(5, 6, 8) // 직각 삼감형의 면적과 둘레 구하기


class Shape1 {
    var area = 0.0
    let pi = 3.14157
    var kind = ""
    
    init(){
        print("계산시작")
    }
    
    init(radius: Double){
        kind = "원"
        area = radius * radius * pi
        calc()
    }
    
    init(w: Double, h: Double){
        kind = "사각형"
        area = w * h
        calc()
    }
    
    init(w: Double, h: Double, hy: Double){
        kind = "삼각형"
        area = w * h / 2
        calc()
    }
    
    func input(r: Double){
        area = r * r * pi
        calc()
    }
    
    func calc() {
        print("\(kind)은 \(Int(area))입니다.")
    }
}

let sh4: Shape1 = Shape1()
sh4.input(r: 5.0)

let sh5: Shape1 = Shape1(radius: 5.0)
let sh6: Shape1 = Shape1(w: 5, h: 6)
let sh7: Shape1 = Shape1(w: 3, h: 3, hy: 3)


// Extension
// 구조체, 클래스, 프로토콜 타입에 새로운 기능을 추가할 수 있는 기능.
// 기존에 존재하는 기능은 재정의 할 수 없다.

extension Int{
    var isEven: Bool{
        return self % 2 == 0
    }
    var isOdd: Bool{
        return self % 2 == 1
    }
}

print(1.isEven)


//closure

//함수
func sumFunction(a: Int, b: Int) -> Int{
    return a + b
}

var sumResult : Int = sumFunction(a:10, b:20)
print(sumResult)

//Closure
//in을 기억해라!!
var sumClosure: (Int, Int) -> Int = {(a:Int, b: Int) -> Int in
    return a+b
}

sumResult = sumClosure(10,20)
print(sumResult)

// ---
print(Int.random(in: 1..<10))

func genNum() -> String {
    return String(Int.random(in: 1..<10))
}



