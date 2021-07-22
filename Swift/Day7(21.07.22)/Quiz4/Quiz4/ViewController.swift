//
//  ViewController.swift
//  Quiz4
//
//  Created by RayAri on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnQ6(_ sender: UIButton) {
        tabBarController?.selectedIndex = 1
        
    }
    
    @IBAction func btnQ8(_ sender: UIButton) {
        tabBarController?.selectedIndex = 2
        
    }
    @IBAction func btnPage(_ sender: UIButton) {
        tabBarController?.selectedIndex = 3
        
    }
}

