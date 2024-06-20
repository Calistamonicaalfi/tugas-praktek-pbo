/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calista02.controller;

import Calista02.model.Buku;
import Calista02.view.FormBuku;
import Calista02.model.BukuDao;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Calista
 */
public class BukuController {
    FormBuku formBuku;
    Buku buku;
    BukuDao bukuDao;
    int index;
    
    public BukuController(FormBuku formBuku)
    {
        this.formBuku = formBuku;
        bukuDao = new BukuDao();
    }
    
    public void cancel()
    {
        formBuku.getTxtKode().setText("");
        formBuku.getTxtJudul().setText("");
        formBuku.getTxtPengarang().setText("");
        formBuku.getTxtPenerbit().setText("");
        formBuku.getTxtTahun().setText("");
    }
    
    
    public void insert()
    {
        buku = new Buku();
        buku.setKodebuku(formBuku.getTxtKode().getText());
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setTahun(formBuku.getTxtTahun().getText());
        bukuDao.insert(buku);
        JOptionPane.showMessageDialog(formBuku, "Entry Data Ok");
    }
    
    public void getBuku(){
        int index = formBuku.getTabelBuku().getSelectedRow();
        buku = bukuDao.getBuku(index);
        if(buku != null){
            formBuku.getTxtKode().setText(buku.getKodebuku());
            formBuku.getTxtJudul().setText(buku.getJudul());
            formBuku.getTxtPengarang().setText(buku.getPengarang());
            formBuku.getTxtPenerbit().setText(buku.getPenerbit());
            formBuku.getTxtTahun().setText(buku.getTahun());
            
        }
    }
    
    public void viewData()
    {
        DefaultTableModel model = (DefaultTableModel)formBuku.getTabelBuku().getModel();
        model.setNumRows(0);
        List<Buku> list = bukuDao.getAllBuku();
        for(Buku buku :list)
        {
            Object[] data = 
            {
                buku.getKodebuku(),
                buku.getJudul(),
                buku.getPengarang(),
                buku.getPenerbit(),
                buku.getTahun()
            };
            model.addRow(data);
        }
    }
    
    public void update()
    {
        buku.setKodebuku(formBuku.getTxtJudul().getText());
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setTahun(formBuku.getTxtTahun().getText());
        JOptionPane.showMessageDialog(formBuku, "Update Data OK");
    }
    
    public void delete()
        {
            bukuDao.delete(index);
            JOptionPane.showMessageDialog(formBuku, "Delete Data Ok");
        }
}
