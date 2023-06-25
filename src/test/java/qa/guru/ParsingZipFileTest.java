package qa.guru;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ParsingZipFileTest {

    @Test
    void zipTest() throws Exception {

        try (ZipFile zipFile = new ZipFile("src/test/resources/simple.zip")) {

            ZipEntry entryXls = zipFile.getEntry("sample-simple-2.xls");
            try (InputStream stream = zipFile.getInputStream(entryXls)) {
                XLS xls = new XLS(stream);
                Assertions.assertEquals("test2",
                        xls.excel.getSheetAt(1).
                                getRow(0)
                                .getCell(0)
                                .getStringCellValue());
            }

            ZipEntry entryPdf = zipFile.getEntry("dog_prepod.pdf");
            try (InputStream stream = zipFile.getInputStream(entryPdf)) {
                PDF pdf = new PDF(stream);
                Assertions.assertEquals("Договор на оказание услуг (общая форма)", pdf.title);
            }

            ZipEntry entryCsv = zipFile.getEntry("simple-csv.csv");
            try (InputStream stream = zipFile.getInputStream(entryCsv)) {
                Reader reader = new InputStreamReader(stream);
                CSVReader csvReader = new CSVReader(reader);
                List<String[]> content = csvReader.readAll();

                Assertions.assertEquals(5, content.size());

                final String[] firstRow = content.get(0);
                final String[] secondRow = content.get(1);
                final String[] thirdRow = content.get(2);
                final String[] fourthRow = content.get(3);
                final String[] fifthRow = content.get(4);

                Assertions.assertArrayEquals(new String[]{"Year", "Industry"}, firstRow);
                Assertions.assertArrayEquals(new String[]{"2001", "Aviation"}, secondRow);
                Assertions.assertArrayEquals(new String[]{"2002", "Aviation"}, thirdRow);
                Assertions.assertArrayEquals(new String[]{"2003", "Construction"}, fourthRow);
                Assertions.assertArrayEquals(new String[]{"2004", "Construction"}, fifthRow);
            }
        }
    }
}



