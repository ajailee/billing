/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author ajai
 */
public class Product {
    
    int productid;
    String productname;
    String category;
    int qty;
    double gst;
    double purchaseprice;
    double margin;
    double discount;
    int hsn;
    double total;

    public Product(int productid, String productname, String category, int qty, double gst, double purchaseprice, double margin, double discount, int hsn) {
        this.productid = productid;
        this.productname = productname;
        this.category = category;
        this.qty = qty;
        this.gst = gst;
        this.purchaseprice = purchaseprice;
        this.margin = margin;
        this.discount = discount;
        this.hsn = hsn;
    }

    public Product(int productid, String productname, String category, int qty, double gst, double purchaseprice, double margin, double discount, int hsn, double total) {
        this.productid = productid;
        this.productname = productname;
        this.category = category;
        this.qty = qty;
        this.gst = gst;
        this.purchaseprice = purchaseprice;
        this.margin = margin;
        this.discount = discount;
        this.hsn = hsn;
        this.total = total;
    }

  

    
    

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getHsn() {
        return hsn;
    }

    public void setHsn(int hsn) {
        this.hsn = hsn;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
}
