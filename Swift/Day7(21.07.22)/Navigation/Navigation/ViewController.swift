//
//  ViewController.swift
//  Navigation
//
//  Created by RayAri on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tfMessage: UITextField!
    @IBOutlet weak var imgView: UIImageView!
    
    let imgOn = UIImage(named: "lamp_on.png")
    let imgOff = UIImage(named: "lamp_off.png")
    
    var isOn = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        imgView.image = imgOn
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        //연결시켜주는 작업! 컨트롤러 연결작업![
        let editViewController = segue.destination as! EditViewController
        
        //연결마다 다르다!
        if segue.identifier == "editButton" {
            editViewController.textWayValue = "Segue : Use Button!"
        }else{
            editViewController.textWayValue = "Segue : Use Bar Button!"
        }
        
        editViewController.textMassage = tfMessage.text!
        
        editViewController.delegate = self // <<<중요하다! // 받아오는것 extension을 실행시킴!
        editViewController.isOn = self.isOn
        
        
    }
    
}//view

extension ViewController: EditDelegate {
    func didMessageEditDone(_ controller: EditViewController, message: String) {
        tfMessage.text = message
    }
    
    func didImageOnoffDone(_ controller: EditViewController, isOn: Bool) {
        if isOn {
            imgView.image = imgOn
            self.isOn = true
        }else {
            imgView.image = imgOff
            self.isOn = false
            
        }
    }
    
}

