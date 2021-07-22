//
//  SelectViewController.swift
//  Quiz15
//
//  Created by RayAri on 2021/07/22.
//

import UIKit

class SelectViewController: UIViewController {

    @IBOutlet weak var swOn: UISwitch!
    @IBOutlet weak var swRed: UISwitch!
    
    var isOn : Bool = true
    var isRed : Bool = false
    
    var delegate : selectDelegate?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        swOn.isOn = isOn
        swRed.isOn = isRed


    }
    
    @IBAction func btnOK(_ sender: UIButton) {
    
        if delegate != nil {
            delegate?.didImageDone(self, isOn: isOn, isRed: isRed)
        }
        navigationController?.popViewController(animated: true)
    }
    @IBAction func swOnOff(_ sender: UISwitch) {
        if sender.isOn{
            isOn = true
            swRed.isEnabled = true
            
        }else{
            isOn = false
            swRed.isEnabled = false
            isRed = false
            swRed.isOn = false
        }
        
    }
    @IBAction func swRed(_ sender: UISwitch) {
        if isOn {
            if sender.isOn {
                isRed = true
            }else{
                isRed = false
            }
        }
//        else {
//            let lampOnAlert = UIAlertController (title: "램프를 켜세요!", message: "램프를 켜주세요", preferredStyle: .alert)
//            let offAction = UIAlertAction(title: "알겠습니다!", style: .default, handler: nil)
//
//            lampOnAlert.addAction(offAction)
//            present(lampOnAlert, animated: true, completion: nil)
            
           
        }
        
    }
