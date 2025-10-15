/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Phspfuncionarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Pedro
 */
public class PHSP_ControllerFuncionarios extends AbstractTableModel {

    private List lstFuncionarios;

    public void setList(List lstFuncionarios) {
        this.lstFuncionarios = lstFuncionarios;
    }
    
    public Phspfuncionarios getBean(int rowIndex) {
        return (Phspfuncionarios) lstFuncionarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstFuncionarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phspfuncionarios phspfuncionarios = (Phspfuncionarios) lstFuncionarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return phspfuncionarios.getPhspIdFuncionario();
        } else if (columnIndex ==1) {
            return phspfuncionarios.getPhspNome();        
        } else if (columnIndex ==2) {
            return phspfuncionarios.getPhspTelefone();
        } else if (columnIndex ==3) {
            return phspfuncionarios.getPhspCpf();
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
            return "Telefone";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
