package com.pdf.generate.util;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pdf.generate.dto.SampleDto;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TableExample {
    public static void main(String[] args) {
        Document document = new Document();
        List<SampleDto> list= new ArrayList<SampleDto>();
        for(int i=1;i<=4;i++)
        {
        SampleDto sampleDto= new SampleDto();
        sampleDto.setAccountNo("acc"+i);
        sampleDto.setCustomerName("cust"+i);
        list.add(sampleDto);
        }
        

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("HelloWorld-Table.pdf"));

            document.open();
            Font font1 = new Font(FontFamily.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.BLACK);
            Image image=Image.getInstance("doc.png");
            Paragraph p1= new Paragraph();
         //   p1.setFont(font1);
            Chunk chunk= new Chunk(image, 0, 0);
            p1.add(chunk);
            p1.add("                     abc");
       //     p1.setIndentationLeft(50f);
   //         p1.setLeading(20f);
            document.add(p1);
            com.itextpdf.text.List list1 = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
            BaseFont bf = BaseFont.createFont("FreeSans.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font f = new Font(bf, 12);
            list1.setListSymbol(new Chunk("\u25cb", f));
            list1.add("This is a test");
            list1.setIndentationLeft(20f);
            document.add(list1);
            PdfPTable table = new PdfPTable(6); // 6 columns.
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);

            table.setSpacingAfter(10f);
            float[] columnWidths = {1f, 5f, 5f, 1f, 5f, 5f};

            table.setWidths(columnWidths);
            Font font = new Font(FontFamily.TIMES_ROMAN, 12, Font.ITALIC, BaseColor.BLUE);
            PdfPCell cell1 = new PdfPCell();
            PdfPCell cell2 = new PdfPCell();
            cell2.addElement(new Paragraph("Account Number",font));
            PdfPCell cell3 = new PdfPCell();
            cell3.addElement(new Paragraph("Customer Name",font));
            PdfPCell cell4 = new PdfPCell();
            PdfPCell cell5 = new PdfPCell();
            cell5.addElement(new Paragraph("Account Number",font));
            PdfPCell cell6 = new PdfPCell();
            cell6.addElement(new Paragraph("Customer Name",font));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
           for(int i=1;i<=list.size();i++)
           {
        	   SampleDto sampleDto=list.get(i-1);
        	   PdfPCell cell7 = new PdfPCell();
        	   cell7.addElement(new Paragraph(""+i));
               PdfPCell cell8 = new PdfPCell();
               cell8.addElement(new Paragraph(sampleDto.getAccountNo()));
               PdfPCell cell9 = new PdfPCell();
               cell9.addElement(new Paragraph(sampleDto.getCustomerName()));
               /*PdfPCell cell4 = new PdfPCell();
               PdfPCell cell5 = new PdfPCell();
               cell5.addElement(new Paragraph("Account Number"));
               PdfPCell cell6 = new PdfPCell();
               cell6.addElement(new Paragraph("Customer Name"));*/

               table.addCell(cell7);
               table.addCell(cell8);
               table.addCell(cell9);
               /*table.addCell(cell4);
               table.addCell(cell5);
               table.addCell(cell6);*/
           }
           document.add(table);
            table = new PdfPTable(6); // 6 columns.
            table.setSpacingBefore(10f);

            table.setSpacingAfter(10f);
           table.setWidthPercentage(100);

           table.setWidths(columnWidths);
            font = new Font(FontFamily.TIMES_ROMAN, 12, Font.ITALIC, BaseColor.BLUE);
            cell1 = new PdfPCell();
            cell2 = new PdfPCell();
           cell2.addElement(new Paragraph("Account Number",font));
            cell3 = new PdfPCell();
           cell3.addElement(new Paragraph("Customer Name",font));
            cell4 = new PdfPCell();
            cell5 = new PdfPCell();
           cell5.addElement(new Paragraph("Account Number",font));
            cell6 = new PdfPCell();
           cell6.addElement(new Paragraph("Customer Name",font));

           table.addCell(cell1);
           table.addCell(cell2);
           table.addCell(cell3);
           table.addCell(cell4);
           table.addCell(cell5);
           table.addCell(cell6);
          for(int i=1;i<=list.size();i++)
          {
       	   SampleDto sampleDto=list.get(i-1);
       	   PdfPCell cell7 = new PdfPCell();
       	   cell7.addElement(new Paragraph(""+i));
              PdfPCell cell8 = new PdfPCell();
              cell8.addElement(new Paragraph(sampleDto.getAccountNo()));
              PdfPCell cell9 = new PdfPCell();
              cell9.addElement(new Paragraph(sampleDto.getCustomerName()));
              /*PdfPCell cell4 = new PdfPCell();
              PdfPCell cell5 = new PdfPCell();
              cell5.addElement(new Paragraph("Account Number"));
              PdfPCell cell6 = new PdfPCell();
              cell6.addElement(new Paragraph("Customer Name"));*/

              table.addCell(cell7);
              table.addCell(cell8);
              table.addCell(cell9);
              /*table.addCell(cell4);
              table.addCell(cell5);
              table.addCell(cell6);*/
          }

            document.add(table);

            document.close();
        } catch(Exception e){

        }
    }
}