//
//  DetailViewController.swift
//  DBCRUD
//
//  Created by RayAri on 2021/07/28.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var tfCode: UITextField!
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfDept: UITextField!
    @IBOutlet weak var tfPhone: UITextField!
    
    var code = ""
    var name = ""
    var dept = ""
    var phone = ""

    
    override func viewDidLoad() {
        super.viewDidLoad()

        set()
        // Do any additional setup after loading the view.
    }
    
    func set() {
        tfCode.text = code
        tfName.text = name
        tfDept.text = dept
        tfPhone.text = phone
        
    }
    
    func receivedData(code:String, name:String, dept:String, phone:String) {
        self.code = code
        self.name = name
        self.dept = dept
        self.phone = phone
        
    }
    
    @IBAction func btnUpdate(_ sender: UIButton) {
        let code = tfCode.text
        let name = tfName.text
        let dept = tfDept.text
        let phone = tfPhone.text
        
        let UpdateModel = UpdateModel()
        let result = UpdateModel.updateItems(code: code!, name: name!, dept: dept!, phone: phone!)
        
        if result{
            let resultAlert = UIAlertController(title: "완료", message: "수정 되었습니다!", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "OK", style: .default, handler: { ACTION in
                self.navigationController?.popViewController(animated: true)
            })
            resultAlert.addAction(onAction)
            present(resultAlert, animated: true, completion: nil)
        }else{
            let resultAlert = UIAlertController(title: "실패", message: "에러가 발생 되었습니다!", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "OK", style: .default, handler: nil )
        
            resultAlert.addAction(onAction)
            present(resultAlert, animated: true, completion: nil)
        }
    }
        

    
    @IBAction func btnDelete(_ sender: UIButton) {
        let code = tfCode.text
        
        let DeleteModel = DeleteModel()
        let result = DeleteModel.deleteItems(code: code!)
        
        if result{
            let resultAlert = UIAlertController(title: "완료", message: "삭제 되었습니다!", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "OK", style: .default, handler: { ACTION in
                self.navigationController?.popViewController(animated: true)
            })
            resultAlert.addAction(onAction)
            present(resultAlert, animated: true, completion: nil)
        }else{
            let resultAlert = UIAlertController(title: "실패", message: "에러가 발생 되었습니다!", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "OK", style: .default, handler: nil )
        
            resultAlert.addAction(onAction)
            present(resultAlert, animated: true, completion: nil)
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
