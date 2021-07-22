//
//  ViewController.swift
//  Quiz13-03
//
//  Created by RayAri on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {

    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    var aUrl = ["www.naver.com","www.google.com","www.daum.net"]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        loadWebPage(url: aUrl[0])
        
        pageControl.numberOfPages = aUrl.count
        pageControl.currentPage = 0
        pageControl.pageIndicatorTintColor = UIColor.green
        pageControl.currentPageIndicatorTintColor = UIColor.red
        
        makeSingleTouch()
        
    }
    @IBAction func pageChange(_ sender: UIPageControl) {
        loadWebPage(url: aUrl[pageControl.currentPage])
    }
    
    func loadWebPage(url: String){
        let myUrl = URL(string: "https://\(url)")
        let myRequest = URLRequest(url: myUrl!)
        webView.load(myRequest)
    }


    func makeSingleTouch(){
       
        //left
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGesture(_:)))
        swipeLeft.direction = UISwipeGestureRecognizer.Direction.left
        self.view.addGestureRecognizer(swipeLeft)
        
        //right
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGesture(_:)))
        swipeRight.direction = UISwipeGestureRecognizer.Direction.right
        self.view.addGestureRecognizer(swipeRight)
        
        
    }
    
    @objc func respondToSwipeGesture(_ gesture: UIGestureRecognizer){
        if let swipeGesture = gesture as? UISwipeGestureRecognizer{
           
            switch swipeGesture.direction {
            case UISwipeGestureRecognizer.Direction.left:
                pageControl.currentPage += 1
                loadWebPage(url: aUrl[pageControl.currentPage])
            case UISwipeGestureRecognizer.Direction.right:
                pageControl.currentPage -= 1
                loadWebPage(url: aUrl[pageControl.currentPage])
            default:
                break
            }
        }
        
    }
    
    
}

