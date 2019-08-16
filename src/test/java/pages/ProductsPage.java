package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    private final ElementsCollection productElements = $$("div.over-wraper");

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

    public ProductsPage clickProductItem (int i) {
        productElements.get(i).click();
        return new ProductsPage();
    }

    public ProductsPage clickProductItemComparisionIcon (int i) {
        productElements.get(i).hover().$$("[name=comparison_new_catalog]").get(i).hover().click();
        return new ProductsPage();

    }public ProductsPage clickProductItemAddToWishlist (int i) {
        productElements.get(i).hover().$$("[name=wishlists_catalog_new_tile]").get(i).hover().click();
        return new ProductsPage();

    }public ProductPage clickProductItemAddToKart (int i) {
        productElements.get(i).hover().$$("[name=buy_catalog]").get(i).hover().click();
        return new ProductPage();
    }

}
