package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

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

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactPage();
        initGroupModification(contact);
        fillContactForm(modifiedContact);
        submitGroupModification();
        returnToHomePage();
    }

    public void removeContact(ContactData contact) {
        openContactPage();
        selectContact(contact);
        removeSelectedContacts();
        openContactPage();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("mobile"), contact.mobile_tel());
    }

    public List<ContactData> getList() {
        openContactPage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.xpath("//td/input[@type='checkbox']")).size();
        for (int i = 2; i <= trs + 1; i++) {
            var checkbox = manager.driver.findElement(By.xpath("//tr[" + i + "]/td[1]/input[@type='checkbox']"));
            var id = checkbox.getAttribute("id");
            var td2 = manager.driver.findElement(By.xpath("//tr[" + i + "]/td[2]"));
            var lastname = td2.getText();
            var td3 = manager.driver.findElement(By.xpath("//tr[" + i + "]/td[3]"));
            var firstname = td3.getText();
            var td4 = manager.driver.findElement(By.xpath("//tr[" + i + "]/td[4]"));
            var address = td4.getText();
            var td5 = manager.driver.findElement(By.xpath("//tr[" + i + "]/td[5]"));
            var email = td5.getText();
            var td6 = manager.driver.findElement(By.xpath("//tr[" + i + "]/td[6]"));
            var mobileTel = td6.getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAddress(address).withEmail(email).withMobileTel(mobileTel));
        }
        return contacts;
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[id='%s']", contact.id())));
    }

    private void initGroupModification(ContactData contact) {
        click(By.xpath(String.format("//a[@href='edit.php?id=%s']", contact.id())));
    }

    private void submitGroupModification() {
        click(By.name("update"));
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
