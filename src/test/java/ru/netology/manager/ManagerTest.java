package ru.netology.manager;

import ru.netology.domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ManagerTest {
    private Manager manager = new Manager();
    private Ticket tik1 = new Ticket(1, 5000, "OGZ", "DME", 286);
    private Ticket tik2 = new Ticket(2, 12000, "LED", "FRU", 199);
    private Ticket tik3 = new Ticket(3, 2000, "EGO", "RVH", 250);
    private Ticket tik4 = new Ticket(4, 3500, "BZK", "KUF", 300);

    @BeforeEach
    public void before() {
        manager.save(tik1);
        manager.save(tik2);
        manager.save(tik3);
        manager.save(tik4);
    }

    @Test
    void searchByFrom_() {
        Ticket[] expented = new Ticket[]{tik2};
        Ticket[] actual = manager.searchBy("LED", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOf() {
        Ticket[] expented = new Ticket[]{tik4, tik1};
        Ticket[] actual = manager.searchBy("BZK", "DME");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy_Of() {
        Ticket[] expented = new Ticket[]{tik1};
        Ticket[] actual = manager.searchBy("", "DME");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByOfFrom() {
        Ticket[] expented = new Ticket[]{};
        Ticket[] actual = manager.searchBy("FRU", "BZK");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy__() {
        Ticket[] expented = new Ticket[]{};
        Ticket[] actual = manager.searchBy("", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOfOf() {
        Ticket[] expented = new Ticket[]{tik4, tik2};
        Ticket[] actual = manager.searchBy("LED", "KUF");
        assertArrayEquals(expented, actual);
    }
}
