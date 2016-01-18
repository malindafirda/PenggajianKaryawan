/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.ModelGaji;
import model.ModelPegawai;

/**
 *
 * @author uuser
 */
public class ManGajiPegawai {
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    
    public void loadGajiPegawai(DefaultTableModel tabel, String mode) throws SQLException{
          
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        
        if(mode == null){
           sql = "SELECT * FROM tbl_gajipegawai as g, tbl_jabatan as j "
                    + "where g.jabatan = j.jabatan";
           }else{
            sql = "SELECT * FROM tbl_gajipegawai as g, tbl_jabatan as j "
                    + "where g.jabatan = j.jabatan or "
                    + "g.nama is like '%?%'";
            
            pst.setString(1, mode.toString());
            
        }
        pst = KoneksiDB.getConnect().prepareStatement(sql);
        
        rs = pst.executeQuery(sql);
            
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[5];
                o[0] = rs.getString("idpegawai");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("jabatan");
                o[3] = rs.getString("jamkerja");
                o[4] = rs.getString("gaji");
 
            tabel.addRow(o);
            }
            rs.close();
            pst.close();
        

    }
    public boolean cekGajiPegawai(ModelGaji mogj) throws SQLException {
        sql = "SELECT * from tbl_gajipegawai where idpegawai = ?";
                pst = KoneksiDB.getConnect().prepareStatement(sql);
                pst.setString(1, mogj.getIdpegawai());
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
}
    
    public void updateGajiPegawai(ModelGaji mogj) throws SQLException {
        
        sql = "UPDATE tbl_gajipegawai SET nama =?, jabatan =?, jamkerja=?, gaji=? "
                + "WHERE idpegawai=?";
        pst = KoneksiDB.getConnect().prepareStatement(sql);
        
        pst.setString(1, mogj.getIdpegawai());
        pst.setString(2, mogj.getNama());
        pst.setString(3, mogj.getJabatan());
        pst.setString(4, mogj.getShift());
        pst.setString(5, mogj.getGaji());

        pst.executeUpdate();
        pst.close();
        
    
    }
    
    public void tambahGajiPegawai(ModelGaji mogj) throws SQLException {
        sql = "INSERT INTO tbl_gajipegawai values(?, ?, ?, ?, ?)";
        pst = KoneksiDB.getConnect().prepareStatement(sql);
        
        pst.setString(1, mogj.getIdpegawai());
        pst.setString(2, mogj.getNama());
        pst.setString(3, mogj.getJabatan());
        pst.setString(4, mogj.getShift());
        pst.setString(5, mogj.getGaji());

        pst.executeUpdate();
        pst.close();
        
    }
    
    public void hapusGajiPegawai(ModelGaji mogj) throws SQLException {
    
        sql = "DELETE FROM tbl_gajipegawai WHERE idpegawai=? ";
        pst = KoneksiDB.getConnect().prepareStatement(sql);
        pst.setString(1, mogj.getIdpegawai());
        
        pst.executeUpdate();
        pst.close();
    
    }    
}    

