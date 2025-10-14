/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Phspclientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Pedro
 */
public class PHSP_ControllerClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    public Phspclientes getBean(int rowIndex) {
        return (Phspclientes) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phspclientes phspclientes = (Phspclientes) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return phspclientes.getPhspIdClientes();
        } else if (columnIndex ==1) {
            return phspclientes.getPhspNome();        
        } else if (columnIndex ==2) {
            return phspclientes.getPhspDataNascimento();
        } else if (columnIndex ==3) {
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
            return "Data de Nascimento";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
