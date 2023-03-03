package com.example.collegeparkautoparts;

import javafx.beans.property.*;

public class PartDescription {
    private LongProperty ID;
    private IntegerProperty yr;
    private StringProperty mk;
    private StringProperty mdl;
    private StringProperty cat;
    private StringProperty name;
    private DoubleProperty price;

    public long getID() {
        return ID.get();
    }

    public LongProperty IDProperty() {
        return ID;
    }

    public void setID(long ID) {
        this.ID.set(ID);
    }

    public int getYr() {
        return yr.get();
    }

    public IntegerProperty yrProperty() {
        return yr;
    }

    public void setYr(int yr) {
        this.yr.set(yr);
    }

    public String getMk() {
        return mk.get();
    }

    public StringProperty mkProperty() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk.set(mk);
    }

    public String getMdl() {
        return mdl.get();
    }

    public StringProperty mdlProperty() {
        return mdl;
    }

    public void setMdl(String mdl) {
        this.mdl.set(mdl);
    }

    public String getCat() {
        return cat.get();
    }

    public StringProperty catProperty() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat.set(cat);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public PartDescription(long code , int year ,
                           String make ,
                           String model ,
                           String type,
                           String desc ,
                           double UPrice )

    {
         ID=new SimpleLongProperty(code);
         yr=new SimpleIntegerProperty(year);
         mk=new SimpleStringProperty(make);
        mdl=new SimpleStringProperty(model);
        cat=new SimpleStringProperty(type);
         name=new SimpleStringProperty(desc);
       price=new SimpleDoubleProperty(UPrice);
    }


    public String toString()
    {
        return this.ID + " " +
                this.yr.toString() + " " +
                this.mk + " " +
                this.mdl + " " +
                this.cat + " " +
                this.name + " " +
                this.price;
    }
}
