package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "email", "email2", "email3", "address", "home_tel", "mobile_tel", "work_tel", "fax", "1", "January", "2001"));
        }
        int contactCount = app.contacts().getCount();
        app.contacts().removeContact();
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }

    @Test
    public void canRemoveAllContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "email", "email2", "email3", "address", "home_tel", "mobile_tel", "work_tel", "fax", "1", "January", "2001"));
        }
        int contactCount = app.contacts().getCount();
        app.contacts().removeAllContact();
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}