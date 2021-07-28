//
//  DBModel.swift
//  DBCRUD
//
//  Created by RayAri on 2021/07/28.
//

import Foundation

class DBModel: NSObject {
    var scode: String?
    var sname: String?
    var sdept: String?
    var sphone: String?
    
    //empty constructor *꼭 만들고 시작할것!!
    override init() {

    }
    
    init(scode: String, sname: String, sdept: String, sphone: String) {
        self.scode = scode
        self.sname = sname
        self.sdept = sdept
        self.sphone = sphone
    }
}

