//
//  DetailViewController.swift
//  
//
//  Created by RayAri on 2021/07/26.
//

import UIKit
import WebKit


class DetailViewController: UIViewController {

    @IBOutlet weak var myWeb: WKWebView!
    @IBOutlet weak var myIndicator: UIActivityIndicatorView!
    
    var url = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        print(url)
        webSetting(url)
        myWeb.navigationDelegate = self
        
    }
    
    func receivedData(_ receivedUrl: String) {
        url = receivedUrl
    }
    
    func webSetting(_ url: String) {
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        myWeb.load(myRequest)
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


extension DetailViewController: WKNavigationDelegate{
    func webView(_ webView: WKWebView, didCommit navigation: WKNavigation!) {
        myIndicator.startAnimating()
        myIndicator.isHidden = false
    }
    
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        myIndicator.stopAnimating()
        myIndicator.isHidden = true
    }
    
    func webView(_ webView: WKWebView, didFail navigation: WKNavigation!, withError error: Error) {
        myIndicator.stopAnimating()
        myIndicator.isHidden = true
    }
}
