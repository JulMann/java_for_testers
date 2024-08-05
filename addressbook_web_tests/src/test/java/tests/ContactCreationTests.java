package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var nickname : List.of("", "nickname")) {
            for (var email : List.of("", "email")) {
                for (var address : List.of("", "address")) {
                    for (var mobile_tel : List.of("", "mobile_tel")) {
                        result.add(new ContactData("", "", "", nickname, email,
                                "", "", address, "", mobile_tel,
                                "", "", "", "", ""));
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10),
                    randomString(i * 10), "email", "email2", "email3", randomString(i * 10),
                    randomNum(7), randomNum(11), randomNum(12), randomNum(11),
                    "1", "January", "2001"));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("first'name", "middlename", "lastname", "nickname",
                        "email", "email2", "email3",
                        "address", "home_tel", "mobile_tel", "work_tel", "fax",
                        "1", "January", "2001")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}
