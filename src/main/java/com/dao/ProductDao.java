/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;


import com.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



public class ProductDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    //create
    @Transactional
    public void createProduct(Product product)
    {
        hibernateTemplate.save(product);
    }
    
    
    //get all product
    public List<Product> getProducts()
    {
       
        List<Product>  product = hibernateTemplate.loadAll(Product.class);
        return product;
    }
    
    //delete the product
    @Transactional  
    public void deleteProduct(int pid)
    {
        Product p = hibernateTemplate.get(Product.class, pid);
        hibernateTemplate.delete(p);
    }
    
    //get the single product
    public Product getProduct(int pid)
    {
        Product p = hibernateTemplate.get(Product.class, pid);
        return p;
    }
}
