/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calista02.dao;

import Calista02.model.Mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calista
 */
public class MahasiswaDb {
    
    public void insert (Mahasiswa mahasiswa) throws Exception {
        DBHelper db = new DBHelper();
        String query = "insert into mahasiswa values(?,?,?,?,?)";
       PreparedStatement ps = db.getKoneksi().prepareStatement(query);
       ps.setString(1, mahasiswa.getNobp());
       ps.setString(2, mahasiswa.getNama());
       ps.setString(3, mahasiswa.getAlamat());
       ps.setString(4, mahasiswa.getJenisKelamin());
       ps.setString(5, mahasiswa.getTglalhir());
       ps.executeUpdate();
    }
    
    public void update(Mahasiswa mahasiswa) throws Exception {
        DBHelper db = new DBHelper();
        String query = "update mahasiswa set nama =?, alamat=? "
                +"jenis jeniskelamin=?, tanggallahir=? where nobp=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
       ps.setString(1, mahasiswa.getNobp());
       ps.setString(2, mahasiswa.getNama());
       ps.setString(3, mahasiswa.getAlamat());
       ps.setString(4, mahasiswa.getJenisKelamin());
       ps.setString(5, mahasiswa.getTglalhir());
       ps.executeUpdate();
    }
            
    public void delete(String nobp) throws Exception {
        DBHelper db = new DBHelper();
        String query = "delete from mahasiswa where nobp = ?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, nobp);
        ps.executeUpdate();
    }
    
    public Mahasiswa getMahasiswa(String nobp) throws Exception{
        DBHelper db = new DBHelper();
        String query = "select * from mahasiswa where nobp=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, nobp);
        Mahasiswa mahasiswa = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            mahasiswa = new Mahasiswa();
            mahasiswa.setNobp(rs.getString(1));
            mahasiswa.setNama(rs.getString(2));
            mahasiswa.setAlamat(rs.getString(3));
            mahasiswa.setJenisKelamin(rs.getString(4));
            mahasiswa.setTglalhir(rs.getString(5));
        }
        return mahasiswa;
    }
    
    public List<Mahasiswa> getAllMahasiswa() throws Exception{
        DBHelper db = new DBHelper();
        String query = "select * from mahasiswa";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        List<Mahasiswa> list = new ArrayList();
        Mahasiswa mahasiswa = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            mahasiswa = new Mahasiswa();
            mahasiswa.setNobp(rs.getString(1));
            mahasiswa.setNama(rs.getString(2));
            mahasiswa.setAlamat(rs.getString(3));
            mahasiswa.setJenisKelamin(rs.getString(4));
            mahasiswa.setTglalhir(rs.getString(5));
        }
        return list;  
    }
}
