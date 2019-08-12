package Pages;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {


    public void Producer(String arg1, String arg2,String arg3) {

        List<String> args = Arrays.asList(arg1, arg2, arg3);

        for (int i = 0; i < args.size(); i++ ) {
            if (args.get(i).equals("Boch")) {
                $("#filter_producer_148").click();
            }
            if (args.get(i).equals("LG")) {
                $("#filter_producer_14").click();
            }
            if (args.get(i).equals("Samsung")) {
                $("#filter_producer_12").click();
            }

        }

    }

    public void SortMenu () {
        $("a.dropdown-link").click();
    }

    public void SortMenuChoiseByPopularyty () {
        $("#filter_sortpopularity").click();
    }

    public void ProductItem (int i) {
        $$("div.over-wraper").get(i).hover();
    }

    public void ProductItemComparisionIcon (int i) {
        $$("[name=comparison_new_catalog]").get(i).hover().click();
    }

}
