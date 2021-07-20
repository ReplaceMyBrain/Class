//
//  ViewController.swift
//  ImageView
//
//  Created by RayAri on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var btnResize: UIButton!
    
    var imgOn : UIImage? // 켜진 전구 이미지
    var imgOff : UIImage? // 꺼진 전구 이미지
    
    var isZoom = false // 이미지 확대 여부
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        //이미지 파일 준비
        imgOn = UIImage(named: "lamp_on.png")
        imgOff = UIImage(named: "lamp_off.png")
        
        //이미지 할당
        imgView.image = imgOn
        
    }

    @IBAction func btnResizeImage(_ sender: UIButton) {
        // 이미지 크기를 2배로!
        let scale : CGFloat = 2.0
        var newWidth : CGFloat
        var newHeight : CGFloat

        if isZoom{
            newWidth = imgView.frame.width / scale
            newHeight = imgView.frame.height / scale
            btnResize.setTitle("Image 확대", for: .normal)

        }else{
            newWidth = imgView.frame.width * scale
            newHeight = imgView.frame.height * scale
            btnResize.setTitle("Image 축소", for: .normal)
        }

        imgView.frame.size = CGSize(width: newWidth, height: newHeight)
        isZoom = !isZoom // 상태변수이다! 상태를 변경시켜줘야함!

    }
    
    
    @IBAction func switchImageOnoff(_ sender: UISwitch) {
        
//        switch sender.isOn {
//        case true:
//            imgView.image = imgOn
//
//        default:
//            imgView.image = imgOff
//        }
    
        
        if sender.isOn{
            imgView.image = imgOn
        }else{
            imgView.image = imgOff
        }
        
        
    }

    @IBAction func switchImageResize(_ sender: UISwitch) {
        // 이미지 크기를 2배로!
        let scale : CGFloat = 2.0
        var newWidth : CGFloat
        var newHeight : CGFloat

        switch sender.isOn {
        case true:
            newWidth = imgView.frame.width * scale
            newHeight = imgView.frame.height * scale
    
        default:
            newWidth = imgView.frame.width / scale
            newHeight = imgView.frame.height / scale
        }

        imgView.frame.size = CGSize(width: newWidth, height: newHeight)

    }
}
