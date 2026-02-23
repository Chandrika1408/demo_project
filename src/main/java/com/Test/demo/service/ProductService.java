package com.Test.demo.service;

import com.Test.demo.model.Product;
import com.Test.demo.repository.ProductJPARepo;
import com.Test.demo.repository.ProductRepo;
import com.Test.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class ProductService {
   @Autowired
   private ProductRepository productRepository;
   @Autowired
   private ProductRepo productRepo;
   @Autowired
   private ProductJPARepo productJPARepo;


    public List<Product> getAllProducts(){
        Iterator <Product> it=productRepository.findAll().iterator();
        List<Product> list =new ArrayList<>();
        while(it.hasNext()){
            list.add(it.next());
        }
        return list;
    }

    public Product getProductById(int prodId){
        return productRepository.findById(prodId).orElse(null);

    }


    public Product addProduct(Product prod) {

        return productRepository.save(prod);
    }

    public void deleteProduct(int prodId) {
        productRepository.deleteById(prodId);
    }

    public Product updateProduct(Product prod) {
        return productRepository.save(prod);
    }

    public Page<Product> getAllProductsWithPage(int page, int size) {
        return productRepo.findAll(PageRequest.of(page,size));

    }


    public List<Product> getAllProductsWithJPA() {
        return productJPARepo.findAll();
    }

    public List<Product> findAllByName(String prodName) {
        return productJPARepo.findAllByName(prodName);
    }

//    public List<Product> findByNameLike(String prodName) {
//        return productJPARepo.findByNameLike(prodName);
//    }
//
//    public List<Product> findAllByPriceAndOrderByName(int prodPrice) {
//        return productJPARepo.findAllByPriceAndOrderByName(prodPrice);
//    }
}
