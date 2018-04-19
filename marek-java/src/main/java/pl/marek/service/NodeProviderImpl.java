package pl.marek.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import pl.marek.model.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service("nodeProvider")
public class NodeProviderImpl implements NodeProvider {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private static List<Node> nodes;

    static {
        nodes = populateFromFile("test1.xlsx");
    }

    private static List<Node> populateFromFile(String fileName) {
        List<Node> result = new ArrayList<>();

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(new ClassPathResource(fileName).getFile());
        } catch (IOException | InvalidFormatException e) {
            throw new IllegalArgumentException("File cannot be opened", e);
        }

        final XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIt = sheet.rowIterator();

        Node level1 = null;
        Node level2 = null;
        rowIt.next(); // skip headers
        while (rowIt.hasNext()) {
            final Row row = rowIt.next();
            final String cell0 = row.getCell(0).getStringCellValue();
            final String cell1 = row.getCell(1).getStringCellValue();
            final String cell2 = row.getCell(2).getStringCellValue();
            final double id = row.getCell(3).getNumericCellValue();
            if (!cell0.isEmpty()) {
                level1 = new Node((int)id, cell0);
                result.add(level1);
            } else if (!cell1.isEmpty()) {
                level2 = new Node((int)id, cell1);
                if (level1.getNodes() == null) {
                    level1.setNodes(new ArrayList<>());
                }
                level1.getNodes().add(level2);
            } else if (!cell2.isEmpty()) {
                final Node level3 = new Node((int)id, cell2);
                if (level2.getNodes() == null) {
                    level2.setNodes(new ArrayList<>());
                }
                level2.getNodes().add(level3);
            }
        }
        return result;
    }

    public List<Node> retrieveNodes() {
        return nodes;
    }
}
