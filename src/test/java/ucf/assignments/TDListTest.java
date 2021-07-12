package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TDListTest {

    @Test
    void getTitle() {
        TDList list = new TDList();
        list.rename("Important Stuff");
        assert(list.getTitle().equals("Important Stuff"));
    }

    @Test
    void rename() {
        TDList list = new TDList();
        list.rename("Hello!");
        assert(list.getTitle().equals("Hello!"));
    }

    @Test
    void addItem() {
        TDList list = new TDList();
        Item eggs = new Item("Buy some eggs", false, Calendar.getInstance());
        list.addItem(eggs);
        assert(list.list.size() == 1);
        assert(list.list.get(0).equals(eggs));
    }
}