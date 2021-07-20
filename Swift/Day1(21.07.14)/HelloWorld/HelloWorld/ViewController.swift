//
//  ViewController.swift
//  HelloWorld
//
//  Created by Hyeji on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    // TODO: comment TODO
    // MARK: comment MARK
    
    // viewDidLoad 위에 쓰는 건 선언자들!
    
    // Outlet을 통해서 Swift 소스 코드와 Main.storyboard 연결 (Outlet 연결 역할)
    // weak : 종료하면 메모리 삭제 (이게 default) strong : 종료하지 않으면 메모리 남아있게 함
    // IB는 Interface Builder
    @IBOutlet weak var lblHello: UILabel!
    //                 변수이름  :  데이터타입
    
    override func viewDidLoad() { // func : 함수
        // viewDidLoad는 onCreate라고 생각
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        // viewDidLoad가 실행되고 글자 출력
        lblHello.text = "Hello World!"

    }


}

