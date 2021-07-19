//
//  ViewController.swift
//  SendMessage
//
//  Created by RayAri on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {


    @IBOutlet weak var tvText: UITextView!
    @IBOutlet weak var tfMessage: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnSend(_ sender: UIButton) {
        tvText.text += tfMessage.text! + "\n"
        tfMessage.text = ""
    }
    
    @IBAction func btnEmoji(_ sender: UIButton) {
        tfMessage.text?.append("😀")
    }
}

