//
//  ViewController.swift
//  CollectionView_image
//
//  Created by RayAri on 2021/07/26.
//

import UIKit

var list = ["flower_01.png","flower_02.png","flower_03.png","flower_04.png","flower_05.png","flower_06.png"]
class ViewController: UIViewController {

    
    @IBOutlet weak var collectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        collectionView.delegate = self
        collectionView.dataSource = self
    }
    
    //돌아올떄 실행반복 꼭필요함!
    override func viewWillAppear(_ animated: Bool) {
        collectionView.reloadData()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "sgDetail" {
            let cell = sender as! CollectionViewCell
            let indexPath = self.collectionView.indexPath(for: cell)
            let detailView = segue.destination as! DetailViewController
            detailView.receiveItems(list[indexPath!.row])
            
        }
    }


}//view

extension ViewController: UICollectionViewDataSource, UICollectionViewDelegate {
    
    //Cell 갯수
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return list.count
    }
    
    //Cell 구성
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        //reuse - 안드로이드에서는 리사이클러와 같음. 재시동됨.
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "myCell", for: indexPath) as! CollectionViewCell
        cell.img.image = UIImage(named: list[indexPath.row])
        return cell
    }
}

//cell layout 정의
extension ViewController: UICollectionViewDelegateFlowLayout{
    
    //위아래 간격
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 1
    }
    
    //옆 간격
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 1
    }
    
    // cell 사이즈 (옆 라인을 고려하여 설정)
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        // 3등분하여 배치, 옆간격이 1이므로 1을 빼줌
        let width = collectionView.frame.width / 3 - 1
        let size = CGSize(width: width, height: width)
        return size
    }
    
}

