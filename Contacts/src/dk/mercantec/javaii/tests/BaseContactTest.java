package dk.mercantec.javaii.tests;


import dk.mercantec.javaii.BaseContact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseContactTest {

    private static final String NAME = "John Doe";
    private static final String PHONE = "31337";
    private static final String EMAIL = "john@doe.com";

    BaseContact baseContact;

    @Before
    public void setUp() {
        this.baseContact = new BaseContact(NAME, PHONE, EMAIL);
    }

    @Test
    public void testBaseContact() {
        assertEquals(NAME, this.baseContact.getName());
        assertEquals(PHONE, this.baseContact.getPhone());
        assertEquals(EMAIL, this.baseContact.getEmail());
    }

    @Test
    public void testSetName() {
        baseContact.setName(NAME);
        assertEquals(NAME, baseContact.getName());
    }

    @Test
    public void testSetPhone() {
        baseContact.setPhone(PHONE);
        assertEquals(PHONE, baseContact.getPhone());
    }

    @Test
    public void testSetEmail() {
        baseContact.setEmail(EMAIL);
        assertEquals(EMAIL, baseContact.getEmail());
    }
}