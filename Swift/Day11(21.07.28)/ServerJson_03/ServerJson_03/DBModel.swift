//
//  DBModel.swift
//  ServerJson_03
//
//  Created by RayAri on 2021/07/28.
//

import Foundation

class DBModel: NSObject {
    var sname: String?
    var sphone: String?
    var simg: String?
    
    //empty constructor *꼭 만들고 시작할것!!
    override init() {

    }
    
    init(sname: String, sphone: String, simg:String) {
        self.sname = sname
        self.sphone = sphone
        self.simg = simg
    }
}
