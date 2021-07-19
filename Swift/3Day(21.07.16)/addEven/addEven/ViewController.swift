//
//  ViewController.swift
//  addEven
//
//  Created by RayAri on 2021/07/16.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var inputNum1: UITextField!
    
    @IBOutlet weak var inputNum2: UITextField!
    
    @IBOutlet weak var result: UITextField!
    
    @IBOutlet weak var lblMessage: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    
    @IBAction func btnCal(_ sender: UIButton) {
        let intNum1=Int(inputNum1.text!) ?? 0
        let intNum2=Int(inputNum2.text!) ?? 0
        
        if intNum1==0||intNum2==0{
            lblMessage.text="짝수만 입력해주세요!"
        }else if intNum1%2==0 && intNum2%2==0{
            result.text="\(intNum1+intNum2)"
            lblMessage.text="계산 완료"
        }else{
            lblMessage.text="짝수만 입력해주세요!"
        }
        
    }
}

