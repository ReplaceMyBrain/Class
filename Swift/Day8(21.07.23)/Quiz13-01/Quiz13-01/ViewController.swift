//
//  ViewController.swift
//  Quiz13-01
//
//  Created by RayAri on 2021/07/23.
//

import UIKit
import MapKit

class ViewController: UIViewController {
    
    @IBOutlet weak var pageControl: UIPageControl!
    @IBOutlet weak var myMap: MKMapView!
    
    let map = [("혜화문",37.5878892,127.0037098),("홍인지문",37.5711907,127.009506),("창의문",37.5926027,126.9664771),("숙정문",37.5956584,126.9810576)]
    override func viewDidLoad() {
        super.viewDidLoad()
        
        pageControl.numberOfPages = map.count
        pageControl.currentPage = 0
        pageControl.pageIndicatorTintColor = UIColor.green
        pageControl.currentPageIndicatorTintColor = UIColor.red
    
        mapMove(map[0].1, map[0].2, map[0].0)
    }

    @IBAction func pageChange(_ sender: UIPageControl) {
        mapMove(map[pageControl.currentPage].1, map[pageControl.currentPage].2, map[pageControl.currentPage].0)
        
    }
    
    func mapMove(_ lat: CLLocationDegrees, _ lon: CLLocationDegrees, _ txt1: String) {
        // 지도 모양 정의 (가운데 부분)
        let pLoc = CLLocationCoordinate2DMake(lat, lon)
        // 지도 모양 배율
        let pSpan = MKCoordinateSpan(latitudeDelta: 0.02, longitudeDelta: 0.02)
        // 좌표 정보
        let pRegion = MKCoordinateRegion(center: pLoc, span: pSpan)
        // 현재 지도를 좌표 정보로 보이기
        myMap.setRegion(pRegion, animated: true)

        // 여기에 우리가 만든 핀 함수 넣기!!!!
        setPoint(pLoc, txt1)
    }
    
    func setPoint(_ loc: CLLocationCoordinate2D, _ txt1: String) {
        let pin = MKPointAnnotation()
        
        pin.coordinate = loc
        pin.title = txt1
        
        myMap.addAnnotation(pin)
    }
    
    
} // view
