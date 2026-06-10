package com.example.demo.ui;

import com.example.demo.model.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class ProductForm extends FormLayout {
    public ProductForm() {
        TextField name = new TextField("Product Name");
        BigDecimalField price = new BigDecimalField("Price");
        Binder<Product> binder = new Binder<>(Product.class);
        binder.forField(name).bind(Product::getName, Product::setName);
        binder.forField(price).bind(Product::getPrice, Product::setPrice);
        Button save = new Button("Save", e -> {
            Product p = new Product();
            if (binder.writeBeanIfValid(p)) Notification.show("Product saved: " + p.getName());
        });
        add(name, price, save);
    }
}