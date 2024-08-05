package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home_tel());
        type(By.name("mobile"), contact.mobile_tel());
        type(By.name("work"), contact.work_tel());
        type(By.name("fax"), contact.fax());
        dropdownType("bday", contact.day());
        dropdownType("bmonth", contact.month());
        type(By.name("byear"), contact.year());
    }

    public void removeContact() {
        openContactPage();
        selectContact();
        removeSelectedContacts();
        openContactPage();
    }

    private void removeSelectedContacts() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.name("searchstring"))) {
            click(By.linkText("home"));
        }
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    public int getCount() {
        openContactPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContact() {
        openContactPage();
        selectAllContacts();
        removeSelectedContacts();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
