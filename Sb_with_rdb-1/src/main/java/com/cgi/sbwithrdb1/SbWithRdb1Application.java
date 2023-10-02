package com.cgi.sbwithrdb1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SbWithRdb1Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SbWithRdb1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(SbWithRdb1Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
	@Override
    public void run(String... strings) throws Exception {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
            "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("DROP TABLE products IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE products(" +
            "id SERIAL, product_name VARCHAR(255), price DOUBLE)");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
            .map(name -> name.split(" "))
            .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data for customers
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

        log.info("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate.query(
            "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[]{"Josh"},
            (rs, rowNum) -> new CustomerDAO(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));

        // Insert product data
        List<Object[]> productData = Arrays.asList(
            new Object[]{"Product A", 50.0},
            new Object[]{"Product B", 75.0},
            new Object[]{"Product C", 100.0}
        );

        log.info("Inserting product records...");
        jdbcTemplate.batchUpdate("INSERT INTO products(product_name, price) VALUES (?,?)", productData);

        // Query for product records
        log.info("Querying for products where product_name = 'Product A':");
        jdbcTemplate.query(
            "SELECT id, product_name, price FROM products WHERE product_name = ?", new Object[]{"Product A"},
            (rs, rowNum) -> new ProductDAO(rs.getLong("id"), rs.getString("product_name"), rs.getDouble("price"))
        ).forEach(product -> log.info(product.toString()));
    }
}