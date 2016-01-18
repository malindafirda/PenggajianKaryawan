/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ModelLogin;


/**
 *
 * @author uuser
 */
public class ManLogin {
public String status, nama;
public boolean cekLogin(ModelLogin user) throws SQLException {
     
        String sql = "SELECT * FROM tbl_login WHERE username = ? AND password = ?";
        PreparedStatement pst = KoneksiDB.getConnect().prepareStatement(sql);
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getPassword());
        
        ResultSet result;
        result = pst.executeQuery();
        status = result.getString("status");
        try {
            if (result.next()) {
                if("admin".equals(status)){
                return true;   
                }else if("user".equals(status)){
                return false;
            }   
        }
          
      } catch (Exception e) {
      }
    return false;
}}

       

