package lv.citadele.mailsender.textprocessor;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import lv.citadele.mailsender.exception.PDFGenerationException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class PdfGenerationService {

    public static final String TEMPORARY_FILE_NAME = "temp.pdf";

    public String generatePDFFromHTML(String filename) {
        try {
            Document document = new Document();
            File temp = File.createTempFile(TEMPORARY_FILE_NAME, Long.toString(System.nanoTime()));
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(temp.getPath()));
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                    new FileInputStream(filename));
            document.close();
            return temp.getPath();
        } catch (DocumentException | IOException e) {
            throw new PDFGenerationException("PDF generation failed");
        }
    }

}
