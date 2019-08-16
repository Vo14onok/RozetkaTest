package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.dismiss;

public class SortMenu {


    public ProductsPage selectSortChoise (String sortChoice) {

        if (sortChoice.equals("popularity")) {
            $("#filter_sortpopularity").click();
        }
        if (sortChoice.equals("expensivest")) {
            $("#filter_sortexpensive").click();
        }
        if (sortChoice.equals("cheapiest")) {
            $("#filter_sortcheap").click();
        }
        if (sortChoice.equals("newest")) {
            $("#filter_sortnovelty").click();
        }
        if (sortChoice.equals("stock")) {
            $("#filter_sortaction").click();
        }
        return new ProductsPage();
    }

}
