package pages;

import com.codeborne.selenide.Condition;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {


    public ProductsPage selectProductOwner(List<String> productOwners) {

        for (int i = 0; i < productOwners.size(); i++ ) {
            if (productOwners.get(i).equals("Boch")) {
                $("#filter_producer_148").click();
            }
            if (productOwners.get(i).equals("LG")) {
                $("#filter_producer_14").click();
            }
            if (productOwners.get(i).equals("Samsung")) {
                $("#filter_producer_12").click();
            }

        }

        return new ProductsPage();

    }

    public SortMenu openSortMenu () {
        $("a.dropdown-link").click();
        return new SortMenu();
    }

    public ProductsPage hoverProductItem (int i) {
        $$("div.over-wraper").get(i).hover();
        return new ProductsPage();
    }

    public ProductsPage clickProductItemComparisionIcon (int i) {
        $$("[name=comparison_new_catalog]").get(i).hover().click();
        return new ProductsPage();
    }

}
