/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calista02.model;

import Calista02.model.Buku;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author salti
 */
public class BukuDao {
     private List<Buku> data = new ArrayList<Buku>();
    
    public BukuDao() {
        data.add(new Buku("2003", "matahari", "tereliye", "nana","1978"));
        data.add(new Buku("1004", "hujan", "tereliye", "nana","1980"));
    }
    
    public void insert(Buku b){
        data.add(b);
    }
    
    public void update(int index,Buku b){
        data.set(index,b);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Buku getBuku(int index){
        return data.get(index);
    }
    
     public List<Buku> getAllBuku() 
    {
        return data;
    }
}