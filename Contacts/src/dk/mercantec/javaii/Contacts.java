package dk.mercantec.javaii;

import java.util.ArrayList;

/**
 * Created by code on 17/02/15.
 */
public class Contacts {
    private ArrayList<BaseContact> contacts = new ArrayList<BaseContact>();

    //database
    public ArrayList<BaseContact> getContacts() {
        DBHelper sqlDatabase = new DBHelper();
        return sqlDatabase.GetContacts();
    }
    /*public ArrayList<BaseContact> getContacts() {
        return contacts;
    }*/

    //database
    public void AddInternalContact(String name, String phone, String email, String department) {
        DBHelper sqlDatabase = new DBHelper();
        sqlDatabase.InsertContact(DBHelper.Tables.internal,name,phone,email,department);
        //contacts.add(new Internal(name, phone, email, department));
    }
    /*public void AddInternalContact(String name, String phone, String email, String department) {
        contacts.add(new Internal(name, phone, email, department));
    }*/

    public void AddExternalContact(String name, String phone, String email, String company) {
        DBHelper sqlDatabase = new DBHelper();
        sqlDatabase.InsertContact(DBHelper.Tables.external,name,phone,email,company);
        //contacts.add(new External(name, phone, email, company));
    }
    /*public void AddExternalContact(String name, String phone, String email, String company) {
        contacts.add(new External(name, phone, email, company));
    }*/
}
