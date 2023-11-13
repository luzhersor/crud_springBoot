package com.example.crud.controller;

import com.example.crud.model.product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

        @Autowired
        private ProductRepository productRepository;

        //1) Get all products
        @GetMapping("/product")
        public ResponseEntity<List<product>> getAllProducts(){
            return ResponseEntity.ok(this.productRepository.findAll());
        }

        //2) Create new product
        @PostMapping("/product/create")
        public product createProduct(@RequestBody product Product) {
            return productRepository.save(Product);
        }

        //3) Get product by Id
        @GetMapping("/product/{id}")
        public product getProductById(@PathVariable String id) {
            //product Product = productRepository.findById(id).orElse(null);
            return productRepository.findById(id).orElse(null);
        }

        //4) Delete product by Id
        @DeleteMapping("/product/delete/{id}")
        public void deleteProduct(@PathVariable String id) {
            productRepository.deleteById(id);
            //return "Eliminado exitosamente: "+id;
        }

        //5) Edit a product
        @PutMapping("/product/edit")
        public product editProduct(@RequestBody product Producto){
            return this.createProduct(Producto);
            //return "Producto editado exitosamente ";
            //IMPORTANT For a easily conection to Angular verify the return object, should be always json, not string
            //that was the error.
        }







}
