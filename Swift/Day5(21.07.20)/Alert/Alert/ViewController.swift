//
//  ViewController.swift
//  Alert
//
//  Created by RayAri on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lampImage: UIImageView!
    
    let imgOn = UIImage(named: "lamp_on.png")
    let imgOff = UIImage(named: "lamp_off.png")
    let imgRemove = UIImage(named: "lamp_remove.png")
    
    var isLampOn = true // Lamp state
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lampImage.image = imgOn
    }

    @IBAction func btnLampOn(_ sender: UIButton) {
        if isLampOn {
            let lampOnAlert = UIAlertController (title: "경고", message: "현재 On상태 입니다.", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: nil)
            
            lampOnAlert.addAction(onAction)
            present(lampOnAlert, animated: true, completion: nil)
            
        }else{
            lampImage.image = imgOn
            isLampOn = true
        }
    }
    
    @IBAction func btnLampOff(_ sender: UIButton) {
        
        if isLampOn {
            
            let lampOnAlert = UIAlertController (title: "램프 끄기", message: "램프를 끄겠습니까?", preferredStyle: .alert)
            let offAction = UIAlertAction(title: "네", style: .default, handler: {ACTION in
                    self.lampImage.image = self.imgOff
                    self.isLampOn = false})
            
            let nonAction = UIAlertAction(title: "아니요", style: .default, handler: nil)
            
            lampOnAlert.addAction(offAction)
            lampOnAlert.addAction(nonAction)
            present(lampOnAlert, animated: true, completion: nil)
            
        }else{
            let lampOnAlert = UIAlertController (title: "경고", message: "현재 OFF상태 입니다.", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: nil)
            
            lampOnAlert.addAction(onAction)
            present(lampOnAlert, animated: true, completion: nil)
            
        }
    }
    
    @IBAction func btnLampRemove(_ sender: UIButton) {
        
        let lampOnAlert = UIAlertController (title: "램프 제거?", message: "램프를 제거할까요?", preferredStyle: .alert)
        let offAction = UIAlertAction(title: "아니요, 끕니다!", style: .default, handler: {ACTION in
                                        self.lampImage.image = self.imgOff
                                        self.isLampOn = false})
        let nonAction = UIAlertAction(title: "아니요, 켭니다!", style: .default, handler: {ACTION in
                                        self.lampImage.image = self.imgOn
                                        self.isLampOn = true})
        let removeAction = UIAlertAction(title: "네, 제거합니다!", style: .default, handler:{ACTION in
                                        self.lampImage.image = self.imgRemove})
        
        lampOnAlert.addAction(offAction)
        lampOnAlert.addAction(nonAction)
        lampOnAlert.addAction(removeAction)
        present(lampOnAlert, animated: true, completion: nil)
        
    }
    
    
}

