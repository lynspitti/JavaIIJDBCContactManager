package dk.mercantec.javaii;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by DBJ on 19-02-2015.
 */
public class DBHelper {
    Connection connection = null;

    DBHelper(){
        connection = GetConnection();
    }

    enum Tables{
        internal,external;
    }
    public Connection GetConnection(){
        try {
            return DriverManager.getConnection("jdbc:sqlite:contact.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void CheckDataBase(){
        try
        {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists internal");
            statement.executeUpdate("create table internal (id integer, name string, phone string, email string, department string)");
            statement.executeUpdate("drop table if exists external");
            statement.executeUpdate("create table external (id integer, name string, phone string, email string, company string)");
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    public ArrayList<BaseContact> GetContacts(){
        ArrayList<BaseContact> contacts = new ArrayList<BaseContact>();
        String InsertStmtStart = "INSERT * FROM internal JOIN exterlan";
        try {
            Statement statement = connection.createStatement();
            String Query = InsertStmtStart;
            ResultSet rs = statement.executeQuery(Query);
            while (rs.next()){
                BaseContact contact;
                //check if row contains department
                //contact = new Internal(,,,);
                //else
                //contact = new External(,,,);
                //contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void InsertContact(Tables table, String name, String phone, String email, String depOrcom){
        String InsertStmtStart = "INSERT INTO "; //internal or external
        //InsertStmtStart = "ALTER ";
        String InsertStmt = "name, phone, email, "; //department or company
        //InsertStmt = "("+InsertStmt;
        String values= "\'" + name + "\' " + "\'" + phone + "\' " +"\'" + email + "\' " +"\'" + depOrcom + "\'";
        //values = "VALUES ("+values + ")";
        switch (table){
            case internal:
                InsertStmtStart += "internal ";
                InsertStmt += "department";
                //InsertStmt += ")";
                break;
            case external:
                InsertStmtStart += "external ";
                InsertStmt += "company";
                //InsertStmt += ")";
                break;
        }
        try {
            Statement statement = connection.createStatement();
            String Query = InsertStmtStart + InsertStmt + values;
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
