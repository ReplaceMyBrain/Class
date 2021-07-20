//
//  ViewController.swift
//  Emoji
//
//  Created by RayAri on 2021/07/15.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblEmoji: UILabel!
    var arrEmoji = ["😀", "😃", "😄", "😁", "😝", "😅"]
    var checkCount = 0

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblEmoji.text = arrEmoji[0]
    }

    @IBAction func btnPlay(_ sender: UIButton) {

        if checkCount <= 4{
            checkCount += 1
            lblEmoji.text = arrEmoji[checkCount]
        }else{
            checkCount = 0
            lblEmoji.text = arrEmoji[checkCount]
        }

    }
    
    @IBAction func btnPreview(_ sender: UIButton) {
        
        if checkCount >= 1{
            checkCount -= 1
            lblEmoji.text = arrEmoji[checkCount]
        }else{
            checkCount = 5
            lblEmoji.text = arrEmoji[checkCount]
        }
        
    }
}

