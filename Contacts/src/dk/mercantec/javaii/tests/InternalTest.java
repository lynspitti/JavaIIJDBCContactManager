package dk.mercantec.javaii.tests;


import dk.mercantec.javaii.BaseContact;
import dk.mercantec.javaii.Internal;
import dk.mercantec.javaii.iViewable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InternalTest {

    private static final String NAME = "name";
    private static final String PHONE = "12341234";
    private static final String EMAIL = "email@mail.dk";
    private static final String DEPARTMENT = "company";

    Internal internal;

    @Before
    public void setUp() {
        internal = new Internal(NAME, PHONE, EMAIL, DEPARTMENT);
    }

    @Test
    public void testSuperclass() {
        assertTrue(internal instanceof BaseContact);
    }

    @Test
    public void testInterfaces() {
        assertTrue(internal instanceof iViewable);
    }

    @Test
    public void testSetDepartment() {
        internal.setDepartment(DEPARTMENT);
        assertEquals(DEPARTMENT, internal.getDepartment());
    }

    @Test
    public void testToString() throws Exception {
        String expectedString = "Name: " + internal.getName() +
                "\nPhone: " + internal.getPhone() +
                "\nEmail: " + internal.getEmail() +
                "\nDepartment: " + internal.getDepartment();
        assertEquals(expectedString, internal.toString());
    }
}