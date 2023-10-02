/**
 * 
 */
package com.cgi.sbwithrdb1;

/**
 *  created by Satyam Kumar Singh
 */
public class ProductDAO {
    private long id;
    private String productName;
    private double price;

    public ProductDAO(long id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
            "Product[id=%d, productName='%s', price=%.2f]",
            id, productName, price);
    }

    // getters & setters omitted for brevity
}
