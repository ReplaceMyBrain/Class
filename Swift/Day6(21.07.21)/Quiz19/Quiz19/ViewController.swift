//
//  ViewController.swift
//  Quiz19
//
//  Created by RayAri on 2021/07/21.
//

import UIKit
import WebKit


class ViewController: UIViewController {

    @IBOutlet weak var lblUrl: UILabel!
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    var aUrl = ["www.naver.com","www.google.com","www.daum.net"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        loadWebPage(url: aUrl[0])
        lblUrl.text = aUrl[0]
        
        pageControl.numberOfPages = aUrl.count
        pageControl.currentPage = 0
        pageControl.pageIndicatorTintColor = UIColor.green
        pageControl.currentPageIndicatorTintColor = UIColor.red
        
    }

    
    func loadWebPage(url: String){
        let myUrl = URL(string: "https://\(url)")
        let myRequest = URLRequest(url: myUrl!)
        webView.load(myRequest)
    }
    
    @IBAction func pageChange(_ sender: UIPageControl) {
        loadWebPage(url: aUrl[pageControl.currentPage])
        lblUrl.text = aUrl[pageControl.currentPage]
    }
    

}

