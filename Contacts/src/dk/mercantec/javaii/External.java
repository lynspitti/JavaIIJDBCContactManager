package dk.mercantec.javaii;

/**
 * Created by code on 17/02/15.
 */
public class External extends BaseContact implements iViewable {
    public External(String name, String phone, String email, String company) {
        super(name, phone, email);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    private String company;

    @Override
    public String toString() {
        return "Name: " + this.getName() +
                "\nPhone: " + this.getPhone() +
                "\nEmail: " + this.getEmail() +
                "\nCompany: " + this.getCompany();
    }
}
