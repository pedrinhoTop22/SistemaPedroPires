/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Phspusuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Pedro
 */
public class PHSP_ControllerUsuarios extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    public Phspusuarios getBean(int rowIndex) {
        return (Phspusuarios) lstUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phspusuarios phspusuarios = (Phspusuarios) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return phspusuarios.getPhspIdUsuarios();
        } else if (columnIndex ==1) {
            return phspusuarios.getPhspNome();        
        } else if (columnIndex ==2) {
            return phspusuarios.getPhspApelido();
        } else if (columnIndex ==3) {
            return phspusuarios.getPhspCpf();
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
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
