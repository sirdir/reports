package com.ning;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class Report {

    @Test
    public void report() {
        open("http://jira.ningops.com/login.jsp");

        String username = System.getProperty("jirauser");
        String password = System.getProperty("jirapassword");
        String id1c = System.getProperty("id1c");

        $("#login-form-username").val(username);
        $("#login-form-password").val(password);
        $("#login-form-submit").click();

        $("#plugins-item").shouldBe(visible).click();
        $("#plugins-item-content").should(appear).$("#monthly-timesheet-report-button").click();

        String year = String.valueOf(LocalDateTime.now().getYear());
        $("#year_select").selectOptionByValue(year);
        String month = String.valueOf(LocalDateTime.now().getMonthValue() - 1);
        $("#month_select").selectOptionByValue(month);
        $("#userName").val(username);
        $(".suggestions.dropdown-ready").should(appear).$("li").click();
        $("#defaultCompany_select").selectOptionByValue("Ning.com");
        $("[name='personalNumber']").val(id1c);
        $("#next_submit").click();
        $("p.excel > a").should(appear).click();
        sleep(2000);

        if (System.getProperty("selenide.browser").equals("firefox")) {
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            sleep(2000);
        }

    }
}
