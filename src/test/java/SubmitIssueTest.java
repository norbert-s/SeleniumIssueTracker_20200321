import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.SubmitIssue;
import pageobject.SubmitIssue;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdatamanipulation.CreateFile;
import testdatamanipulation.SubWord;
import utility.Prop;
import utility.Utility;

import java.io.IOException;



public class SubmitIssueTest extends Prop {
    String value,jsonText;
    boolean errOk=false;
    boolean success=false;

    public SubmitIssue s;

    private WebDriverWait wait;

    SubWord a;
    CreateFile file;
    Base base;
    WebDriver d;
    Utility u;

    SubmitIssueTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        base = new Base();
        base.ChromeInit();
        this.d = base.d;
        s = new SubmitIssue(d);
        u = new Utility();
    }
    @BeforeMethod
    public void setupMethod(){
        d.navigate().refresh();
    }

//    @Test
//    public void probe(){
//
//        titleSend(getValidTitle());
//        titleSend(getValidTitle());
//
//    }

    @Test
    public void validValuesForTheAPI_C1() throws InterruptedException {
        s.titleSend();
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();

        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean containsSuccess=false;
        if(jsonText.contains(getSuccess())){
            containsSuccess=true;
        }

        Assert.assertTrue(containsSuccess);
    }
//
    @Test
    public void nonValidTitle_C2() throws InterruptedException {
        s.getTitle().sendKeys(getInvalidShortTitle());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void nothingIsEnteredToBested_C3() throws InterruptedException {
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void mandatoryFieldsAreEnteredExceptTitle_C4() throws InterruptedException {

        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void titleIsProvidedButNoTextField_C5() throws InterruptedException {
        s.getTitle().sendKeys(getValidTitle());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void noTextisEntered_C6() throws InterruptedException {
        s.getTitle().sendKeys(getValidTitle());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void firstTwoButNotThird_C7() throws InterruptedException {
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrCreatedByShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void firstIsTwoChars_C9() throws InterruptedException {
        s.getTitle().sendKeys(getInvalidShortTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void secondIsTwoChars_C10() throws InterruptedException {
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getInvalidShortText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
       // //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void thirdIsTwoChars_C11() throws InterruptedException {
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getInvalidShortCreatedBy());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrCreatedByShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void FourEntered_C12() throws InterruptedException {
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getAssignedTo().sendKeys(getAssignedTo());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void allFiveEntered_C14() throws InterruptedException, IOException {


        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getAssignedTo().sendKeys(getAssignedTo());
        s.getStatus().sendKeys(getStatus());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);

    }
    @Test
    public void title256Chars_C15() throws InterruptedException, IOException {
        a = new SubWord();
        String chars256 = a.getString(256);
        s.getTitle().sendKeys(chars256);
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getAssignedTo().sendKeys(getAssignedTo());
        s.getStatus().sendKeys(getStatus());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrTitleShort())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void text3001Chars_C16() throws InterruptedException, IOException {
        file = new CreateFile();

        String data = file.createData(3001);
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(data);
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrTextShort())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void text3000Chars_C17() throws InterruptedException, IOException {
        file = new CreateFile();
        String data = file.createData(3000);
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(data);
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void title255Chars_C18() throws InterruptedException, IOException {
        a = new SubWord();
        String chars256 = a.getString(255);
        s.getTitle().sendKeys(chars256);
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getAssignedTo().sendKeys(getAssignedTo());
        s.getStatus().sendKeys(getStatus());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
//        wait = callWait(s.getJson());
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void createdBy256Chars_C20() throws InterruptedException, IOException {
//        a = new SubWord();
//        String chars256 = a.getString(256);
        file = new CreateFile();
        String data = file.createData(256);
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(data);
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
//        wait = callWait(s.getJson());
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrCreatedByShort())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void createdBy255Chars_C21() throws InterruptedException, IOException {
//        a = new SubWord();
//        String chars256 = a.getString(255);
        file = new CreateFile();
        String data = file.createData(255);
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(data);
        s.getSubmit().click();
        base.callWait(s.getJson(),d);

//        wait = callWait(s.getJson());
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @AfterTest
    public void tearDown(){

    }
}
