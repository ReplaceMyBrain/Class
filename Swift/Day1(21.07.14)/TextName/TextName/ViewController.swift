//
//  ViewController.swift
//  TextName
//
//  Created by RayAri on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var welCome: UILabel!
    
    @IBOutlet weak var Name: UITextField!
    
    @IBOutlet weak var message: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        message.text = "환영 합니다!"
    }

    @IBAction func Send(_ sender: UIButton) {
//        if name.text?.count == 0 {
//            message.text = "텍스트를 입력하세요!"
//
        if Name.text?.isEmpty == true{
            message.text = "텍스트를 입력하세요.!"
            
        }else{
            welCome.text = "Welcome! \(Name.text!)"
            message.text = "텍스트를 추가했습니다.!"
        }

    }
    @IBAction func Clear(_ sender: UIButton) {
        welCome.text = "Welcome!"
        Name.text?.removeAll()
        message.text = "화면 초기상태 입니다."
        
    }
}

