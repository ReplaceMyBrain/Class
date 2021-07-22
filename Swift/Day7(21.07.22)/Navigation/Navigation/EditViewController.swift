//
//  EditViewController.swift
//  Navigation
//
//  Created by RayAri on 2021/07/22.
//

import UIKit

class EditViewController: UIViewController {

    @IBOutlet weak var lblWay: UILabel!
    @IBOutlet weak var tfMessage: UITextField!
    @IBOutlet weak var lblOnOff: UILabel!
    @IBOutlet weak var swIsOn: UISwitch!
    
    var textWayValue : String = ""
    var textMassage : String = ""
    var isOn : Bool = false
    
    var delegate : EditDelegate?
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lblWay.text = textWayValue
        tfMessage.text = textMassage
        
        swIsOn.isOn = isOn
        if isOn {
            lblOnOff.text = "ON"
        }else{
            lblOnOff.text = "OFF"
        }
        
    }
    
    @IBAction func btnDone(_ sender: UIButton) {
        if delegate != nil {
            delegate?.didMessageEditDone(self, message: tfMessage.text!)
            delegate?.didImageOnoffDone(self, isOn: isOn)
        }
        navigationController?.popViewController(animated: true)
    }
    
    @IBAction func swImageOff(_ sender: UISwitch) {
        if sender.isOn {
            isOn = true
            lblOnOff.text = "ON"
        }else{
            isOn = false
            lblOnOff.text = "OFF"
        }
        
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
