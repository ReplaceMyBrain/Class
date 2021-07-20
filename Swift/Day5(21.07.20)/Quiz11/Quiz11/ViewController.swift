//
//  ViewController.swift
//  Quiz11
//
//  Created by RayAri on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lblNum1: UILabel!
    @IBOutlet weak var lblNum2: UILabel!
    @IBOutlet weak var tfResult: UITextField!
    
    var result = 0
    var inputResult = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        reset()
    }

    @IBAction func btnOk(_ sender: UIButton) {
        inputResult = Int(tfResult.text!) ?? 0
        result = Int(lblNum1.text!)! * Int(lblNum2.text!)!
        if inputResult == result {
            let alert = UIAlertController(title: "결과", message: "정답입니다.", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "다음 문제 진행", style: .default, handler: {ACTION in
                self.reset()
            })
            alert.addAction(onAction)
            present(alert, animated: true, completion: nil)
        }else{
            let alert = UIAlertController(title: "결과", message: "정답이 아닙니다.", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: {ACTION in
                self.tfResult.text = ""
            })
            alert.addAction(onAction)
            present(alert, animated: true, completion: nil)
        }
        
    }
    //다른곳 터치시 키보드 내림
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    //숫자랜덤 지정
    func random() ->String {
        return String(Int.random(in: 1..<10))
    }

    //랜덤값 셋팅
    func reset() {
        lblNum1.text = random()
        lblNum2.text = random()
        tfResult.text = ""
    }

}


