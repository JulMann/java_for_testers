package model;

public record ContactData(String id, String firstname, String lastname,
                          String address, String email, String mobile_tel) {
    public ContactData() {
        this("", "", "", "", "",
                "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname,
                this.address, this.email, this.mobile_tel);
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.address, this.email, this.mobile_tel);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.address, this.email, this.mobile_tel);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, email, this.mobile_tel);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, address, this.email, this.mobile_tel);
    }

    public ContactData withMobileTel(String mobile_tel) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.email, mobile_tel);
    }

}
