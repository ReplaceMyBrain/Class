//
//  ViewController.swift
//  avgGrade
//
//  Created by RayAri on 2021/07/16.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var Korean: UITextField!
    @IBOutlet weak var Math: UITextField!
    @IBOutlet weak var English: UITextField!
    @IBOutlet weak var lblMessage: UILabel!
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnCal(_ sender: UIButton) {
        let nums=numCheck()
        
        let result = avg(gradeK: nums.0, gradeM: nums.1, gradeE: nums.2)
        grade(result:result)
    }
    
    func avg(gradeK:Int,gradeM:Int,gradeE:Int) -> Double{
        let result=Double(gradeK+gradeM+gradeE)/3
        return result
    }
    
    func grade(result:Double){
        var grade:String
        switch result{
        case 90..<101:
            grade="A"
        case 80..<91:
            grade="B"
        case 70..<81:
            grade="C"
        case 60..<71:
            grade="D"
        case 0..<61:
            grade="F"
        default:
            grade="올바르지 않은 등급"
        }
        
        lblMessage.text="평균은 \(String(format:"%.2f",result))이고 등급은 \(grade)입니다."
    }
    
    func numCheck() ->(Int,Int,Int){
        var gradeK=Int(Korean.text!) ?? 0
        var gradeM=Int(Math.text!) ?? 0
        var gradeE=Int(English.text!) ?? 0
        
        if(gradeK>100||gradeK<0){
            gradeK=0
        }
        
        if(gradeM>100||gradeM<0){
            gradeM=0
        }
        
        if(gradeE>100||gradeE<0){
            gradeE=0
        }
        
        return (gradeK,gradeM,gradeE)
    }
    
}

