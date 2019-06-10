package com.project.online_shop.validator;

import com.project.online_shop.domain.Products;
import com.project.online_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Products.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Products product = (Products) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accessible", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "short_description", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "Required");
    }
}