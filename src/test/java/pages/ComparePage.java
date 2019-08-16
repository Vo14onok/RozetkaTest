package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class ComparePage {
    SelenideElement compareMenu =  $("#compare-menu");

    public ComparePage compareItems() {
        $("div.btn-link-to-compare > a").hover().click();
        return new ComparePage();
    }

    public ComparePage printDifferent(){
       compareMenu.$$(".m-tabs-i").get(1).click();
        System.out.println(getInfoForTable(false));
        return this;
    }

    public ComparePage printEquals(){
       compareMenu.$$(".m-tabs-i").get(0).click();
        System.out.println(getInfoForTable(true));
        return this;
    }

    private Map<String, List<String>> getInfoForTable(boolean equal) {
        ElementsCollection collection;
        Map<String, List<String>> result = new HashMap<>();
        if (equal) {
            collection = $$(".comparison-t-row[name=equal]");
        } else {
            collection = $$(".comparison-t-row[name=different]");
        }
        for(SelenideElement element:collection){
            String paramName = element.$(".comparison-t-cell-first").text();
            List<String> compParamList = element.$$(".comparison-t-cell").texts();
            result.put(paramName, compParamList);
        }
        return result;
    }

}
