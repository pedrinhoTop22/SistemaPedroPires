/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Phspprodutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Pedro
 */
public class PHSP_ControllerProdutos extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
    }
    
    public Phspprodutos getBean(int rowIndex) {
        return (Phspprodutos) lstProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phspprodutos phspprodutos = (Phspprodutos) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return phspprodutos.getPhspIdProdutos();
        } else if (columnIndex ==1) {
            return phspprodutos.getPhspNome();        
        } else if (columnIndex ==2) {
            return phspprodutos.getPhspCategoria();
        } else if (columnIndex ==3) {
            return phspprodutos.getPhspLancamento();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Categoria";
        } else if ( columnIndex == 3) {
            return "Lançamento";
        } 
        return "";
    }
}
