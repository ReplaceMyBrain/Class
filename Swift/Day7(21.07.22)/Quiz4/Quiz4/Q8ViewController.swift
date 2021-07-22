	//
//  ViewController.swift
//  Quiz08
//
//  Created by RayAri on 2021/07/19.
//

import UIKit

class Q8ViewController: UIViewController {

    @IBOutlet weak var Img: UIImageView!
    @IBOutlet weak var text: UILabel!
    
    let interval = 3.0
    let timeSelector : Selector = #selector(Q8ViewController.updateTime)
    var imgRai : UIImage?
    var imgAri : UIImage?
    var change = false
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        imgRai = UIImage(named: "Ray.jpeg")
        imgAri = UIImage(named: "Ari.jpeg")
        
        Img.image = imgRai
        text.text = "Ray.jpeg"
        
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true)
    }

    @objc func updateTime() {
        _ = NSDate()
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "ss"
        
        if change {
            Img.image = imgRai
            text.text = "Ray.jpeg"
            
        }else {
            Img.image = imgAri
            text.text = "Ari.jpeg"
        }
        change = !change
        
    }

}

