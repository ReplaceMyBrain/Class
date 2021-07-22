//
//  ViewController.swift
//  Date Picker
//
//  Created by RayAri on 2021/07/19.
//

import UIKit

class DateViewController: UIViewController {

    @IBOutlet weak var lblCurrentTime: UILabel!
    @IBOutlet weak var lblPiclerTime: UILabel!
    
    let interval = 1.0 // 1초
    let timeSelector : Selector = #selector(DateViewController.updateTime)
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lblPiclerTime.text = "시간을 선택하세요!"
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true)
        
    }

    @IBAction func changeDatePicker(_ sender: UIDatePicker) {
        let datePickerView = sender
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm" // 24시간 HH
        lblPiclerTime.text = "선택시간 : \(formatter.string(from: datePickerView.date))"
        
    }
    
    //#들어가면 @필요함! 잊지말것!!
    //이게 있기 떄문에 시간이 보이는 거임!
    @objc func updateTime() {
        let date = NSDate() // Next Step의 약자
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm:ss"
        lblCurrentTime.text = "현재시간 : \(formatter.string(from: date as Date))" //타입변경!
    }
    
}//View

