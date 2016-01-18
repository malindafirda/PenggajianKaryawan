/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;

/**
 *
 * @author uuser
 */
public class Hadir {
    private String NIP;
    private String Nama;
    private String Jabatan;
    private String JamKerja;
    private Time MasukStart;
    private Time KerjaStart;
    private Time KerjaEnd;
    private Time KeluarEnd;
    
    public void setNIP(String nip){
        this.NIP = nip;
    }

    public String getNIP(){
        return NIP;
    }
    
        public void setMasukStart(Time jam){
        this.MasukStart = jam;
    }

    public Time getMasukStart(){
        return MasukStart;
    }

    public Time getKerjaStart() {
        return KerjaStart;
    }

    public void setKerjaStart(Time KerjaStart) {
        this.KerjaStart = KerjaStart;
    }

    public Time getKerjaEnd() {
        return KerjaEnd;
    }

    public void setKerjaEnd(Time KerjaEnd) {
        this.KerjaEnd = KerjaEnd;
    }

    public Time getKeluarEnd() {
        return KeluarEnd;
    }

    public void setKeluarEnd(Time KeluarEnd) {
        this.KeluarEnd = KeluarEnd;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }


    public String getJabatan() {
        return Jabatan;
    }

  
    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }


    public String getJamKerja() {
        return JamKerja;
    }

   
    public void setJamKerja(String JamKerja) {
        this.JamKerja = JamKerja;
    }

    public void getNIP(String nip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
