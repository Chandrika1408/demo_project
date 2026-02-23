package com.Test.demo.repository;

import com.Test.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJPARepo extends JpaRepository<Product,Integer> {
    List<Product> findAllByName(String name);

//    @Query(value = "SELECT * FROM product WHERE name LIKE %:name%")
//    List<Product> findByNameLike(String prodName);
//
//    List<Product> findAllByPriceAndOrderByName(int prodPrice);
}
