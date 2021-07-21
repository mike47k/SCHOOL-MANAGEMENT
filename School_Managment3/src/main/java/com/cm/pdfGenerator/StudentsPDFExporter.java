package com.cm.pdfGenerator;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.cm.model.Student;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class StudentsPDFExporter {
    private List<Student> listStud;


    public StudentsPDFExporter(List<Student> listStud) {
        this.listStud = listStud;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Alumno ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Nombre", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Apellido", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("DNI", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Estado", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table){
        for (Student student : listStud){
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getName());
            table.addCell(student.getSurname());
            table.addCell(String.valueOf(student.getDni()));
            table.addCell(student.getStatus());
            // table.addCell(student.getObservacion());
            // table.addCell(student.getCoursePeriod().toString());;
        }
        
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        document.add(new Paragraph("Lista de alumnos"));

        PdfPTable table = new PdfPTable(5);

        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        writeTableHeader(table);
        writeTableData(table);
        
        document.add(table);
        document.close();
    }   
}
