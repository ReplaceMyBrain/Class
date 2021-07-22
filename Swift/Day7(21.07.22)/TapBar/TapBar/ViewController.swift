//
//  ViewController.swift
//  TapBar
//
//  Created by RayAri on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnGOImageView(_ sender: UIButton) {
        tabBarController?.selectedIndex = 1
        
        
    }
    
    @IBAction func btnGoDatePicker(_ sender: UIButton) {
        tabBarController?.selectedIndex = 2
    }
}

