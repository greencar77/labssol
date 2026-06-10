package com.example.demo.ui;

import com.example.demo.model.Customer;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CustomerForm extends FormLayout {
    private final TextField name = new TextField("Name");
    private final EmailField email = new EmailField("Email");

    public CustomerForm() {
        Binder<Customer> binder = new Binder<>(Customer.class);
        binder.bindInstanceFields(this);
        Button save = new Button("Save", e -> {
            Customer c = new Customer();
            if (binder.writeBeanIfValid(c)) Notification.show("Customer saved: " + c.getName());
        });
        add(name, email, save);
    }
}