package com.example.quoctuan.demoall.model;

/**
 * Created by Admin on 3/26/2017.
 */

public class KhachHang {

    private String ten;
    private int soLuong;
    private boolean isVip;
    public static final int GIA=20000;

    public KhachHang() {
    }

    public KhachHang(String ten, int soLuong, boolean isVip) {
        this.ten = ten;
        this.soLuong = soLuong;
        this.isVip = isVip;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean isVip) {
        this.isVip = isVip;
    }
    public double tinhThanhTien(){
        return (!isVip()?soLuong*GIA : soLuong*GIA*0.9);
    }
}
