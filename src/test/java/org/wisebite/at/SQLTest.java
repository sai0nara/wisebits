package org.wisebite.at;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SQLTest {

    @Before
    public void openUrl(){
        open("https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all");
    }

    @Test
    public void executeSelect() {
        executeSLQQuery();
        $x("//div[@id='resultSQL']").shouldHave(text("You have made changes to the database. Rows affected: 1"));
        restoreDatabase();
        $x("//div[@id='resultSQL']").shouldHave(text("The database is fully restored."));
    }

    private void restoreDatabase() {
        $x("//button[text()='Restore Database']").click();
        confirm();
    }

    private void executeSLQQuery() {
        executeJavaScript("editor.setValue(\"UPDATE Customers SET CustomerName = 'aaaa' WHERE CustomerID =1\")");
        $x("//button[text()='Run SQL »']").click();
    }
}
