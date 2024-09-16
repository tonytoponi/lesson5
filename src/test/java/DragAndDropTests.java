import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void dragAndDropActionsTests() {
        open("/drag_and_drop");
        actions().dragAndDropBy($("#column-a"), 200, 0).perform();
        $("#column-a").$("header").shouldHave((text("B")));
    }
    @Test
    void dragAndDropTests() {
        open("/drag_and_drop");
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").$("header").shouldHave((text("B")));
    }
}
