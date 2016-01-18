/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author uuser
 */
public class KoneksiDB {
    public static Connection koneksi;

    public static Connection getConnect(){
        //cek apakak koneksi null
        if(koneksi == null){
            
            try {
                String url;
                url = "jdbc:mysql://localhost:3306/db_penggajian";
                String user = "root";
                String password = "08071996";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url,user,password);
                
                
            } catch (SQLException t){
                JOptionPane.showMessageDialog(null, "Error Membuat Koneksi");
            }
        }
        
        return koneksi;
                
    }

}
