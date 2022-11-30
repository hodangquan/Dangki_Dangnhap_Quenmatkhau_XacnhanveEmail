/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hodangquan
 */
public class TaiKhoan {
    private String TenTK;
    private String MatKhau;
    private String HoTen;
    private String Email;

    public TaiKhoan(String TenTK, String MatKhau, String HoTen, String Email) {
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.Email = Email;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    
}
