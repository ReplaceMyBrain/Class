//
//  ViewController.swift
//  PickerView
//
//  Created by RayAri on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var pickerImage: UIPickerView!
    @IBOutlet weak var lblimageFileName: UILabel!
    @IBOutlet weak var imageView: UIImageView!
    
    var imageFileName = ["w1.jpg","w2.jpg","w3.jpg","w4.jpg","w5.jpg","w6.jpg","w7.jpg","w8.jpg","w9.jpg","w10.jpg",]
    
    var imageArray = [UIImage?]()
    var maxArrayNum  = 0
    let viewColumn = 1
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        maxArrayNum = imageFileName.count
        
        for i in 0..<maxArrayNum{
            let image = UIImage(named: imageFileName[i])
            imageArray.append(image)
        }
        
        lblimageFileName.text = imageFileName[0]
        imageView.image = imageArray[0]
        
        pickerImage.dataSource = self
        pickerImage.delegate = self
        
    }


} //View

extension ViewController: UIPickerViewDataSource{
    
    // pickerView의 컬럼 갯수
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumn
    }
    // 출력할 이미지 파일 갯수
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum
    }
    
}

extension ViewController: UIPickerViewDelegate{
    
    // PickerView에 Title 입히기
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return imageFileName[row]
    }
    
    // pickerView에 Image선택
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        lblimageFileName.text = imageFileName[row]
        imageView.image = imageArray[row]
    }
    
    
}

