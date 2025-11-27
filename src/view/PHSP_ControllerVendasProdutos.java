/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Phspvendasprodutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Pedro
 */
public class PHSP_ControllerVendasProdutos extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
    }
    
    public Phspvendasprodutos getBean(int rowIndex) {
        return (Phspvendasprodutos) lstVendasProdutos.get(rowIndex);
    }
    
    public void addBean(Phspvendasprodutos phspvendasprodutos) {
        lstVendasProdutos.add(phspvendasprodutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phspvendasprodutos phspvendasprodutos = (Phspvendasprodutos) lstVendasProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return phspvendasprodutos.getPhspprodutos().getPhspIdProdutos();
        } else if (columnIndex ==1) {
            return phspvendasprodutos.getPhspprodutos().getPhspNome();
        } else if (columnIndex ==2) {
            return phspvendasprodutos.getPhspQuantidade();
        } else if (columnIndex ==3) {
            return phspvendasprodutos.getPhspValorUnitario();
        }else if (columnIndex ==4) {
            return phspvendasprodutos.getPhspValorUnitario()*phspvendasprodutos.getPhspQuantidade();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}
