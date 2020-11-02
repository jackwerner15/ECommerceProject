package com.tts.ecommercepage.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all
                  // controllers, for the navbar.
public class MainController {
    // @Autowired
    // ProductService productService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    // @ModelAttribute("products")
    // public List<Product> products() {
    //     return productService.findAll();
    // }

    // @ModelAttribute("categories")
    // public List<String> categories() {
    //     return productService.findDistinctCategories();
    // }

    // @ModelAttribute("brands")
    // public List<String> brands() {
    //     return productService.findDistinctBrands();
    // }

    // @GetMapping("/filter")
    // public String filter(@RequestParam(required = false) String category, @RequestParam(required = false) String brand,
    //         Model model) {
    //     List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
    //     model.addAttribute("products", filtered); // Overrides the @ModelAttribute above.
    //     return "main";
    // }

    // @GetMapping("/about")
    // public String about() {
    //     return "about";
    // }

}