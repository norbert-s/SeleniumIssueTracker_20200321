package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GetIssue {
    private WebDriver d;
    public GetIssue (WebDriver d){
        this.d = d;
        PageFactory.initElements(d, this);
    }

    @FindBy(css="form[id='testForm4'] input[name='_id']")
    public WebElement id;

    @FindBy(css="form[id='testForm4'] input[name='issue_title']")
    public WebElement title;

    @FindBy(css="form[id='testForm4'] textarea[name='issue_text']")
    public WebElement text;

    @FindBy(css="form[id='testForm4'] input[name='created_by']")
    public WebElement createdBy;

    @FindBy(css="form[id='testForm4'] input[name='assigned_to']")
    public WebElement assignedTo;

    @FindBy(css="form[id='testForm4'] input[name='status_text']")
    public WebElement statusText;

    @FindBy(css="select[name='status']")
    public WebElement status;

    @FindBy(css="form[id='testForm4'] button[type='submit']")
    public WebElement submit;

    @FindBy(css="code[id='jsonResult']")
    public WebElement jsonText;

    @FindBy(css="div[id='jsonResult']")
    public List<WebElement> divJsons;

//    @FindBy(css="option[value='o']")
//    public WebElement open;
//
//    @FindBy(css="option[value='c']")
//    public WebElement closed;

    public WebElement getTitle(){
        return title;
    }

    public WebElement getText(){
        return text;
    }

    public WebElement getCreatedBy(){
        return createdBy;
    }

    public WebElement getAssignedTo(){
        return assignedTo;
    }

    public WebElement getStatusText(){
        return statusText;
    }

    public WebElement getStatus(){
        return status;
    }

    public WebElement getId(){
        return id;
    }

    public WebElement getSubmit(){
        return submit;
    }

    public WebElement getJsonText(){
        return jsonText;
    }

    public List getDivJsons(){
        return divJsons;
    }
}
