import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.csvreader.CsvWriter;

public class WriteResult {

    public WriteResult(ReaderComp listComp) {
        //Transaction t = new Transaction();
        String outputFile = "Result.csv";

        // before we open the file check to see if it already exists
        boolean alreadyExists = new File(outputFile).exists();

        try {
            // use FileWriter constructor that specifies open for appending
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

            // if the file didn't already exist then we need to write out the header line
            if (!alreadyExists) {
                csvOutput.write("Name Company");
                csvOutput.write("Count");
                csvOutput.write("Balance");
                csvOutput.endRecord();
            }
            // else assume that the file already has the correct header line

            // write out a few records
            for (Map.Entry i : listComp.getComp().entrySet()) {
                csvOutput.write(((Company) i.getValue()).getNameComp());
                csvOutput.write(String.valueOf(((Company) i.getValue()).getCountId()));
                csvOutput.write(String.valueOf(((Company) i.getValue()).getMoneyAll()));
                csvOutput.endRecord();
            }
            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}