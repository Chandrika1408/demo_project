package com.Test.demo.repository;

import com.Test.demo.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {
}
