import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import java.io.*;

/**
 * Created by ganeshdhareshwar on 19/03/16.
 */
public class pdf {
    public void pdfReader() {
        PDDocument pdf;
        BufferedWriter writer;
        try {
            File input = new File("/Users/ganeshdhareshwar/Documents/AboutUs.pdf");
            File output = new File("/Users/ganeshdhareshwar/Documents/extractedPdf.txt");
            pdf = PDDocument.load(input);
            System.out.println("Number of pages: " + pdf.getNumberOfPages());
            PDFTextStripper stripper = new PDFTextStripper();
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
            stripper.writeText(pdf, writer);
            pdf.close();
            writer.flush();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void createPdf() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File("/Users/ganeshdhareshwar/Documents/AboutUs.pdf")));
            document.open();
            String text = "In my blog https://excelinjava.wordpress.com/ , it is my responsibility to provide workable and executable code." +
                    "You can just copy the code and paste and run it. I am sure it will work as I described here." +
                    "If you see anything missing or any concept not clear or any doubts, please contact me at my personal email id [ dhareshwarganesh@gmail.com] . " +
                    "It is my pleasure to help you.";
            Paragraph paragraph = new Paragraph(text);
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            paragraph.setFont(new Font(Font.NORMAL, 10, Font.BOLD));
            document.add(paragraph);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        pdf pdf = new pdf();
        pdf.createPdf();
        pdf.pdfReader();
    }
}

