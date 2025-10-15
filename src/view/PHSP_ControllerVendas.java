/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Phspvendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Pedro
 */
public class PHSP_ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public Phspvendas getBean(int rowIndex) {
        return (Phspvendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phspvendas phspvendas = (Phspvendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return phspvendas.getPhspIdVendas();
        } else if (columnIndex ==1) {
            return phspvendas.getPhspclientes();        
        } else if (columnIndex ==2) {
            return phspvendas.getPhspusuarios();
        } else if (columnIndex ==3) {
            return phspvendas.getPhspDataVenda();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Cliente";         
        } else if ( columnIndex == 2) {
            return "Usuario";
        } else if ( columnIndex == 3) {
            return "Data da Venda";
        } 
        return "";
    }
}
