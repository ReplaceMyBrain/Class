//
//  ViewController.swift
//  OddEven
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
        tfNumber.becomeFirstResponder()
        lblResult.text = "숫자를 입력해주세요"
    }

    // 키보드 내리기
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    @IBAction func btnCheck(_ sender: UIButton) {
        
        guard let strNumber = tfNumber.text else { return }
        
        if tfNumber.text?.isEmpty == true{
            lblResult.becomeFirstResponder()
            lblResult.text = "숫자를 입력해주세요"
        }else{
            let intNumber = Int(strNumber)!
            let resultValue = checkOddEven(intNumber)
            lblResult.text = "입력하신 숫자는 \(resultValue)입니다."
            self.view.endEditing(true)
            
//            if Int(strNumber)! % 2 == 0{
//                lblResult.text = "입력하신 숫자는 짝수 입니다."
//                self.view.endEditing(true)
//            }else{
//                lblResult.text = "입력하신 숫자는 홀수 입니다."
//                self.view.endEditing(true)
//            }
        }
        
    } // btnCheck
    func checkOddEven(_ intNumber: Int) -> String{
        if intNumber % 2 == 0{
            return "짝수"
        }else{
            return "홀수"
        }
    }
}

