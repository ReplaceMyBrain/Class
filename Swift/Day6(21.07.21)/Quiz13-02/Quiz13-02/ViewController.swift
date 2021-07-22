//
//  ViewController.swift
//  Quiz13-02
//
//  Created by RayAri on 2021/07/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    var imgLeft = [UIImage]()
    var imgRight = [UIImage]()
    
    var images = ["flower_01.png","flower_02.png","flower_03.png","flower_04.png","flower_05.png","flower_06.png",]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        imgView.image = UIImage(named: images[0])
        
        pageControl.numberOfPages = images.count
        pageControl.currentPage = 0
        pageControl.pageIndicatorTintColor = UIColor.green
        pageControl.currentPageIndicatorTintColor = UIColor.red
        
        makeSingleTouch()
        
        
    }

    @IBAction func pageChange(_ sender: UIPageControl) {
        
        imgView.image = UIImage(named: images[pageControl.currentPage])
        
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
                imgView.image = UIImage(named: images[pageControl.currentPage])
            case UISwipeGestureRecognizer.Direction.right:
                pageControl.currentPage -= 1
                imgView.image = UIImage(named: images[pageControl.currentPage])
            default:
                break
            }
        }
        
    }
    
    
}

