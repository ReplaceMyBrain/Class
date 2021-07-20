//
//  ViewController.swift
//  Quiz09
//
//  Created by RayAri on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblText: UILabel!
    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet weak var tvResult: UITextView!
    
    var dan = Array<Int>(2...9)
    var maxArrayNum = 0
    let viewColumn = 1

    override func viewDidLoad() {
        super.viewDidLoad()

        maxArrayNum = dan.count
        
        lblText.text = "\(dan[0]) 단"
        gugu(dan[0])
        
        picker.dataSource = self
        picker.delegate = self
    }
    
    func gugu(_ num : Int){
        for i in 1...9{
            tvResult.text += "\(num) X \(i) = \(num*i) \n"
        }
    }
    
}//view

extension ViewController:UIPickerViewDataSource{
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumn // 종류
    }
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum //총 갯수
    }
    
}

extension ViewController:UIPickerViewDelegate{
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return "\(dan[row]) 단" // 보여지는것!
    }
    
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        tvResult.text = ""
        lblText.text = "\(dan[row]) 단"
        gugu(dan[row]) // 설정할경우 하는 행동
    }
}



    

