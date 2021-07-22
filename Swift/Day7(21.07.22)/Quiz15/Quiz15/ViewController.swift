//
//  ViewController.swift
//  Quiz15
//
//  Created by RayAri on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imgView: UIImageView!
    
    let imgOn = UIImage(named: "lamp_on.png")
    let imgOff = UIImage(named: "lamp_off.png")
    let imgRed = UIImage(named: "lamp_red.png")
    
    var isOn = true
    var isRed = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imgView.image = imgOn
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let Select = segue.destination as! SelectViewController
        
        Select.delegate = self
        Select.isOn = self.isOn
        Select.isRed = self.isRed
        
    }
}//view

extension ViewController: selectDelegate {
    func didImageDone(_ controller: SelectViewController, isOn: Bool, isRed: Bool) {

        if isOn {
            imgView.image = imgOn
            self.isOn = true
            if isRed {
                imgView.image = imgRed
                self.isRed = true
            }else{
                self.isRed = false
            }
        } else {
            imgView.image = imgOff
            self.isOn = false
        }
    }
}

