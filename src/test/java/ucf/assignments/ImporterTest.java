package ucf.assignments;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

class ImporterTest {

    @Test
    void importFromJSON() {
        Importer importer = new Importer("TestIO");
        Exporter exporter = new Exporter("TestIO");

        TDList list = new TDList("Groceries");
        Item ham = new Item("Ham", true, Calendar.getInstance());
        list.addItem(ham);

        try {
            exporter.exportToJSON(list);
            TDList list2 = importer.importListFromJSON(list.getTitle());
            assert(list2 != null);
            Item test = list2.list.get(0);
            assert(test.getDescription().equals(ham.getDescription()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
            assert(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong while exporting list!");
            assert(false);
        }
        // TDGroup = importFromJSON (predetermined)
        // check if each list is correct, and if each item within all lists is also correct
    }

    @Test
    void importListFromJSON() {
        // same as above but with single list instead of tdgroup
    }
}