package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateIssue {
    public WebDriver d;

    public WebElement id,title,text,createdBy,assignedTo,status,submit,json;

    public UpdateIssue(WebDriver d){
        this.d = d;
    }


    By byId = By.cssSelector("form[method='put'] input[name='_id']");
    By byTitle = By.cssSelector("form[method='put'] input[name='issue_title']");
    By  byText = By.cssSelector("form[method='put'] textarea[name='issue_text']");
    By  byCreatedBy = By.cssSelector("form[method='put'] input[name='created_by']");
    By  byAssignedTo = By.cssSelector("form[method='put'] input[name='assigned_to']");
    By  byStatusText = By.cssSelector("form[method='put'] input[name='status_text']");
    By byCloseIssue = By.cssSelector("form[method='put'] input[name='open']");

    By bySubmit = By.cssSelector("form[method='put'] button[type='submit']");


    public By byJson = By.id("jsonResult");

    public WebElement getId(){
        return d.findElement(byId);
    }
    public WebElement getTitle(){
        return d.findElement(byTitle);
    }

    public WebElement getText(){
        return d.findElement(byText);
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

    public WebElement changeStatus(){
        return d.findElement(byCloseIssue);
    }

    public WebElement getSubmit() {
        return d.findElement(bySubmit);
    }

    public WebElement getJson(){
        return d.findElement(byJson);
    }
}
