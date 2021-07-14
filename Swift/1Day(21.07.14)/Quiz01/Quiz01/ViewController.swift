//
//  ViewController.swift
//  Quiz01
//
//  Created by RayAri on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var text: UILabel!
    @IBOutlet weak var button: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnA(_ sender: UIButton) {
        
        let text1 = "Welcome!"
        let text2 = "welcome!김도우"
        
        if(text.text == text1){
            text.text = text2
        }else{
            text.text = text1
        }
        
    }
    
}

