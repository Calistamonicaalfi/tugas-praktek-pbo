/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calista02.controller;

import Calista02.dao.BukuDb;
import Calista02.view.FormBukuDb;
import Calista02.model.Buku;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author salti
 */
public class BukuControllerDb {
    FormBukuDb formBukuDb;
    Buku buku;
    BukuDb bukuDb;
    
    public BukuControllerDb(FormBukuDb formBukuDb){
        this.formBukuDb = formBukuDb;
        bukuDb = new BukuDb();
    }

    public void cancel(){
        formBukuDb.getTxtKode().setText("");
        formBukuDb.getTxtJudul().setText("");
        formBukuDb.getTxtPengarang().setText("");
        formBukuDb.getTxtPenerbit().setText("");
        formBukuDb.getTxtTahun().setText("");
    } 
    
    public void insert(){
        try {
            buku = new Buku();
            buku.setKodebuku(formBukuDb.getTxtKode().getText());
            buku.setJudul(formBukuDb.getTxtJudul().getText());
            buku.setPengarang(formBukuDb.getTxtPengarang().getText());
            buku.setPenerbit(formBukuDb.getTxtPenerbit().getText());
            buku.setTahun(formBukuDb.getTxtTahun().getText());
            bukuDb.insert(buku);
            JOptionPane.showMessageDialog(formBukuDb, "Entri Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formBukuDb, "Error  "+ex.getMessage());
        }
    }
    
    public void viewData(){
        try {
            DefaultTableModel model = (DefaultTableModel)formBukuDb.getTabelBukuDb().getModel();
            model.setNumRows(0);
            List<Buku> list = bukuDb.getAllBuku();
            for(Buku buku : list){
                Object[] data = {
                    buku.getKodebuku(),
                    buku.getJudul(),
                    buku.getPengarang(),
                    buku.getPenerbit(),
                    buku.getTahun()
                };
                model.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(MahasiswaControllerDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void actionClickTabel(){
        try {
            String kode = formBukuDb.getTabelBukuDb()
                    .getValueAt(formBukuDb.getTabelBukuDb().getSelectedRow(), 0).toString();
            buku = bukuDb.getBuku(kode);
            formBukuDb.getTxtKode().setText(buku.getKodebuku());
            formBukuDb.getTxtJudul().setText(buku.getJudul());
            formBukuDb.getTxtPengarang().setText(buku.getPengarang());
            formBukuDb.getTxtPenerbit().setText(buku.getPenerbit());
            formBukuDb.getTxtTahun().setText(buku.getTahun());
        } catch (Exception ex) {
            Logger.getLogger(BukuControllerDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void update(){
        
        try {
            buku.setKodebuku(formBukuDb.getTxtKode().getText());
            buku.setJudul(formBukuDb.getTxtJudul().getText());
            buku.setPengarang(formBukuDb.getTxtPengarang().getText());
            buku.setPenerbit(formBukuDb.getTxtPenerbit().getText());
            buku.setTahun(formBukuDb.getTxtTahun().getText());
            bukuDb.update(buku);
            JOptionPane.showMessageDialog(formBukuDb, "Update Data Ok");
        } catch (Exception ex) {
            Logger.getLogger(BukuControllerDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            String kode = formBukuDb.getTabelBukuDb()
                    .getValueAt(formBukuDb.getTabelBukuDb().getSelectedRow(), 0).toString();
            bukuDb.delete(kode);
            JOptionPane.showMessageDialog(formBukuDb, "Delete Data Ok");
        } catch (Exception ex) {
            Logger.getLogger(BukuControllerDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
