package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "firstname", "lastname", "email", "address", "mobile_tel"));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void canRemoveAllContacts() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "firstname1", "lastname1", "email", "address", "mobile_tel"));
            app.contacts().createContact(new ContactData("", "firstname2", "lastname2", "email", "address", "mobile_tel"));
        }
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}