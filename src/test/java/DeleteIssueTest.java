import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.DeleteIssue;
import pageobject.GetIssue;
import pageobject.SubmitIssue;
import testdatamanipulation.CreateFile;
import testdatamanipulation.ReadTxt;
import testdatamanipulation.SubWord;
import utility.Prop;
import utility.Utility;

import java.io.IOException;

public class DeleteIssueTest extends Prop {

    private String value,jsonText,id;
    private boolean errOk=false;
    private boolean success=false;

    private WebDriverWait wait;

    private ReadTxt txt;

    private DeleteIssue delete;
    private SubmitIssue submit;

    SubWord a;
    CreateFile file;
    Base base;
    WebDriver d;
    Utility u;

    public DeleteIssueTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        base = new Base();
        base.ChromeInit();
        this.d = base.d;
        delete = new DeleteIssue(d);
        submit = new SubmitIssue(d);
        u = new Utility();
    }
    @BeforeMethod
    public void setupMethod() throws IOException {
        errOk=false;
        success=false;
        jsonText="";
        d.navigate().refresh();

    }

    @Test
    public void nothingIsEnteredAndThenSubmitted_C27() throws InterruptedException {
        delete.getSubmit().click();
        base.callWait(delete.getJson(),d);
        jsonText = delete.getJson().getText();
        if(jsonText.contains(getErrDeleteId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void invalidIdEntered_C28() throws InterruptedException {
        delete.getIdField().sendKeys(getValidText());
        delete.getSubmit().click();

        base.callWait(delete.getJson(),d);
        jsonText = delete.getJson().getText();
        if(jsonText.contains(getErrDeleteId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void validIdEntered_26() throws InterruptedException {

        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();

        Thread.sleep(3000);
        base.callWait(delete.getJson(),d);

        String json = submit.getJson().getText();
        String [] tomb = json.split(" ");
        json = tomb[4];
        tomb = json.split("t");
        String id = tomb[0];
        d.navigate().refresh();
        jsonText="";
        delete.getIdField().sendKeys(id);
        delete.getSubmit().submit();
        base.callWait(delete.getJson(),d);
        jsonText = delete.getJson().getText();
        System.out.println(jsonText);
        if(jsonText.contains("and the record below has been")){
            success = true;
        }
        Assert.assertTrue(success);

    }





}
