package org.wisebite.at;

import org.junit.Test;
import org.wisebite.at.pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SQLTest extends BaseTest {


    @Test
    public void executeSelect() {
        open("/sql/trysql.asp?filename=trysql_select_all");
        executeSLQQuery("UPDATE Customers SET CustomerName = 'aaaa' WHERE CustomerID =1");
        MainPage.result.shouldHave(text("You have made changes to the database. Rows affected: 1"));
        executeSLQQuery("SELECT CustomerName FROM Customers WHERE CustomerID =1");
        MainPage.tableResult.shouldHave(text("aaaa"));
        restoreDatabase();
        MainPage.result.shouldHave(text("The database is fully restored."));
    }

    private void restoreDatabase() {
        MainPage.restoreButton.click();
        confirm();
    }

    private void executeSLQQuery(String sql) {
        executeJavaScript(String.format("editor.setValue(\"%s\")", sql));
        MainPage.runSqlButton.click();
    }


}
