//
//  ViewController.swift
//  Quiz07
//
//  Created by RayAri on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblNow: UILabel!
    @IBOutlet weak var lblAlarm: UILabel!
    
    let interval = 1.0 // 1초
    let timeSelector : Selector = #selector(ViewController.updateTime)
    var alarm = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lblAlarm.text = "시간을 선택하세요!"
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true)
    }

    @IBAction func changeDatePicker(_ sender: UIDatePicker) {
        let datePickerView = sender
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm" // 24시간 HH
        lblAlarm.text = "알림시간 : \(formatter.string(from: datePickerView.date))"
        alarm = "\(formatter.string(from: datePickerView.date))"
        
    }
    
    //현재 시간을 정의
    @objc func updateTime() {
        let date = NSDate() // Next Step의 약자
        let formatter = DateFormatter()
        let alramFormatter = DateFormatter()
        var nowAlarm = ""
    	
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm:ss"
        lblNow.text = "현재시간 : \(formatter.string(from: date as Date))" //타입변경!
        
        //알람시간과 비교할 포맷!
        alramFormatter.locale = Locale(identifier: "ko")
        alramFormatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"
        nowAlarm = "\(alramFormatter.string(from: date as Date))"
        
        if nowAlarm == alarm {
            let sec:Int = Int(formatter.string(from: date as Date).suffix(2)) ?? 0
            
            switch sec%2 == 0 {
            case true:
                view.backgroundColor = UIColor.red
            default:
                view.backgroundColor = UIColor.blue
            }
        }else{
            view.backgroundColor = UIColor.white
        }
        
        
        
    }
    
}

