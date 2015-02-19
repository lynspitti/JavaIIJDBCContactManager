package dk.mercantec.javaii.tests;

import dk.mercantec.javaii.BaseContact;
import dk.mercantec.javaii.External;
import dk.mercantec.javaii.iViewable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExternalTest {

    private static final String NAME = "John Doe";
    private static final String PHONE = "31337";
    private static final String EMAIL = "john@doe.com";
    private static final String COMPANY = "FBI";

    External external;

    @Before
    public void setUp() throws Exception {
        this.external = new External(NAME, PHONE, EMAIL, COMPANY);
    }

    @Test
    public void testSuperclass() {
        assertTrue(external instanceof BaseContact);
    }

    @Test
    public void testInterfaces() {
        assertTrue(external instanceof iViewable);
    }

    @Test
    public void testSetCompany() {
        external.setCompany(COMPANY);
        assertEquals(COMPANY, external.getCompany());
    }

    @Test
    public void testToString() {
        String expectedString = "Name: " + this.external.getName() +
                "\nPhone: " + this.external.getPhone() +
                "\nEmail: " + this.external.getEmail() +
                "\nCompany: " + this.external.getCompany();
        assertEquals(expectedString, this.external.toString());
    }
}