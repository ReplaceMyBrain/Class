//
//  ViewController.swift
//  ImagePrint
//
//  Created by RayAri on 2021/07/15.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblName: UILabel!
    @IBOutlet weak var imgView: UIImageView!
    // 그림은 다 배열이라고 생각하면 됨!
    var numImage = 0
    var ImageName = ["flower_01.png", "flower_02.png", "flower_03.png", "flower_04.png", "flower_05.png", "flower_06.png"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        // 첫 화면 구성 (이름과 그림 첫 번째꺼 띄워주기)
        lblName.text = ImageName[numImage]
        // 이미지 보여줄 때 UIImage라는 함수 사용해서 보여주면 됨!
        imgView.image = UIImage(named: ImageName[numImage])
    }

    @IBAction func btnPreview(_ sender: Any) {
        if numImage >= 1{
            numImage -= 1
            imgView.image = UIImage(named: ImageName[numImage])
            lblName.text = ImageName[numImage]
        }else{
            numImage = 5
            imgView.image = UIImage(named: ImageName[numImage])
            lblName.text = ImageName[numImage]
        }
    }
    
    @IBAction func btnNext(_ sender: Any) {
        if numImage <= 4{
            numImage += 1
            imgView.image = UIImage(named: ImageName[numImage])
            lblName.text = ImageName[numImage]
        }else{
            numImage = 0
            imgView.image = UIImage(named: ImageName[numImage])
            lblName.text = ImageName[numImage]
        }
    }
}

