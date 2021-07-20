//
//  ViewController.swift
//  Namebutton
//
//  Created by RayAri on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var tv1: UILabel!
    @IBOutlet weak var btn_Name: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    
    }
    
    @IBAction func btnName(_ sender: UIButton) {
        tv1.text?.append("김도우")
    }

}
