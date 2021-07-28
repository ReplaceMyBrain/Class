//
//  TableViewController.swift
//  DBCRUD
//
//  Created by RayAri on 2021/07/28.
//

import UIKit

class TableViewController: UITableViewController {

    @IBOutlet var listTableView: UITableView!
    var feedItem: NSArray = NSArray()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        let QueryModel = QueryModel()
        QueryModel.delegate = self
        QueryModel.downloadItems()
        
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    
    override func viewWillAppear(_ animated: Bool) {
        let QueryModel = QueryModel()
        QueryModel.delegate = self
        QueryModel.downloadItems()
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return feedItem.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell...
        
        let item: DBModel = feedItem[indexPath.row] as! DBModel
        
        cell.textLabel?.text = "성명 : \(item.sname!)"
        cell.detailTextLabel?.text = "학번 : \(item.scode!)"

        return cell
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }

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
            let indexPath = self.listTableView.indexPath(for: cell) //위치정보 받음
            let detailView = segue.destination as! DetailViewController
          
            let item: DBModel = feedItem[indexPath!.row] as! DBModel
            detailView.receivedData(code: item.scode!, name: item.sname!, dept: item.sdept!, phone: item.sphone!)
        }
        
    }
}

extension TableViewController: QueryModelProtocol{
    func itemDownloaded(items: NSArray) {
        feedItem = items
        self.listTableView.reloadData() // 재구성시켜줌!
    }
}

