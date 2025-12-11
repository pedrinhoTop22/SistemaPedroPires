/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author u1845853
 */
public class Util {
    
    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
        }
    }
    
    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
                //instanceof
            }
        }
    }
    
   public static void gerarPDF(JTable tabela, String titulo) {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Salvar PDF");
            chooser.setSelectedFile(new java.io.File(titulo + ".pdf"));

            if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            String caminho = chooser.getSelectedFile().getAbsolutePath();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(caminho));

            document.open();
            document.add(new Paragraph(titulo.toUpperCase()));
            document.add(new Paragraph(" "));

            int colunas = tabela.getColumnCount();
            PdfPTable pdfTable = new PdfPTable(colunas);

            // Cabeçalho
            for (int i = 0; i < colunas; i++) {
                pdfTable.addCell(tabela.getColumnName(i));
            }

            // Dados
            int linhas = tabela.getRowCount();
            for (int r = 0; r < linhas; r++) {
                for (int c = 0; c < colunas; c++) {
                    Object valor = tabela.getValueAt(r, c);
                    pdfTable.addCell(valor != null ? valor.toString() : "");
                }
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(null, 
                    "PDF gerado com sucesso:\n" + caminho);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao gerar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);        
    }
    
    public static boolean perguntar(String cad) {
        JOptionPane.showConfirmDialog(null, cad);
        return true;
    }
    
    public static int strToInt(String num) {
        return Integer.valueOf(num);
    }

    public static String intToStr(int num) {
        return String.valueOf(num);
    }    
    
    public static double strToDouble(String num) {
        return Double.parseDouble(num);
    }

    public static String doubleToStr(double num) {
        return String.valueOf(num);
    }
    
    public static Date strToDate(String data) {
          SimpleDateFormat fm = new SimpleDateFormat("dd/MM/YYYY");
        try {
            return fm.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String dateToStr(Date data) {
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/YYYY");
        return fm.format(data);
    }
    
}