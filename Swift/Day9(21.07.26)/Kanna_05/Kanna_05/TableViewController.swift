//
//  TableViewController.swift
//  Kanna_05
//
//  Created by RayAri on 2021/07/26.
//

import UIKit
import Kanna

var itemList = [String]()
var urlList = [String]()

class TableViewController: UITableViewController {

    @IBOutlet var tvListView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        dataCrawling()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
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
            for title in doc.xpath("//*[@id='top_movies_main']/div/table/tr/td/a") {
                itemList.append("\(count) : \(title.text!.trimmingCharacters(in: .whitespacesAndNewlines))")
                urlList.append(title["href"]!)
                print(title["href"]!)
                count += 1
            }
            
        } catch let error {
            print("Error : \(error)")
        }
    }
    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return itemList.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        cell.textLabel?.text = itemList[indexPath.row]
        // Configure the cell...

        return cell
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        if segue.identifier == "sgDetail" {
            let cell = sender as! UITableViewCell // 위치정보를 semder로 받아서 cell타입으로 전달!
            let indexPath = self.tvListView.indexPath(for: cell) //위치정보 받음
            let detailView = segue.destination as! DetailViewController
            detailView.receivedData("https://www.rottentomatoes.com/\(urlList[indexPath!.row])")
        }
    }
    

}
