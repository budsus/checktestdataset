package id.budsus.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CSVTools {
    public static ArrayList<CodeDoc> getListCSV(String fileCSV) throws CsvException, IOException {
        ArrayList<CodeDoc> codeDocList = new ArrayList<>();

        FileReader filereader = new FileReader(fileCSV);
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withCSVParser(parser)
                .build();
        // Read all data at once
        List<String[]> allData = csvReader.readAll();

        // read all row, and select only for Java method. Saved it to arraylist CodeDoc
        int lineNo = 0;
        for (String[] data : allData) {
            lineNo++;
            if (data[0].equals("Java")) {
                CodeDoc code = new CodeDoc();
                code.fromString(lineNo, data);
                codeDocList.add(code);
            }
        }

        return codeDocList;
    }
}