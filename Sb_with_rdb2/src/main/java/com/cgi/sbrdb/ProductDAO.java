/**
 * 
 */
package com.cgi.sbrdb;

/**
 *  created by Satyam Kumar Singh
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductDAO {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private double price;

  protected ProductDAO() {}

  public ProductDAO(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format(
        "Product[id=%d, productName='%s', price=%.2f]",
        id, name, price);
  }

  public Long getId() {
    return id;
  }

  public String getProductName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}

