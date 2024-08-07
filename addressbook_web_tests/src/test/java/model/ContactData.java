package model;

public record ContactData(String id, String firstname, String lastname, String email,
                          String address, String mobile_tel) {
    public ContactData() {
        this("", "", "", "", "",
                "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.email,
                this.address, this.mobile_tel);
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.email, this.address, this.mobile_tel);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.email, this.address, this.mobile_tel);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, email, this.address, this.mobile_tel);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, this.email, address, this.mobile_tel);
    }

    public ContactData withMobileTel(String mobile_tel) {
        return new ContactData(this.id, this.firstname, this.lastname, this.email, this.address, mobile_tel);
    }

}
