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
        PdfPCell cellFirst = new PdfPCell();        
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);
        cellFirst.setBackgroundColor(Color.GRAY);
        cellFirst.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        cellFirst.setRotation(90);        

        cellFirst.setPhrase(new Phrase("N° de orden", font));
        cellFirst.setRowspan(2);
        table.addCell(cellFirst);        
        cell.setPhrase(new Phrase("Apellido y nombre", font));
        cell.setRowspan(2);
        table.addCell(cell);
        cell.setPhrase(new Phrase("1° Trimestre", font));
        // cell.setRowspan(2);
        cell.setColspan(5);
        table.addCell(cell);        
        cell.setPhrase(new Phrase("2° Cuatrimestre", font));
        // cell.setRowspan(2);
        cell.setColspan(5);
        table.addCell(cell);
        cell.setPhrase(new Phrase("3° Cuatrimestre", font));
        // cell.setRowspan(2);
        cell.setColspan(5);
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table){
        for (Student student : listStud){
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getSurname()+", " + student.getName());
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            // table.addCell(String.valueOf(student.getDni()));
            // table.addCell(student.getStatus());
            // table.addCell(student.getObservacion());
            // table.addCell(student.getCoursePeriod().toString());;
        }
        
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
        Paragraph title = new Paragraph("Lista de seguimiento, año: __________");
        Paragraph nameSchool = new Paragraph("School Management");
        Paragraph teacherAndSubjet = new Paragraph("Profesor: _________________________           Asignatura: _________________");

        nameSchool.setAlignment(Paragraph.ALIGN_CENTER);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        document.add(nameSchool);
        document.add(teacherAndSubjet);

        PdfPTable table = new PdfPTable(17);
        
        float[] medidaCeldas = {2f,6.70f,2f,2f,2f,2f,2f,2f,2f,2f,2f,2f,2f,2f,2f,2f,2f}; 

        table.setWidths(medidaCeldas);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        writeTableHeader(table);
        writeTableData(table);
        
        document.add(table);
        document.close();
    }   
}
