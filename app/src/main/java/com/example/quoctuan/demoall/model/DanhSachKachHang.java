package com.example.quoctuan.demoall.model;

import java.util.ArrayList;

/**
 * Created by Admin on 3/26/2017.
 */

public class DanhSachKachHang {
    ArrayList<KhachHang> dsKH=new ArrayList<KhachHang>();
    public void addKH(KhachHang kh){
        dsKH.add(kh);
    }
    public double tongDoanhThu(){
        double tien=0.0;
        for (KhachHang kh:dsKH){
            tien+=kh.tinhThanhTien();
        }
        return tien;
    }
    public int tongKH(){
        return  dsKH.size();
    }
    public int tongKHVip(){
        int s=0;
        for (KhachHang kh:dsKH){
            if (kh.isVip()){
                s++;
            }
        }
        return s;
    }
}
