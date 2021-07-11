package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TDManagerTest {

    @Test
    void getList() {
        TDManager manager = new TDManager();
        assert(manager.list.equals(manager.getList()));
    }
}