package com.example.demo.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    public MainView() {
        CustomerForm cf = new CustomerForm();
        ProductForm pf = new ProductForm();
        Tab c = new Tab("Customer");
        Tab p = new Tab("Product");
        Tabs tabs = new Tabs(c, p);
        add(tabs, cf);
        tabs.addSelectedChangeListener(e -> {
            removeAll();
            add(tabs);
            add(e.getSelectedTab() == c ? cf : pf);
        });
    }
}