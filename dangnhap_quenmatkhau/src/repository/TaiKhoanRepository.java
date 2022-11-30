/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.TaiKhoan;




/**
 *
 * @author hodangquan
 */
public class TaiKhoanRepository {
    public static List<TaiKhoan> layDSTaiKhoan() throws SQLException{
        List<TaiKhoan> taiKhoans = new ArrayList();
        Connection con1 = DBContext.getConnection(); // lấy kết lối dữ liệu
        String query = "SELECT TenTK, MatKhau, HoTen, Email FROM TAIKHOAN"; // khởi tao truy vâns
        Statement statement = con1.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            String TenTK = rs.getString("TenTK");
            String MatKhau = rs.getString("MatKhau");
            String HoTen = rs.getString("HoTen");
            String Email = rs.getString("Email");
            
            TaiKhoan taiKhoan = new TaiKhoan(TenTK, MatKhau, HoTen, Email);
            taiKhoans.add(taiKhoan);
        }
        return taiKhoans;
    }
    
    public TaiKhoan layTTTaiKhoanByUsername(String TenTK) throws SQLException{
        Connection con1 = DBContext.getConnection(); // lấy kết lối dữ liệu
        String sql = "SELECT TenTK, MatKhau, HoTen, Email FROM TAIKHOAN WHERE TenTK LIKE ?"; // khởi tao truy vâns
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setString(1, TenTK);
        ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String tenTaiKhoan = rs.getString("TenTK");
                String matKhau = rs.getString("MatKhau");
                String hoTen = rs.getString("HoTen");
                String email = rs.getString("Email");
                
                TaiKhoan taiKhoan = new TaiKhoan(tenTaiKhoan, matKhau, hoTen, email);
                rs.close();
                statement.close();
                con1.close();
                
                return taiKhoan;
            }
        
        return null;
    }
    public boolean them(TaiKhoan taiKhoan) throws SQLException{
        Connection con1 = DBContext.getConnection();
        String sql = "INSERT INTO TAIKHOAN VALUES (?,?,?,?)";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setString(1, taiKhoan.getTenTK());
        statement.setString(2, taiKhoan.getMatKhau());
        statement.setString(3, taiKhoan.getHoTen());
        statement.setString(4, taiKhoan.getEmail());
        int index = statement.executeUpdate();
        
        con1.close();
        statement.close();
        
        if(index == 0){
            return false;
        }else{
            return true;
        }
        
    }
    
    public boolean capNhapPass(String username, String passUpdate) throws SQLException{
        Connection con1 = DBContext.getConnection();
        String sql = "UPDATE TAIKHOAN SET MatKhau = ? WHERE TenTK = ?";
        PreparedStatement statement = con1.prepareStatement(sql);
        statement.setString(1, passUpdate);
        statement.setString(2, username);
        int index = statement.executeUpdate();
        
        con1.close();
        statement.close();
        
        if(index == 0){
            return false;
        }else{
            return true;
        }   
    }
}