/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import model.TaiKhoan;
import repository.TaiKhoanRepository;
import untility.EmailSender;
import java.sql.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import javax.mail.MessagingException;

/**
 *
 * @author hodangquan
 */
public class XacThucService {
    TaiKhoanRepository TaiKhoanRepo;
    EmailSender emailSender;
        
    public XacThucService(){
        TaiKhoanRepo = new TaiKhoanRepository();
        emailSender = new EmailSender();
            
    }
        
    public boolean checkUesrandEmail (String username , String email) throws SQLException{
        List<TaiKhoan> taiKhoans = TaiKhoanRepo.layDSTaiKhoan();  
        for(TaiKhoan taiKhoan : taiKhoans){
            if(taiKhoan.getTenTK().equalsIgnoreCase(username) && taiKhoan.getEmail().equals(email)){
                return true;
            }
        }
                return false;
    }
    public boolean checkUsernametotai(String username) throws SQLException{
        List<TaiKhoan> taiKhoans = TaiKhoanRepo.layDSTaiKhoan();
        for(TaiKhoan taiKhoan : taiKhoans){
            if(taiKhoan.getTenTK().equalsIgnoreCase(username)){
                return true;
            }
        }
                return false;
    }
    public String taoPassmoi(){
        Random random = new Random();
        int number ;
        String result = "";
        for(int i = 0 ; i < 5 ; i++){
        number = random.nextInt(9);
        result += number;
    }
        String matKhau = "quan" + result;
        return matKhau;
    }
    public boolean capNhatPass(String username, String password) throws SQLException{
        return TaiKhoanRepo.capNhapPass(username, password);
    }
    public void guiMail(String Username , String email) throws SQLException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        ZonedDateTime now = ZonedDateTime.now();
        String time = dtf.format(now);
        try {
            TaiKhoan taiKhoan = TaiKhoanRepo.layTTTaiKhoanByUsername(Username);
            String title = "C???nh b??o " +time;
            String content = " C??? li???u ?????y b???n s???p m???t fb r???i ???y  :)) . <br>"
                    + "B???n v???a y??u c???u c???p nh???t l???i m???t kh???u cho t??i kho???n quanhd. <br>"
                    + "M???t kh???u m???i c???a b???n l??:  " + taiKhoan.getMatKhau();
            emailSender.guiMail(email, title, content);
        } catch (MessagingException ex) {
        }
    }
}
