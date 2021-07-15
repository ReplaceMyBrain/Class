//
//  ViewController.swift
//  RangeSum
//
//  Created by RayAri on 2021/07/15.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var tfFirstNum: UITextField!
    @IBOutlet weak var tfSecondNum: UITextField!
    @IBOutlet weak var lblResult: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblResult.text = "시작 숫자와 끝 숫자를 입력해주세요!"
    }

    // 키보드 내리기
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    @IBAction func btnSum(_ sender: UIButton) {
        
        guard let strFirstNum = tfFirstNum.text else { return }
        guard let strSecondNum = tfSecondNum.text else { return }

        let checkResult = emptyCheck(strFirstNum, strSecondNum)
        if checkResult == 0{
            tfFirstNum.becomeFirstResponder()
            lblResult.text = "시작 숫자를 입력해주세요!"
        }else if checkResult == 1{
            tfSecondNum.becomeFirstResponder()
            lblResult.text = "끝 숫자를 입력해주세요!"
        }else{
//            let intFirstNum = Int(strFirstNum)!
//            let intSecondNum = Int(strSecondNum)!
//            let resultValue = calc(intFirstNum, intSecondNum) // 위에서 Int로 변경해 변수에 선언해주기
//            let resultValue = calc(Int(strFirstNum)!, Int(strSecondNum)!) // parameter 보낼 때 Int로 변경하기
            let resultValue = calc(strFirstNum, strSecondNum) // string으로 보내고 함수에서 string -> Int 작업해주기
            lblResult.text = "범위의 합계는 \(resultValue)입니다"
            self.view.endEditing(true)
        }
        
    }
    
    // 사용자가 입력했는지 체크
    func emptyCheck(_ strFirstNum : String, _ strSecondNum : String) -> Int {
        if strFirstNum.isEmpty == true{
            return 0
        }else if strSecondNum.isEmpty == true{
            return 1
        }else{
            return 2
        }
    }
    
    // 계산 체크
//    func calc(_ intFirstNum : Int, _ intSecondNum : Int) -> Int {
//    func calc(_ intFirstNum : Int, _ intSecondNum : Int) -> Int {
    func calc(_ strFirstNum : String, _ strSecondNum : String) -> Int {
        let intFirstNum = Int(strFirstNum)!
        let intSecondNum = Int(strSecondNum)!
        var sum : Int = 0
        if intFirstNum > intSecondNum{
            for i in intSecondNum...intFirstNum{
                sum += i
            }
        }else{
            for i in intFirstNum...intSecondNum{
                sum += i
            }
        }
        return sum
    }
}

