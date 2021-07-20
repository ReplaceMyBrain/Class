//
//  ViewController.swift
//  OddEven2
//
//  Created by RayAri on 2021/07/15.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tfNumber: UITextField!
    @IBOutlet weak var lblResult: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblResult.text = "숫자를 입력해주세요"
    }

    @IBAction func btnClick(_ sender: UIButton) {
        /*
        var Message: String
        
        // 입력하지 않으면 0으로 체크해서 처리하겠다
        // tfNumber에 아무것도 안들어오면 나는 0으로 간주할꺼야!
        // 옵셔널과 삼항 연산자를 함께 쓴 게 ?? 임!
        // 0이 아니면 tfNumber가 Int로 바꿔질 것임
        // ?? 0 의 의미는 데이터가 없으면 0이다!
        let checkNumber = Int(tfNumber.text!) ?? 0
        if checkNumber % 2 == 0{
            Message = "짝수"
        }else{
            Message = "홀수"
        }
        lblResult.text = "입력하신 숫자는 \(Message)입니다."
        */
        
        // numCheck에 Empty면 0이 들어가고 아니면 1이 들어갈 것
        let numCheck = checkNil(str: tfNumber.text!)
        if numCheck == 1{
            let returnValue = numberDecision(str: tfNumber.text!)
            lblResult.text = "입력 하신 숫자는 \(returnValue)입니다."
        }else{
            lblResult.text = "숫자를 확인하세요!"
        }
    }
    
    // -> Int 이게 return 타입임!
    func checkNil(str: String!) -> Int{
        // enter키나 space를 trim해주는 작업임! (여기서는 숫자키보드이기 때문에 없지만 이 작업 꼭 필요
        let check = str.trimmingCharacters(in: .whitespacesAndNewlines)
        if check.isEmpty{
            return 0
        }else{
            return 1
        }
    }
    
    // 함수 쓰는 게 메모리 효율도 좋고 다 좋음 -> 그니까 많이 쓰자
    func numberDecision(str: String!) -> String{
        if Int(str)! % 2 == 0{
            return "짝수"
        }else{
            return "홀수"
        }
    }
    
}

