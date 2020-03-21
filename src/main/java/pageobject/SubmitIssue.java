package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Prop;
import utility.Utility;

import java.io.IOException;



public class SubmitIssue  {
    public WebDriver d;
    Prop propObj;

    public WebElement title,text,createdBy,assignedTo,status,submit,json;

    public SubmitIssue(WebDriver d) throws IOException {
        this.d = d;

    }

    public  By byTitle = By.cssSelector("form[method='post'] input[name='issue_title']");
    By  byText = By.cssSelector("form[method='post'] textarea[name='issue_text']");
    By  byCreatedBy = By.cssSelector("form[method='post'] input[name='created_by']");
    By  byAssignedTo = By.cssSelector("form[method='post'] input[name='assigned_to']");
    By  byStatusText = By.cssSelector("form[method='post'] input[name='status_text']");

    By bySubmit = By.cssSelector("form[method='post'] button[type='submit']");

    public By byJson = By.id("jsonResult");

    public  WebElement find(By x){
        return d.findElement(x);
    }


    public  void titleSend(){
        find(byTitle).sendKeys();
    }

    public void textSend(String func){
        find(byText).sendKeys(func);
    }

    public void createdBySend(String func){
        find(byCreatedBy).sendKeys(func);
    }



    public WebElement getTitle(){
        return d.findElement(byTitle);
    }

    public WebElement getText(){
        return  d.findElement(byText);

    }

    public WebElement getCreatedBy(){
        return d.findElement(byCreatedBy);

    }

    public WebElement getAssignedTo(){
        return d.findElement(byAssignedTo);

    }

    public WebElement getStatus(){
        return d.findElement(byStatusText);

    }

    public WebElement getSubmit() {
        return d.findElement(bySubmit);
    }

    public WebElement getJson(){
       return d.findElement(byJson);

    }
}
