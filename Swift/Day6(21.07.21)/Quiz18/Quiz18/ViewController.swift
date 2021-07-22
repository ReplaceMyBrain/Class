//
//  ViewController.swift
//  Quiz18
//
//  Created by RayAri on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {

    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet weak var webView: WKWebView!
    
    var aUrl = [["네이버","www.naver.com"],["구글","www.google.com"],["다음","www.daum.net"]]
    
    var maxArrayNum  = 0
    let viewColumn = 1
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        maxArrayNum = aUrl.count

        loadWebPage(url: aUrl[0][1])
        
        picker.dataSource = self
        picker.delegate = self
        
    }
    
    func loadWebPage(url: String){
        let myUrl = URL(string: "https://\(url)")
        let myRequest = URLRequest(url: myUrl!)
        webView.load(myRequest)
    }
}// view

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
        return aUrl[row][0]
    }
    
    // pickerView에 Image선택
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        loadWebPage(url: aUrl[row][1])
    }
    
    
}

