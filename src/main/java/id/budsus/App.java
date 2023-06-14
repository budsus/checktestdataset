package id.budsus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import id.budsus.csv.CSVTools;
import id.budsus.csv.CodeDoc;
import id.budsus.rethinkdb.RethinkDBTools;
import id.budsus.tools.FileTools;

/**
 * Untuk pengecekan test dataset dengan training dataset
 *
 */
public class App {
    public static void main(String[] args) throws CsvException, IOException {
        ArrayList<CodeDoc> csv = CSVTools.getListCSV(args[0]);
        RethinkDBTools rtools = new RethinkDBTools();
        for (CodeDoc doc : csv) {
            StringBuilder strlog = new StringBuilder();
            strlog.append(doc.getLineNo()).append(";").append(doc.getLanguage())
                    .append(";").append(doc.getQuery())
                    .append(";").append(doc.getGiturl())
                    .append(";").append(doc.getRelevance()).append(";");
            System.out.print(doc.getLineNo() + " " + doc.getLanguage() + " " + doc.getQuery());
            boolean result = rtools.findDocByURL(doc.getGiturl());
            if (result) {
                System.out.println("   ---- Ada");
                strlog.append("Ada");
            } else {
                System.out.println(" ---- Tidak Ada");
                strlog.append("Tidak Ada");
            }
            FileTools.writeStringToFile(args[1], strlog.toString());
        }
        rtools.closeConn();
    }
}
