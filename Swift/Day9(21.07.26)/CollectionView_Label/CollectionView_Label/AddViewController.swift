//
//  AddViewController.swift
//  CollectionView_Label
//
//  Created by RayAri on 2021/07/26.
//

import UIKit

class AddViewController: UIViewController {

    @IBOutlet weak var tfHuman: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func btnAppendHuman(_ sender: UIButton) {
        list.append(tfHuman.text!)
        navigationController?.popViewController(animated: true)
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
