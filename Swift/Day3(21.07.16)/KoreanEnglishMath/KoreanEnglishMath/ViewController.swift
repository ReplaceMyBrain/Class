//
//  ViewController.swift
//  KoreanEnglishMath
//
//  Created by RayAri on 2021/07/16.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lblName: UILabel!
    @IBOutlet weak var inputNum: UITextField!
    @IBOutlet weak var lblResult: UILabel!
    
    var count=0
    var sum=0
    let subject=["국어점수","영어점수","수학점수","요약"]
    var score:[Int]=[]

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?){ self.view.endEditing(true) }
    
    
    @IBAction func btnCal(_ sender: UIButton) {
        if(checkNum()==1){
            calculate()
        }
    }
    
    func checkNum() ->Int{
        let intNum=Int(inputNum.text!) ?? -1
        
        if intNum == -1 || intNum>100{
            lblResult.text="올바른 점수를 입력하세요!"
            return 0
        }else{
            return 1
        }
    }
    
    func calculate(){
        sum+=Int(inputNum.text!)!
        count+=1
        if count>3{
            count=0
            lblName.text="\(subject[count])"
            inputNum.text=""
            inputNum.isHidden=false
        }else if count==3{
            lblName.text="\(subject[count])"
            score.append(Int(inputNum.text!)!)
            inputNum.isHidden=true
            printResult()
        }else{
            lblName.text="\(subject[count])"
            score.append(Int(inputNum.text!)!)
            inputNum.text=""
        }
        
    }
    
    func printResult(){
        let avg=Double(sum/3)
        
        lblResult.text="총점은 \(sum)입니다.\n 평균은 \(String(format:"%.2f",avg))입니다."
        
        for i in 0...2{
            var message:String
            if Double(score[i])>avg{
                message="\n \(subject[i])는 \(score[i])으로 평균보다 높습니다."
            }else if Double(score[i])==avg{
                message="\n \(subject[i])는 \(score[i])으로 평균과 같습니다."
            }else{
                message="\n \(subject[i])는 \(score[i])으로 평균보다 낮습니다."
            }
            lblResult.text?.append(message)
        }
        
        
    }

}

