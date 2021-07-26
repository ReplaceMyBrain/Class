//
//  DetailViewController.swift
//  Quiz17
//
//  Created by RayAri on 2021/07/23.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var lblName: UILabel!
    
    var receiveItem = ""
    var receiveImageFileName = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        lblName.text = receiveItem
        imgView.image = UIImage(named: receiveImageFileName)
        
        // Do any additional setup after loading the view.
    }
    
    func receiveItems(_ item: String, _ fileName: String) {
        receiveItem = item
        receiveImageFileName = fileName
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
