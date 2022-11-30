/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.util.List;
import model.TaiKhoan;
import repository.TaiKhoanRepository;



/**
 *
 * @author hodangquan
 */
public class TaiKhoanService {
    TaiKhoanRepository taiKhoanRepository;
    public TaiKhoanService(){
        taiKhoanRepository = new TaiKhoanRepository();
    }
    public boolean xacThuc(String username , String password) throws SQLException{
        TaiKhoan taiKhoan = taiKhoanRepository.layTTTaiKhoanByUsername(username);
        if(taiKhoan == null){
            return false;
        }
        if(!taiKhoan.getMatKhau().equals(password)){
            return false;
        }
        return true;
    }
    public boolean them(TaiKhoan taiKhoan) throws SQLException{
        return taiKhoanRepository.them(taiKhoan);
    }
    public boolean checkUesrnametontai(String username) throws SQLException{
        List<TaiKhoan> taiKhoans = TaiKhoanRepository.layDSTaiKhoan();
        for (TaiKhoan taiKhoan : taiKhoans){
            if(taiKhoan.getTenTK().equalsIgnoreCase(username)){
                return false;
            }
        }
        return true;
    }
   
}
