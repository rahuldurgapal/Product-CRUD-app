/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.dao.ProductDao;
import com.model.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class MainController {
    
    @Autowired
    private ProductDao productDao;
    
    @RequestMapping("/")
    public String home(Model m)
    {
        List<Product> product = productDao.getProducts();
        System.out.println(product);
        m.addAttribute("product",product);
        return "index";
    }
    
    
    //show add product form
    @RequestMapping("/add-product")
    public String addProduct(Model m)
    {
        m.addAttribute("title","Add Product");
        return "add_product_form";
    }
    
    //handle add product form
    @RequestMapping(value="/handle-product", method=RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request)
    {
        RedirectView rv = new RedirectView();
        System.out.println(product);
        productDao.createProduct(product);
        rv.setUrl(request.getContextPath()+"/");
        return rv;
        
    }
    
    //delete handler
    @RequestMapping(value = "/delete-product/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") int pid, HttpServletRequest request)
    {
        productDao.deleteProduct(pid);
        RedirectView rv = new RedirectView();
        
        rv.setUrl(request.getContextPath());
        
        return rv;
    }
}
