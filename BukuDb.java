/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calista02.dao;

import Calista02.model.Buku;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Calista
 */
public class BukuDb {
    public void insert (Buku buku) throws Exception {
        DBHelper db = new DBHelper();
        String query = "insert into Buku values(?,?,?,?,?)";
       PreparedStatement ps = db.getKoneksi().prepareStatement(query);
       ps.setString(1, buku.getKodebuku());
       ps.setString(2, buku.getJudul());
       ps.setString(3, buku.getPengarang());
       ps.setString(4, buku.getPenerbit());
       ps.setString(5, buku.getTahun());
       ps.executeUpdate();
    }
    
    public void update(Buku buku) throws Exception {
        DBHelper db = new DBHelper();
        String query = "update buku set tahun =?, judul=? "
                +"pengarang=?, penerbit=? where kode=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
       ps.setString(1, buku.getKodebuku());
       ps.setString(2, buku.getJudul());
       ps.setString(3, buku.getPengarang());
       ps.setString(4, buku.getPenerbit());
       ps.setString(5, buku.getTahun());
       ps.executeUpdate();
    }
            
    public void delete(String kode) throws Exception {
        DBHelper db = new DBHelper();
        String query = "delete from buku where kode = ?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
    
    public Buku getBuku(String kode) throws Exception{
        DBHelper db = new DBHelper();
        String query = "select * from buku where kode=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, kode);
        Buku buku = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            buku = new Buku();
            buku.setKodebuku(rs.getString(1));
            buku.setJudul(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            buku.setTahun(rs.getString(5));
        }
        return buku;
    }
    
    public List<Buku> getAllBuku() throws Exception{
        DBHelper db = new DBHelper();
        String query = "select * from buku";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        List<Buku> list = new ArrayList();
        Buku buku = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            buku = new Buku();
            buku.setKodebuku(rs.getString(1));
            buku.setJudul(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            buku.setTahun(rs.getString(5));
        }
        return list;  
    }
}
