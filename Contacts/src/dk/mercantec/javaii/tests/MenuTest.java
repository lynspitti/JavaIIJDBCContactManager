package dk.mercantec.javaii.tests;

import dk.mercantec.javaii.Menu;
import dk.mercantec.javaii.MenuCallback;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void testAdd() {
        MenuCallback callback = new MenuCallback() {
            @Override
            public void Invoke() {

            }
        };
        boolean added = menu.Add("text", callback);
        assertTrue(added);
    }
}