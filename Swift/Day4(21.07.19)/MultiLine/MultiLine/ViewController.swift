//
//  ViewController.swift
//  MultiLine
//
//  Created by RayAri on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var tfInput: UITextField!
    @IBOutlet weak var tvResult: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tvResult.isEditable = false // Read Only
      
    }

    @IBAction func btnAppend(_ sender: UIButton) {
        // 빈칸 데이터는 제외한다.s
        let strInput = tfInput.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
        if  strInput.isEmpty {
            tvResult.text += tfInput.text! + "\n"
        }
        
        
        
        
    }
    
}

