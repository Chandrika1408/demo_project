package com.Test.demo.controller;

import com.Test.demo.model.Product;
import org.springframework.data.domain.Page;
import com.Test.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;


    //http://localhost:8080/getAllProducts
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products =service.getAllProducts();
        if (products==null){
            return new ResponseEntity<>(products,HttpStatus.NOT_FOUND);
        }
       return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //http://localhost:8080/getProduct/4
    @GetMapping("/getProduct/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        Product product =service.getProductById(prodId);
        if(product == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(product);

    }


    //http://localhost:8080/addProduct
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod){
        Product product =service.addProduct(prod);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    //http://localhost:8080/deleteProduct/{prodId}
    @DeleteMapping("/deleteProduct/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }

    //http://localhost:8080/updateProduct/{prodId}
    @PutMapping("/updateProduct/{prodId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable int prodId,
            @RequestBody Product prod){
        prod.setId(prodId);
        return new ResponseEntity<>(service.updateProduct(prod), HttpStatus.OK);

    }

    //http://localhost:8080/getAllProductsWithPage
    @GetMapping("/getAllProductsWithPage")
    public ResponseEntity<Page> getAllProductsWithPage(
            @RequestParam int page,
            @RequestParam int size){
        return new ResponseEntity<>(service.getAllProductsWithPage(page,size),HttpStatus.OK);

    }

    //http://localhost:8080/getAllProductWithJPA
    @GetMapping("/getAllProductWithJPA")
    public ResponseEntity<List<Product>> getAllProductWithJPA(){
        return new ResponseEntity<>(service.getAllProductsWithJPA(),HttpStatus.OK);

    }

    //http://localhost:8080/findAllName
    @GetMapping("/findAllByName")
    public ResponseEntity<List<Product>> findAllByName(@RequestParam String name){
        return new ResponseEntity<>(service.findAllByName(name),HttpStatus.OK);

    }

//    //http://localhost:8080/findByNameLike
//    @GetMapping("/findByNameLike")
//    public ResponseEntity<List<Product>> findByNameLike(@RequestParam String name){
//        return new ResponseEntity<>(service.findByNameLike(name),HttpStatus.OK);
//    }
//
//    //http://localhost:8080/findAllByPriceAndOrderByName
//    @GetMapping("/findAllByPriceAndOrderByName/{prodPrice}")
//    public ResponseEntity<List<Product>> findAllByPriceAndOrderByName(@PathVariable int prodPrice){
//        return new ResponseEntity<>(service.findAllByPriceAndOrderByName(prodPrice),HttpStatus.OK);
//    }

}
