package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteIssue {
    WebDriver d;

    public DeleteIssue(WebDriver d){
        this.d = d;
    }

    By byId = By.cssSelector("form[id='testForm3'] input[name='_id']");
    By bySubmit = By.cssSelector("form[id='testForm3'] button[type='submit']");
    By byJson = By.id("jsonResult");

    public WebElement getIdField(){
        return d.findElement(byId);
    }

    public WebElement getSubmit(){
        return d.findElement(bySubmit);
    }

    public WebElement getJson(){
        return d.findElement(byJson);
    }
}
