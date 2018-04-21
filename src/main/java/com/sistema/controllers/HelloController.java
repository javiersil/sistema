package com.sistema.controllers;



import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;


@RestController
public class HelloController {
   public static String SRC = "./src/main/resources/pdfs/form.pdf";
    public static String DEST = "./src/main/resources/pdfs/add_extra_table.pdf";
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/pdfCreator")
    public String pdf( HttpServletResponse response){
        try{
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
        Document doc = new Document(pdfDoc);
 
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
        Map<String, PdfFormField> fields = form.getFormFields();
        fields.get("Name").setValue("Jeniffer");
        fields.get("Company").setValue("iText's next customer");
        fields.get("Country").setValue("No Man's Land");
        form.flattenFields(); 
 
        doc.close();
        
        File fileToDownload = new File(DEST);
        InputStream inputStream = new FileInputStream(fileToDownload);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Crede.pdf"); 
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
        inputStream.close();
        
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    return "PDF";
    }
}
