/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Hadir;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author uuser
 */
public class Submit_hadir {
  Hadir h = new Hadir();
    
    public boolean cek_pegawai(Hadir karyawan) throws SQLException {
        
        String cek = "SELECT * FROM tbl_pegawai where idpegawai=?";
        PreparedStatement pst = KoneksiDB.getConnect().prepareStatement(cek);
        pst.setString(1, karyawan.getNIP());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return true;
        }else{
        return false;
    }
    }
    
   public boolean cek_kehadiran(Hadir karyawan) throws SQLException {
        
        String cek = "SELECT * from tblkehadiran where idpegawai=? and tanggal=curdate()";
        PreparedStatement pst = KoneksiDB.getConnect().prepareStatement(cek);
        pst.setString(1, karyawan.getNIP());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return false;
        }
        return true;

    }
   
   public boolean cek_jamMasuk(Hadir karyawan) throws SQLException {
        
        String cek = "SELECT * from tbl_pegawai where idpegawai=?";
        PreparedStatement pst = KoneksiDB.getConnect().prepareStatement(cek);
        pst.setString(1, karyawan.getNIP());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return false;
        }
        return true;

    }
        
        
    public List<Hadir> ambil(Hadir karyawan) throws SQLException {
        
        String cek = " SELECT * tbl_pegawai.idpegawai, tbl_pegawai.nama, tbl_jabatan.jabatan, "
                + "tbl_pegawai.jamkerja, tbljam.jam_kerja_mulai, tbljam.jam_kerja_selesai, "
                + "tbljam.jam_masuk_mulai, tbljam.jam_keluar_selesai "
                + "FROM tbl_pegawai, tbl_jabatan, tbljam WHERE tbl_pegawai.idpegawai = ? "
                + "and tbljam.jamkerja=tbl_pegawai.jamkerja and tbl_pegawai.jabatan = tbl_jabatan.idjabatan "
                + "group by idpegawai";
        
        PreparedStatement pst = KoneksiDB.getConnect().prepareStatement(cek);
        pst.setString(1, karyawan.getNIP());
        ResultSet rs;
        rs = pst.executeQuery();
        List<Hadir> list = new ArrayList<>();
        if(rs.next()){
            h.setNama(rs.getString("nama"));
            h.setJamKerja(rs.getString("jamkerja"));
            h.setJabatan(rs.getString("jabatan"));
            h.setMasukStart(rs.getTime("jam_masuk_mulai"));
            h.setKerjaStart(rs.getTime("jam_kerja_mulai"));
            h.setKerjaEnd(rs.getTime("jam_kerja_selesai"));
            h.setKeluarEnd(rs.getTime("jam_keluar_selesai"));
            list.add(h);
        }        
        return list;
    }
    
    
    public void masuk(String nip) throws SQLException {
                   
        String hadir = "INSERT INTO tblkehadiran(idpegawai, tanggal, jmasuk, jkeluar, jamkerja) VALUES( ?, CURDATE(), CURTIME(), ?, ?)";
        PreparedStatement pst = KoneksiDB.getConnect().prepareStatement(hadir);
        pst.setString(1, nip);
        pst.setTime(2, h.getKeluarEnd());
        pst.setString(3, h.getJamKerja());
        pst.executeUpdate();     
        
    }
        
    public void keluar(String nip) throws SQLException {
        
        String cek = "UPDATE tblkehadiran SET jkeluar=CURTIME() WHERE idpegawai=? and tanggal=curdate()";
        PreparedStatement pst = KoneksiDB.getConnect().prepareStatement(cek);
        pst.setString(1, nip);       
        pst.executeUpdate();       
        
    }  
}
