package at05outlook.sampleapp.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasedPageObject {

    @FindBy(id = "_ariaId_21")
    @CacheLookup
    private WebElement newBtn;

    @FindBy(xpath = "//input")
    @CacheLookup
    private WebElement emailTxt;

    @FindBy(xpath = "//div/input")
    @CacheLookup
    private WebElement subjectTxt;

    @FindBy(className = "allowTextSelection _mcp_32")
    @CacheLookup
    private WebElement bodyText;


    private WebElement receivedEmail;


    @FindBy(xpath = "//div[5]/div/div[2]/div/button")

    private WebElement sendBtb;


    public boolean isLoadPage() {
        try {
            webDriver.findElement(By.className("o365cs-topnavText"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goToSedEmail() {
        newBtn.click();
    }

    public void sendEmailTo(String enail, String suject, String body) {
        emailTxt.clear();
        emailTxt.sendKeys(enail);

        subjectTxt.clear();
        subjectTxt.sendKeys(suject);

       /* bodyText.clear();
        bodyText.sendKeys(body);
       */
       System.out.println("Buscando el boton send");
        sendBtb.findElement(By.xpath("(//button[@type='button'])[171]"));
        sendBtb.click();

        webDriver.navigate().refresh();
        /*String expression = “/libros/libro[autor=\”Miguel de Unamuno\”]”;
        *   “/libros/libro[contains(titulo,\”Fear\”)]”;
        *
        * */
        //receivedEmail.findElement(By.xpath("//span[contains(span, \"Automation2\")]"));
        receivedEmail.findElement(By.xpath("//div[5]/div[2]/div[4]/div[3]/span/span"));

        System.out.println( "El texto es: "+receivedEmail.getText());

    }

    @Override
    public void waitPageIsLoaded() throws WebDriverException {

    }
}
