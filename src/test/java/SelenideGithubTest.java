import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {

    @Test
    void selenideGithubTest() {

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $("summary [href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(Condition.text("SoftAssertions"));
        $("summary [href='/selenide/selenide/wiki/SoftAssertions']").click();
        String testString = """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """;
        $$(".highlight-source-java").get(3).scrollTo().shouldHave(Condition.text(testString));

        sleep(5000);


    }
}
