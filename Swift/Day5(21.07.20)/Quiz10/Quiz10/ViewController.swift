//
//  ViewController.swift
//  Quiz10
//
//  Created by RayAri on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblNow: UILabel!
    @IBOutlet weak var lblAlarm: UILabel!
    
    let interval = 1.0
    let timeSelector : Selector = #selector(ViewController.updateTime)
    var alarm = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        updateTime()
        lblAlarm.text = "알람 시간을 선택하세요"
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true)
   }

    @IBAction func time(_ sender: UIDatePicker) {
        let datePickerView = sender
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm" // 24시간 HH
        lblAlarm.text = "선택시간 : \(formatter.string(from: datePickerView.date))"
        alarm = "\(formatter.string(from: datePickerView.date))"
    }
    
    @objc func updateTime(){
        let date = NSDate()
        let formatter = DateFormatter()
        let alramFormatter = DateFormatter()
        var nowAlarm = ""
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm:ss" // 24시간 HH
        lblNow.text = "현재시간 : \(formatter.string(from: date as Date))"
        
        //알람시간과 비교할 포맷!
        alramFormatter.locale = Locale(identifier: "ko")
        alramFormatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"
        nowAlarm = "\(alramFormatter.string(from: date as Date))"
        
        if nowAlarm == alarm {
            view.backgroundColor = UIColor.gray
            let AlarmAlert = UIAlertController (title: "알림", message: "설정된 시간입니다", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: {ACTION in
                                            self.view.backgroundColor = UIColor.white
                                            self.alarm = ""
            })
            
            AlarmAlert.addAction(onAction)
            AlarmAlert.view.backgroundColor = UIColor.yellow
            present(AlarmAlert, animated: true, completion: nil)
        }else{
            view.backgroundColor = UIColor.white
        }
        
    }
    
    
    
    
}

