//
//  ViewController.swift
//  Computer
//
//  Created by Hyeji on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfSize: UITextField!
    @IBOutlet weak var tfWeight: UITextField!
    @IBOutlet weak var tfBag: UITextField!
    @IBOutlet weak var tfColor: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    } // viewDidLoad

    // 버튼 이름을 바꾸지 않는 이상 @Outlet 사용 안해도 됨! 버튼 클릭 액션만 주는 경우 action 함수 생성
    @IBAction func btnOK(_ sender: UIButton) {
        let name: String = "맥북프로"
        let size: Int = 16
        let weight: Double  = 2.56
        let bag: Bool = false
        let color: Character = "은"

        // tf.text text 쓰는 것 잊지 말기! (화면에 뜨는 건 다 text이기 때문)
        tfName.text = name
        // String으로 타입 변환하여 사용해야 함! text가 String 이기 때문!
        tfSize.text = String(size)
        tfWeight.text = String(weight)
        tfBag.text = String(bag)
        tfColor.text = String(color)
        
    } // btnOK
    
    @IBAction func btnClear(_ sender: UIButton) {
        tfName.text = ""
        // String으로 타입 변환하여 사용해야 함! text가 String 이기 때문!
        tfSize.text = ""
        tfWeight.text = ""
        tfBag.text = ""
        tfColor.text = ""
    } // btnClear
    
} // ViewController

