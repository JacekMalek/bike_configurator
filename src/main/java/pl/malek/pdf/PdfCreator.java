package pl.malek.pdf;

import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import pl.malek.model.Bike;

import java.awt.*;
import java.util.List;

public class PdfCreator {
    private final List<Bike> bikeList;

    public PdfCreator(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Bike Id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nazwa roweru", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Rama", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Koła", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase ("Hamulce", font));
        table.addCell(cell);
    }



}
