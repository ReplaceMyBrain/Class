//
//  AddViewController.swift
//  Quiz17
//
//  Created by RayAri on 2021/07/23.
//

import UIKit

class AddViewController: UIViewController {

    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet weak var tfText: UITextField!
    
    var setImageFile = ["cart.png","clock.png","pencil.png"]
    var imageArray = [UIImage?]()
    var maxArrayNum  = 0
    let viewColumn = 1
    
    var imgFile = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        maxArrayNum = setImageFile.count
        
        for i in 0..<maxArrayNum{
            let image = UIImage(named: setImageFile[i])
            imageArray.append(image)
        }
        
        imgView.image = imageArray[0]
        
        picker.dataSource = self
        picker.delegate = self
        

        // Do any additional setup after loading the view.
    }
    
    @IBAction func btnAdd(_ sender: UIButton) {
        items.append(tfText.text!)
        itemsImageFile.append(imgFile)
        navigationController?.popViewController(animated: true)
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}

extension AddViewController: UIPickerViewDataSource{
    
    // pickerView의 컬럼 갯수
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumn
    }
    // 출력할 이미지 파일 갯수
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum
    }
    
}

extension AddViewController: UIPickerViewDelegate{
    
    // PickerView에 Title 입히기
//    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
//        imgFile = setImageFile[row]
//        return setImageFile[row]
//    }
    
    //
    func pickerView(_ pickerView: UIPickerView, viewForRow row: Int, forComponent component: Int, reusing view: UIView?) -> UIView {
        let imageView = UIImageView(image: imageArray[row])
        imageView.frame = CGRect(x: 0, y: 0, width: 50, height: 20)
        imgFile = setImageFile[row]
        return imageView
    }

    
    // pickerView에 Image선택
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        imgView.image = imageArray[row]
    }
    
    
}


