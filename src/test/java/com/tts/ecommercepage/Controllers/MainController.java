package com.tts.ecommercepage.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.tts.ecommercepage.Model.Product;
import com.tts.ecommercepage.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all
                  // controllers, for the navbar.
public class MainController {
    @Autowired
    ProductService productService;


    public void addNew(){
        List<Product> allProducts = productService.findAll();

        if (allProducts.isEmpty()){
            List<Product> newProducts = new ArrayList<Product>();

            newProducts.add(new Product(4, (float) 1500.00, "Apple MacBook", "images/macbook.jpg"));
            newProducts.add(new Product(3, (float) 1000.00, "Apple TV", "images/tv.jpg"));
            newProducts.add(new Product(12, (float) 800.00, "New Iphone 8", "images/iphone8.jpg"));
            newProducts.add(new Product(7, (float) 1500.00, "Apple New IPhone", "images/iphone.jpg"));

            for (Product product : newProducts) {
                productService.save(product);
            }
        } else {
            System.out.println("You don't need more items!");

        }    
    }
    


    @GetMapping("/")
    public String main() {
        // addNew();
        return "main";
    }

    @ModelAttribute("products")
    public List<Product> products() {
        return productService.findAll();
    }

    @ModelAttribute("categories")
    public List<String> categories(Model model) {
        return productService.findDistinctCategories();
    }

    @ModelAttribute("brands")
    public List<String> brands() {
        return productService.findDistinctBrands();
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(required = false) String category, @RequestParam(required = false) String brand,
            Model model) {
        List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
        model.addAttribute("products", filtered); // Overrides the @ModelAttribute above.
        return "main";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}