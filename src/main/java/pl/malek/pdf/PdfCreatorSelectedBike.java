package pl.malek.pdf;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import pl.malek.dto.BikeDto;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public class PdfCreatorSelectedBike {

    private final BikeDto selectedBike;

    public PdfCreatorSelectedBike(BikeDto selectedBike) {
        this.selectedBike = selectedBike;
    }


    private void writeTableFrameHeader(PdfPTable frameTable) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(8);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nazwa", font));
        frameTable.addCell(cell);

        cell.setPhrase(new Phrase("Material", font));
        frameTable.addCell(cell);

        cell.setPhrase(new Phrase("Rozmiar", font));
        frameTable.addCell(cell);

        cell.setPhrase(new Phrase("Waga [kg]", font));
        frameTable.addCell(cell);

        cell.setPhrase(new Phrase("Cena [zl]", font));
        frameTable.addCell(cell);
    }

    private void writeTableFrameData(PdfPTable frameTable, BikeDto selectedBike) {
        frameTable.addCell(selectedBike.getFrame().getName());
        frameTable.addCell(selectedBike.getFrame().getMaterial());
        frameTable.addCell(selectedBike.getFrame().getSize());
        frameTable.addCell(String.valueOf(selectedBike.getFrame().getWeight()));
        frameTable.addCell(String.valueOf(selectedBike.getFrame().getPrice()));
    }


    private void writeTableWheelsHeader(PdfPTable wheelsTable) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(4);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(8);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nazwa", font));
        wheelsTable.addCell(cell);

        cell.setPhrase(new Phrase("Rozmiar", font));
        wheelsTable.addCell(cell);

        cell.setPhrase(new Phrase("Waga [kg]", font));
        wheelsTable.addCell(cell);

        cell.setPhrase(new Phrase("Cena [zl]", font));
        wheelsTable.addCell(cell);
    }

    private void writeTableWheelsData(PdfPTable wheelsTable, BikeDto selectedBike) {
        wheelsTable.addCell(selectedBike.getWheel().getName());
        wheelsTable.addCell(selectedBike.getWheel().getSize());
        wheelsTable.addCell(String.valueOf(selectedBike.getWheel().getWeight()));
        wheelsTable.addCell(String.valueOf(selectedBike.getWheel().getPrice()));
    }


    private void writeTableBrakesHeader(PdfPTable brakesTable) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(8);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nazwa", font));
        brakesTable.addCell(cell);

        cell.setPhrase(new Phrase("Typ", font));
        brakesTable.addCell(cell);

        cell.setPhrase(new Phrase("Producent", font));
        brakesTable.addCell(cell);

        cell.setPhrase(new Phrase("Waga [kg]", font));
        brakesTable.addCell(cell);

        cell.setPhrase(new Phrase("Cena [zl]", font));
        brakesTable.addCell(cell);
    }

    private void writeTableBrakesData(PdfPTable brakesTable, BikeDto selectedBike) {
        brakesTable.addCell(selectedBike.getBrake().getName());
        brakesTable.addCell(selectedBike.getBrake().getType());
        brakesTable.addCell(selectedBike.getBrake().getProducer());
        brakesTable.addCell(String.valueOf(selectedBike.getBrake().getWeight()));
        brakesTable.addCell(String.valueOf(selectedBike.getBrake().getPrice()));
    }


    private void writeTableSummaryHeader(PdfPTable summaryTable) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(2);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(8);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Waga [kg]", font));
        summaryTable.addCell(cell);

        cell.setPhrase(new Phrase("Cena [zl]", font));
        summaryTable.addCell(cell);
    }


    private void writeTableSummaryData(PdfPTable summaryTable, BikeDto selectedBike) {
        summaryTable.addCell(String.valueOf(selectedBike.getWeight()));
        summaryTable.addCell(String.valueOf(selectedBike.getPrice()));
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Wybrany rower: " + selectedBike.getName(), font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);


        Paragraph p1 = new Paragraph("Rama", font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p1);

        PdfPTable frameTable = new PdfPTable(5);
        frameTable.setWidthPercentage(100f);
        frameTable.setWidths(new float[]{1.5f, 3.0f, 3.0f, 1.5f, 1.5f});
        frameTable.setSpacingBefore(10);

        PdfPTable wheelsTable = new PdfPTable(4);
        wheelsTable.setWidthPercentage(100f);
        wheelsTable.setWidths(new float[]{1.5f, 3.0f, 1.5f, 1.5f});
        wheelsTable.setSpacingBefore(10);

        PdfPTable brakesTable = new PdfPTable(5);
        brakesTable.setWidthPercentage(100f);
        brakesTable.setWidths(new float[]{1.5f, 3.0f, 3.0f, 1.5f, 1.5f});
        brakesTable.setSpacingBefore(10);

        PdfPTable summaryTable = new PdfPTable(2);
        summaryTable.setWidthPercentage(100f);
        summaryTable.setWidths(new float[]{6.0f, 6.0f});
        summaryTable.setSpacingBefore(10);


        writeTableFrameHeader(frameTable);
        writeTableFrameData(frameTable, selectedBike);

        writeTableWheelsHeader(wheelsTable);
        writeTableWheelsData(wheelsTable, selectedBike);

        writeTableBrakesHeader(brakesTable);
        writeTableBrakesData(brakesTable, selectedBike);

        writeTableSummaryHeader(summaryTable);
        writeTableSummaryData(summaryTable, selectedBike);



        document.add(frameTable);

        Paragraph p2 = new Paragraph("Kola", font);
        p2.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p2);

        document.add(wheelsTable);

        Paragraph p3 = new Paragraph("Hamulce", font);
        p3.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p3);

        document.add(brakesTable);

        Paragraph p4 = new Paragraph("Podsumowanie", font);
        p4.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p4);

        document.add(summaryTable);

        document.close();
    }


}
