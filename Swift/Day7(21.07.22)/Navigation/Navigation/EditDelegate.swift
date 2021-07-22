//
//  EditDelegate.swift
//  Navigation
//
//  Created by RayAri on 2021/07/22.
//
// Protocol : 자바의 interface

protocol EditDelegate {
    func didMessageEditDone(_ controller: EditViewController, message: String)
    func didImageOnoffDone(_ controller: EditViewController, isOn: Bool)
}
