//
//  ViewController.swift
//  Quiz02
//
//  Created by RayAri on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    
    
    
    @IBOutlet weak var num1: UITextField!
    @IBOutlet weak var num2: UITextField!
    @IBOutlet weak var add: UITextField!
    @IBOutlet weak var sub: UITextField!
    @IBOutlet weak var mul: UITextField!
    @IBOutlet weak var div1: UITextField!
    @IBOutlet weak var div2: UITextField!
    
    @IBOutlet weak var message: UILabel!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        message.text = "두개의 숫자를 입력해 주세요!"
    
    }

    //아무곳이나 누르면!
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }

    @IBAction func btn(_ sender: UIButton) {
        
        if num1.text?.isEmpty==true || num2.text?.isEmpty==true {
            message.text = "숫자를 확인하세요!"
            add.text = ""
            sub.text = ""
            mul.text = ""
            div1.text = ""
            div2.text = ""
        }else{
            
            let n1 = Int(num1.text!)
            let n2 = Int(num2.text!)
            
            add.text = "\(n1! + n2!)"
            sub.text = "\(n1! - n2!)"
            mul.text = "\(n1! * n2!)"
            div1.text = "\(n1! / n2!)"
            div2.text = "\(n1! % n2!)"
            
            message.text = "계산이 되었습니다!"
        }
        
        
    }
}

