package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class VendingMachineBinTest {

    VendingMachineBin vmb;
    Product testProduct;

    @BeforeEach
    void setup(){
        vmb = new VendingMachineBin();
        testProduct = new Product();
        testProduct.setItemName("Test Item");
        testProduct.setPrice(2.75);

    }


    @Test
    void vendProduct() {

        // load 3 items
        vmb.loadProduct(Product.clone(testProduct));
        vmb.loadProduct(Product.clone(testProduct));
        vmb.loadProduct(Product.clone(testProduct));

        // vend 3 items
        assertDoesNotThrow(() -> vmb.vendProduct());
        assertDoesNotThrow(() -> vmb.vendProduct());
        assertDoesNotThrow(() -> vmb.vendProduct());

    }
}