//
//  ViewController.swift
//  ButtonName2
//
//  Created by RayAri on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    
    
    @IBOutlet weak var Smail: UIButton!
    @IBOutlet weak var text: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func smail(_ sender: UIButton) {
        
        text.text?.append("😀")
    }
    
}

