package org.wisebite.at.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public interface MainPage {
    SelenideElement result = $x("//div[@id='resultSQL']");
    SelenideElement tableResult = $x("//*[@id=\"divResultSQL\"]//table//td");
    SelenideElement restoreButton =  $x("//button[text()='Restore Database']");
    SelenideElement runSqlButton =   $x("//button[text()='Run SQL »']");
}
