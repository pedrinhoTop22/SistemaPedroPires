/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




/**
 *
 * @author u1845853
 */
public class Util {
    public static void habilitar(boolean valor, JComponent ... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
            
        }
    }
    
    public static void limpar(JComponent ... componentes){
        for (int i = 0; i < componentes.length; i++) {
            if(componentes [i] instanceof JTextField){
            ((JTextField)componentes[i]).setText("");
            }
            if(componentes [i] instanceof JComboBox){
                ((JComboBox)componentes[i]).setSelectedIndex(-1);
            }
            if(componentes [i] instanceof JFormattedTextField){
                ((JFormattedTextField)componentes[i]).setText("");
            }
        }
        
    }
    
  

public static void mensagem(String cad){
    JOptionPane.showMessageDialog(null, cad);
}
      public static boolean pergunta(String cad){
    int resposta = JOptionPane.showConfirmDialog(null, cad, "Confirmação", JOptionPane.YES_NO_OPTION);
    return resposta == JOptionPane.YES_OPTION;
}
public static int strToInt(String num){
    return Integer.parseInt(num); 
}
public static String IntTostr(int num){
    return String.valueOf(num);
}
public static double strToDouble(double num){
    return 0.0;
}
public static String DoubleTostr(String num){
    return " ";
}
public static Date strToData(Date num){
    return null;
}
public static String DataTostr(String num){
    return " ";
}
}