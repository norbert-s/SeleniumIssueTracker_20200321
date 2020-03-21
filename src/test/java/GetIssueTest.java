import base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.GetIssue;
import pageobject.SubmitIssue;
import testdatamanipulation.CreateFile;
import testdatamanipulation.ReadTxt;
import testdatamanipulation.SubWord;
import utility.Prop;
import utility.Utility;

import java.io.IOException;
import java.util.List;

public class GetIssueTest extends Prop {

    private String jsonText;

    private GetIssue getIssue;
    private ReadTxt readId;
    private List<WebElement> list;


    boolean errOk=false;
    boolean success=false;

    public SubmitIssue s;



    SubWord a;
    CreateFile file;
    Base base;
    WebDriver d;
    Utility u;

    public GetIssueTest() throws IOException {
        super();
    }
    @BeforeTest
    public void setup() throws IOException {
        base = new Base();
        base.ChromeInit();
        this.d = base.d;
        getIssue = new GetIssue(d);
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
    public void queryStatusOpenActiveWhenThereIsAlreadySomethingInTheDatabase_C30(){
        getIssue.getSubmit().submit();
        if(getIssue.getDivJsons().size()>0){
            success=true;
        }
        System.out.println(getIssue.getDivJsons().size());
        Assert.assertTrue(success);
    }

    @Test
    public void queryStatusOpenActiveWhenDatabaseIsEmpty_C31(){
        getIssue.getSubmit().submit();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();

        if(jsonText.contains(getErrWhenDbEmptyAndStatusActive())){
            success=true;
        }
//        Assert.assertTrue(success); //ez kell ha valoban ures a db ahhoz, hogy igaz legyen
        Assert.assertFalse(success);
    }

    @Test
    public void statusClosedNoRecordsAreFlaggedAsClosed_C32() throws InterruptedException {
        getIssue.getStatus().click();
        getIssue.getStatus().sendKeys(Keys.ARROW_DOWN);
        getIssue.getStatus().sendKeys(Keys.ARROW_DOWN);
        getIssue.getStatus().sendKeys(Keys.COMMAND);
        getIssue.getSubmit().submit();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();

        if(jsonText.contains(getErrWhenDbEmptyAndStatusActive())){
            success=true;
        }
//        Assert.assertTrue(success);//ez kell ha nincs egy se falgelve ahhoz, hogy igaz legyen
        Assert.assertFalse(success);
    }
    @Test //ha van closed akkor kizárja,h ez fusson
    public void statusClosedThereAreRecordsFlaggedAsClosed_C33() throws InterruptedException {
        getIssue.getStatus().click();
        getIssue.getStatus().sendKeys(Keys.ARROW_DOWN);
        getIssue.getStatus().sendKeys(Keys.ARROW_DOWN);
        getIssue.getStatus().sendKeys(Keys.COMMAND);
        getIssue.getSubmit().submit();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();

        list = getIssue.getDivJsons();
        if(list.size()>0){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void validId_C34() throws IOException, InterruptedException {
        String id = ReadTxt.returnRandomLineNumberOfIds();

        getIssue.getId().sendKeys(id);

        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        list = getIssue.getDivJsons();
        if(list.size()==1){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void invalidId_C35() throws IOException {

        getIssue.getId().sendKeys(getValidTitle());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        if(jsonText.contains(getErrWhenDbEmptyAndStatusActive())){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void validTitle_C36() throws IOException {
        getIssue.getTitle().sendKeys("asd");
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()>0){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void invalidTitle_C37(){
        getIssue.getTitle().sendKeys(getInvalidShortTitle());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()==0){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void validText_C38(){
        getIssue.getText().sendKeys(getValidText());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()>0){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void invalidText_39(){
        getIssue.getText().sendKeys(getInvalidShortText());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()==0){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void validCreatedBy_40(){
        getIssue.getCreatedBy().sendKeys(getValidCreatedBy());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()>0){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void invalidCreatedBy_41(){
        getIssue.getCreatedBy().sendKeys(getInvalidShortCreatedBy());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()==0){
            success=true;
        }
        Assert.assertTrue(success);
        Assert.assertTrue(jsonText.contains(getErrWhenDbEmptyAndStatusActive()));
    }

    @Test
    public void validAssignedTo_42(){
        getIssue.getAssignedTo().sendKeys(getAssignedTo2());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()>0){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void invalidAssignedTo_43(){
        getIssue.getAssignedTo().sendKeys(getInvalidAssignedTo());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()==0){
            success=true;
        }
        Assert.assertTrue(success);
        Assert.assertTrue(jsonText.contains(getErrWhenDbEmptyAndStatusActive()));
    }

    @Test
    public void validStatusText_44(){
        getIssue.getStatusText().sendKeys(getStatus());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()>0){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @Test
    public void invalidStatusText_45(){
        getIssue.getStatusText().sendKeys(getInvalidStatusText());
        getIssue.getSubmit().click();
        base.callWait(getIssue.getJsonText(),d);
        jsonText = getIssue.getJsonText().getText();
        list = getIssue.getDivJsons();
        if(list.size()==0){
            success=true;
        }
        Assert.assertTrue(success);
        Assert.assertTrue(jsonText.contains(getErrWhenDbEmptyAndStatusActive()));
    }
}
