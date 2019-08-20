package pages;

import static com.codeborne.selenide.Selenide.$$;

public class ProductsTypeMenu {

    public ProductsPage clickOnShowAllResults() {
        $$("group_category").get(2).click();
        return new ProductsPage();
    }
}
