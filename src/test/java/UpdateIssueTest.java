import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.SubmitIssue;
import pageobject.UpdateIssue;
import testdatamanipulation.ReadTxt;
import utility.Prop;
import utility.Utility;

import java.io.IOException;

public class UpdateIssueTest extends Prop {
    String value,jsonText,id;
    boolean errOk=false;
    boolean success=false;


    Base base;
    WebDriver d;
    Utility u;
    private ReadTxt txt;
    private UpdateIssue update;

    @BeforeTest
    public void setup() throws IOException {
        base = new Base();
        base.ChromeInit();
        this.d = base.d;
        update = new UpdateIssue(d);
        u = new Utility();

    }
    @BeforeMethod
    public void setupMethod() throws IOException {
        errOk=false;
        success=false;
        d.navigate().refresh();
        id = ReadTxt.returnRandomLineNumberOfIds();
    }

    @Test
    public void nothingIsEnteredAndThenSubmitted_C22(){
        update.getSubmit().click();
        base.callWait(update.getJson(),d);
        jsonText = update.getJson().getText();
        if(jsonText.contains(getUpdateErrId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);

    }

    @Test
    public void validIdIsNotEnteredButOtherFields_C23(){
        update.getTitle().sendKeys(getValidTitle());
        update.getText().sendKeys(getValidText());
        update.getSubmit().click();
        base.callWait(update.getJson(),d);
        jsonText = update.getJson().getText();
        if(jsonText.contains(getUpdateErrId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void everythingIsValidEntered_C24() throws IOException {
        update.getId().sendKeys(id);
        update.getTitle().sendKeys(getValidTitle());
        update.getText().sendKeys(getValidText());
        update.getSubmit().click();
        base.callWait(update.getJson(),d);
        jsonText = update.getJson().getText();
        if(jsonText.contains(getSuccessUpdate())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void everythingIsValidEntered_C25() throws IOException {
        update.getId().sendKeys(id);
        update.getTitle().sendKeys(getValidTitle());
        update.getText().sendKeys(getValidText());
        update.changeStatus().click();
        update.getSubmit().click();
        base.callWait(update.getJson(),d);
        jsonText = update.getJson().getText();
        if(jsonText.contains(getSuccessUpdate()) && jsonText.contains("status: false")){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void notValidIdIsEntered_C26(){
        update.getId().sendKeys(getInvalidShortText()); //providing not valid id
        update.getTitle().sendKeys(getValidTitle());
        update.getText().sendKeys(getValidText());
        update.getSubmit().click();
        base.callWait(update.getJson(),d);
        jsonText = update.getJson().getText();
        if(jsonText.contains(getUpdateErrId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
}
