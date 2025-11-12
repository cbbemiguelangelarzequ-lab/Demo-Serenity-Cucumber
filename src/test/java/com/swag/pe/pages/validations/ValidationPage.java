package com.swag.pe.pages.validations;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ValidationPage extends PageObject {
    @FindBy(css = "[data-test='title']")
    protected WebElementFacade lbl_product;
    @FindBy(css="h3[data-test='error']")
    protected WebElementFacade lbl_errorMessage;

}
