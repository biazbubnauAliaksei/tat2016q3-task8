package com.epam.homework.step;

import com.epam.homework.framework.service.iface.ProductService;
import com.epam.homework.framework.service.impl.ProductServiceImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class AddToCardStep {

    private ProductService service = new ProductServiceImpl();
    private String productHeader;

    @When("I click add to cart")
    public void addProductToCart() {
        productHeader = service.getProductHeader();
        service.addToCart();
    }

    @When("go to cart")
    public void goToCart() {
        service.goToCart();
    }

    @Then("I see product in cart")
    @Given("cart page is open")
    public void checkIsCartContainsProduct() {
        Assert.assertTrue("Product should be in cart", service.isCartContainsProduct(productHeader));
    }
}
