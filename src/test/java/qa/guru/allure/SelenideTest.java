package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.sun.security.auth.login.ConfigFile;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.sql.SQLOutput;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Gulnara10610/QA_guru");
        $(".header-search-input").submit();

        $(linkText("Gulnara10610/QA_guru")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }

    @Test
    void testSearchWiki(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").$(byText("Soft assertions")).click();
        $("ol>*:nth-child(3)").shouldHave(text("JUnit5 extension"));
    }
    @Test
    void search(){

        open("https://github.com/qa-guru/qa_guru_14_10");
        $("footer div").click();
        String text = $("footer div").getText();
        System.out.println(text);
    }

    @Test
    void search2(){
        open("https://github.com/qa-guru/qa_guru_14_10");
        $("footer").$("div").click();
        String text1 = $("footer div").getText();
        System.out.println(text1);
    }




}
