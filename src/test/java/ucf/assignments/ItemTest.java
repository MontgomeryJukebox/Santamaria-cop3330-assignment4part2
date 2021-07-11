package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getDescription() {
        Item bagels = new Item("Buy some bagels", false, Calendar.getInstance());
        bagels.editDescription("Hello, World!");
        assert(bagels.getDescription().equals("Hello, World!"));
    }

    @Test
    void editDescription() {
        Item milk = new Item("Buy some milk", true, Calendar.getInstance());
        milk.editDescription("test123");
        assert(milk.getDescription().equals("test123"));
    }

    @Test
    void editDueDate() {
        Item eggs = new Item("get some eggs", false, Calendar.getInstance());
        eggs.editDueDate(GregorianCalendar.from(null));
        System.out.println(eggs.dueDate);
        assert(eggs.dueDate.toString().equals("Wed Sep 28 00:00:00 EDT 3921"));
    }

    @Test
    void setDone() {
        Item item = new Item("description", true, Calendar.getInstance());
        item.setDone(false);
        assert(item.done == false);
        item.setDone(true);
        assert(item.done == true);
    }
}