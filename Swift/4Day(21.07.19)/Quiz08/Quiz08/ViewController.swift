	//
//  ViewController.swift
//  Quiz08
//
//  Created by RayAri on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var Img: UIImageView!
    @IBOutlet weak var text: UILabel!
    
    let interval = 3.0
    let timeSelector : Selector = #selector(ViewController.updateTime)
    var imgRai : UIImage?
    var imgAri : UIImage?
    var change = false
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        imgRai = UIImage(named: "Ray.jpeg")
        imgAri = UIImage(named: "Ari.jpeg")
        
        Img.image = imgRai
        
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true)
    }

    @objc func updateTime() {
        let date = NSDate()
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "ss"
        
        if change {
            Img.image = imgAri
        }else {
            Img.image = imgRai
        }
        change = !change
        
    }

}

