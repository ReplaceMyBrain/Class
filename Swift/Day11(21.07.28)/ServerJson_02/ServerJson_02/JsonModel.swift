//
//  JsonModel.swift
//  ServerJson_02
//
//  Created by RayAri on 2021/07/28.
//

import Foundation

protocol JsonModelProtocol {
    func itemDownloaded(items: NSArray)
}

class JsonModel: NSObject{
    var delegate: JsonModelProtocol!
    let urlPath = "http://192.168.2.50:8080/ios/student.json"
    
    func downloadItems(){
        let url:URL = URL(string: urlPath)!
        let defaultSession = URLSession(configuration: URLSessionConfiguration.default)
        let task = defaultSession.dataTask(with: url){(data, response, error) in
            if error != nil {
                print("Failed to download data")
            }else{
                print("Data is downloaded")
                self.parseJSON(data!)
            }
        }
        task.resume()
    }
    
    //순서대로 받는법 JSONSerialization
    func parseJSON(_ data: Data){
        var jsonResult = NSArray()
        do{
            jsonResult = try JSONSerialization.jsonObject(with: data, options: JSONSerialization.ReadingOptions.allowFragments) as! NSArray //배열로 바꾸다!
        }catch let error as NSError{
            print(error)
        }
        var jsonElement = NSDictionary()
        let locations = NSMutableArray() //넣었다 뻇다 가능함!

        for i in 0..<jsonResult.count{
            jsonElement = jsonResult[i] as! NSDictionary
            if let scode = jsonElement["code"] as? String,
               let sname = jsonElement["name"] as? String,
               let sdept = jsonElement["dept"] as? String,
               let sphone = jsonElement["phone"] as? String{
                let query = DBModel(scode: scode, sname: sname, sdept: sdept, sphone: sphone)
                locations.add(query)
            }
        }
        //async 같이 진행된다!
        DispatchQueue.main.async(execute: {() -> Void in
                   self.delegate.itemDownloaded(items: locations)
        })
    }
}
