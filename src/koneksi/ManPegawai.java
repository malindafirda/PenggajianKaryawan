/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ModelPegawai;

/**
 *
 * @author uuser
 */
public class ManPegawai {
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    
    public void loadDataPegawai(DefaultTableModel namatabel, String modf) throws SQLException{
          
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
        
        if(modf == null){
           sql = "SELECT * FROM tbl_pegawai as p, tbl_jabatan as j "
                    + "where p.jabatan = j.jabatan";
           }else{
            sql = "SELECT * FROM tbl_pegawai as p, tbl_jabatan as j "
                    + "where p.jabatan = j.jabatan or "
                    + "p.nama is like '%?%'";
            
            pst.setString(1, modf.toString());
            
        }
        pst = KoneksiDB.getConnect().prepareStatement(sql);
        
        rs = pst.executeQuery(sql);
            
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[4];
                o[0] = rs.getString("idpegawai");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("jabatan");
                o[3] = rs.getString("jamkerja");
 
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();
        

    }
    public boolean cekPegawai(ModelPegawai modp) throws SQLException {
        sql = "SELECT * from tbl_pegawai where idpegawai = ?";
                pst = KoneksiDB.getConnect().prepareStatement(sql);
                pst.setString(1, modp.getIdpegawai());
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
}
    
    public void updatePegawai(ModelPegawai modp) throws SQLException {
        
        sql = "UPDATE tbl_pegawai SET nama = ?, jabatan = ?, jamkerja= ?, "
                + "WHERE idpegawai= ?";
        pst = KoneksiDB.getConnect().prepareStatement(sql);
        pst.setString(1, modp.getIdpegawai());
        pst.setString(2, modp.getNama());
        pst.setString(3, modp.getJabatan());
        pst.setString(4, modp.getShift());

        pst.executeUpdate();
        pst.close();
    
    }
    public void tambahPegawai(ModelPegawai modp) throws SQLException {
        sql = "INSERT INTO tbl_pegawai values(?, ?, ?, ?)";
        pst = KoneksiDB.getConnect().prepareStatement(sql);
        
        pst.setString(1, modp.getIdpegawai());
        pst.setString(2, modp.getNama());
        pst.setString(3, modp.getJabatan());
        pst.setString(4, modp.getShift());

        pst.executeUpdate();
        pst.close();
        
    }
    
    public void hapusPegawai(ModelPegawai modp) throws SQLException {
    
        sql = "DELETE FROM tbl_pegawai WHERE idpegawai=? ";
        pst = KoneksiDB.getConnect().prepareStatement(sql);
        pst.setString(1, modp.getIdpegawai());
        
        pst.executeUpdate();
        pst.close();
    
    }    


    public List<ModelPegawai> cekPegawai() throws SQLException {
 
        
        Statement stm = (Statement) KoneksiDB.getConnect().createStatement();
        ResultSet rst = stm.executeQuery("CALL TampilPenerbit()");
        List<ModelPegawai> ListModelPegawai = new ArrayList<>();
        while (rst.next()){
            ModelPegawai modelPegawai = new ModelPegawai();
            modelPegawai.setIdpegawai(rst.getString("ID Pegawai"));
            modelPegawai.setNama(rst.getString("Nama"));
            modelPegawai.setJabatan(rst.getString("Jabatan"));
            modelPegawai.setShift(rst.getString("Shift"));
            ListModelPegawai.add(modelPegawai);
         }
        return ListModelPegawai;
       
    }
    }

   


