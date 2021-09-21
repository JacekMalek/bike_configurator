package pl.malek.pdf;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import pl.malek.dto.BikeDto;
import pl.malek.service.BikeService;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@Component
public class PdfCreator {
    private final List<BikeDto> bikeList;
    private final BikeService bikeService;

    public PdfCreator(List<BikeDto> bikeList, BikeService bikeService) {
        this.bikeList = bikeList;
        this.bikeService = bikeService;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(7);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(8);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nazwa roweru", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nazwa Ramy", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Material Ramy", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Rozmiar kola", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Hamulce", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Waga [kg]", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Cena [zł]", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (BikeDto bike : bikeList) {
            table.addCell(bike.getName());
            table.addCell(bike.getFrame().getName());
            table.addCell(bike.getFrame().getMaterial());
            table.addCell(bike.getWheel().getSize());
            table.addCell(bike.getBrake().getProducer());
            table.addCell(String.valueOf(bike.getWeight()));
            table.addCell(String.valueOf(bike.getPrice()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Lista rowerów", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{3.5f, 3.0f, 2.0f, 1.5f, 2.0f, 1.5f, 2f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        Paragraph p1 = new Paragraph("Liczba rowerów w bazie: " + bikeService.bikeCount(), font);
        p1.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(p1);

        document.close();
    }
}
