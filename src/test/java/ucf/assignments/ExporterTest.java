package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ExporterTest {

    @Test
    void testExportToJSON() {
        TDList list = new TDList();
        list.rename("Groceries");
        Item eggs = new Item("Buy a baker's dozen of eggs", false, Calendar.getInstance());
        list.addItem(eggs);
        Exporter exporter = new Exporter("TestIO");
        Importer importer = new Importer("TestIO");
        try {
            exporter.exportToJSON(list);
            TDList list2 = importer.importListFromJSON(list.getTitle());
            assert(list2 != null);
            Item i = list2.list.get(0);
            assert(i.getDescription().equals(eggs.getDescription()));
        } catch (Exception e) {
            e.printStackTrace();
            assert(false);
        }
    }
}