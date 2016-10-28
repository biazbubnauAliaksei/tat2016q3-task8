package com.epam.homework.step;

import com.epam.homework.framework.service.iface.CategoryService;
import com.epam.homework.framework.service.impl.CategoryServiceImpl;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class SearchByBrandNameStep {

    private CategoryService service = new CategoryServiceImpl();

    @When("I choose $name")
    public void selectBrandName(String name) {
        service.clickBrandButton(name);
    }

    @Then("get $name result page")
    public void getSearchResultPage(String name) {
        assertTrue(service.isTargetBrandSelected(name));
    }

}
