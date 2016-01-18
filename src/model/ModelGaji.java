/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author uuser
 */
public class ModelGaji {
    private String idpegawai;
    private String nama;
    private String jabatan;
    
    private String shift;
    private String Gaji;

    public String getGaji() {
        return Gaji;
    }

    public void setGaji(String Gaji) {
        this.Gaji = Gaji;
    }
    

    public String getIdpegawai() {
        return idpegawai;
    }

    public void setIdpegawai(String idpegawai) {
        this.idpegawai = idpegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

   /*public String getTampung_jabatan() {
        return tampung_jabatan;
    }

    public void setTampung_jabatan(String tampung_jabatan) {
        this.tampung_jabatan = tampung_jabatan;
    }*/

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

}
     

