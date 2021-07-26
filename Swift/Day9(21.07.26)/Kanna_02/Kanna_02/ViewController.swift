//
//  ViewController.swift
//  Kanna_02
//
//  Created by RayAri on 2021/07/26.
//

import UIKit
import Kanna

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        dataCrawling()
    }

    func dataCrawling() {
        let mainUrl = "https://www.rottentomatoes.com/top/bestofrt/?year=2019"
        // nil 들어올 수 있기에 guard let 사용
        guard let main = URL(string: mainUrl) else {
            // nil 값일 경우 에러 메세지
            print("Error : \(mainUrl) doesn't seem to be a valid URL")
            return }
        do {
            // //*[@id="top_movies_main"]/div/table/tbody/tr[1]/td[3]/a
            // //*[@id="top_movies_main"]/div/table/tr/td/a

            // url을 utf8로 인코딩한다!
            let htmlData = try String(contentsOf: main, encoding: .utf8)
            // Kanna import 해야만 보임!!!
            // htmlData를 utf8로 인코딩한다!
            let doc = try HTML(html: htmlData, encoding: .utf8)
            
            var count = 1 // 앞에 번호 쓰려고 1234 써주려고 썼음
            for title in doc.xpath("//*[@id='top_movies_main']/div/table/tr/td/a"){
                print(count, title.text!.trimmingCharacters(in: .whitespacesAndNewlines))
                count += 1
            }
            
        } catch let error {
            print("Error : \(error)")
        }
    }
} // ViewController

