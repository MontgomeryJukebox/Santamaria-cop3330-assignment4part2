package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ExporterTest {

    @Test
    void testExportToJSON() {
        TDList list = new TDList();
        list.rename("Groceries");
        Item eggs = new Item("Buy a baker's dozen of eggs", false, new Date(2021, 8, 28));
        list.addItem(eggs);
        Exporter exporter = new Exporter("TestIO");
        Importer importer = new Importer("TestIO");
        try {
            exporter.exportToJSON(list);
            TDList list2 = importer.importListFromJSON(list.getTitle());
            Item i = list2.list.get(0);
            assert(i.getDescription().equals(eggs.getDescription()));
        } catch (Exception e) {
            assert(false);
        }
    }
}