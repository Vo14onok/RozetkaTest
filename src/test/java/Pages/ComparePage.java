package Pages;

import com.codeborne.selenide.SelenideElement;
import com.google.j2objc.annotations.ObjectiveCName;

import static com.codeborne.selenide.Selenide.$;

public class ComparePage {

    public void CompareItems () {
        $("div.btn-link-to-compare > a").hover().click();
    }

}
