//
//  ViewController.swift
//  Quiz13
//
//  Created by RayAri on 2021/07/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var page: UIPageControl!
    @IBOutlet weak var lblNum: UILabel!
    
    var num = Array<Int>(1...10)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        lblNum.text = String(num[0])
        lblNum.textColor = UIColor.red
        
        page.numberOfPages = num.count
        page.currentPage = 0
        page.pageIndicatorTintColor = UIColor.green
        page.currentPageIndicatorTintColor = UIColor.red
        
    }

    @IBAction func pageControl(_ sender: UIPageControl) {
        
        lblNum.text = String(num[page.currentPage])
        
        if num[page.currentPage]%2 == 0{
            lblNum.textColor = UIColor.blue
        }else {
            lblNum.textColor = UIColor.red
        }
        
    }
    
}

