//
//  ViewController.swift
//  Quiz05
//
//  Created by RayAri on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var tfNum: UITextField!
    @IBOutlet weak var tvResult: UITextView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    @IBAction func btnPrint(_ sender: UIButton) {
        
        let strNum = tfNum.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
        if !strNum.isEmpty{
            for i in 1..<10{
                tvResult.text += "\(strNum) X \(i) = \(String(format: "%2d",Int(strNum)!*i))\n"
            }
        }else{
            for i in 1..<10{
                tvResult.text += "2 X \(i) = \(2*i)\n"
            }
        }
    }
    

}

