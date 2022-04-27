/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alison
 */
public class GerarRelátorios {

    public GerarRelátorios() {
    }
    
    public void gerarRelatorioTeste(String nome, String cpf, String nomeArquivo){
     
        Document doc = new Document();
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(nomeArquivo));
            doc.open();
            
            doc.add(new Paragraph(nome));
            doc.add(new Paragraph(cpf));
        
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(GerarRelátorios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            doc.close();
        }
        
        try {
            Desktop.getDesktop().open(new File("t.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GerarRelátorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
