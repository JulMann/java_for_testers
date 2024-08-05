package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ContactCreationTests extends TestBase {

    @ParameterizedTest
    @ValueSource(strings = {"firstname", "First Name"})
    public void canCreateContactWithAllField(String firstname) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "email", "email2", "email3", "address", "home_tel", "mobile_tel", "work_tel", "fax", "1", "January", "2001"));
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @Test
    public void canCreateMultipleContact() {
        int n = 3;
        int contactCount = app.contacts().getCount();
        for (int i = 0; i < n; i++) {
            app.contacts().createContact(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), "email", "email2", "email3", "address", "home_tel", "mobile_tel", "work_tel", "fax", "1", "January", "2001"));
        }
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + n, newContactCount);
    }

    @Test
    public void canCreateContactWithAllEmptyField() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithNickNameOnly() {
        app.contacts().createContact(new ContactData().withNickname("NickNameOnly"));
    }
}
