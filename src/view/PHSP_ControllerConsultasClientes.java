/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Phspclientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PHSP_ControllerConsultasClientes extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phspclientes phspclientes = (Phspclientes) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return phspclientes.getPhspIdClientes();
        } else if (columnIndex ==1) {
            return phspclientes.getPhspNome();        
        } else if (columnIndex ==2) {
            return phspclientes.getPhspCpf();
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
            return "CPF";
        }
        return "";
    }
}
