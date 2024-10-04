package org.arsenisf;

import org.arsenisf.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate Jdbc;

    @Autowired
    public PurchaseRepository (JdbcTemplate jdbcTemplate) {
        this.Jdbc = jdbcTemplate;
    }

    public List<Purchase> selectAll() {
        String sql = "SELECT * FROM \"JDBCschema\".purchase";
        RowMapper<Purchase> rowMapper = (r, i) -> {
            Purchase purchase = new Purchase();
            purchase.setId(r.getInt("id"));
            purchase.setPrice(r.getInt("price"));
            purchase.setProduct(r.getString("product"));
            return purchase;
        };
        return Jdbc.query(sql, rowMapper);
    }

    public void addPurchase(Purchase purchase) {
        String sql = "INSERT INTO \"JDBCschema\".purchase (product, price) VALUES (?, ?)";
        Jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }
}
