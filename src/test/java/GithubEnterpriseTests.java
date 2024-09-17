import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GithubEnterpriseTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void aiPageHeaderTest() {
        open("/");
        $(".HeaderMenu").$(byTagAndText("button", "Enterprise")).hover();
        $(byTagAndText("div", "AI-powered developer platform")).click();
        $("#hero-section-brand-heading").shouldHave(text("""
                The AI-powered
                developer platform."""));
    }
}
