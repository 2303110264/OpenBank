package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import kopo.aisw.hc.product.service.ProductService;
import kopo.aisw.hc.product.vo.ProductVO;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
    @Autowired
    private ProductService productService;
    
    // 상품 목록 조회
    @GetMapping("list")
    public String productList(Model model) {
        try {
            model.addAttribute("p", productService.selectAllProducts());
            return "product/list";
        } catch (Exception e) {
            model.addAttribute("message", "목록을 불러오는데 실패했습니다.");
            return "error";
        }
    }
    
    // 상품 상세정보 조회
    @GetMapping("{productNum}")
    public String productDetail(@PathVariable int productNum, Model model) {
        try {
            model.addAttribute("p", productService.selectProduct(productNum));
            return "product/detail";
        } catch (Exception e) {
            model.addAttribute("message", "상품 정보를 불러오는데 실패했습니다.");
            return "error";
        }
    }
    
    // 상품 등록 페이지 이동
    @GetMapping("register")
    public String productRegisterForm(Model model) {
        model.addAttribute("p", new ProductVO());
        return "product/register";
    }
    
    // 상품 등록 처리
    @PostMapping("register")
    public String productRegister(@Valid @ModelAttribute("p") ProductVO productVO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product/register";
        }
        try {
            productService.insertProduct(productVO);
            return "redirect:/product/list";
        } catch (Exception e) {
            model.addAttribute("message", "상품 등록에 실패했습니다.");
            return "error";
        }
    }
    
    // 상품 수정 페이지 이동
    @GetMapping("edit/{productNum}")
    public String productEditForm(@PathVariable int productNum, Model model) {
        try {
            model.addAttribute("p", productService.selectProduct(productNum));
            return "product/edit";
        } catch (Exception e) {
            model.addAttribute("message", "상품 정보를 불러오는데 실패했습니다.");
            return "error";
        }
    }
    
    // 상품 수정 처리
    @PostMapping("edit")
    public String productEdit(@Valid @ModelAttribute("p") ProductVO productVO, BindingResult result) {
        if (result.hasErrors()) {
            return "product/edit";
        }
        try {
            productService.updateProduct(productVO);
            return "redirect:/product/list";
        } catch (Exception e) {
            return "error";
        }
    }
    
    // 상품 삭제 처리
    @GetMapping("delete/{productNum}")
    public String productDelete(@PathVariable int productNum) {
        try {
            productService.deleteProduct(productNum);
            return "redirect:/product/list";
        } catch (Exception e) {
            return "error";
        }
    }
}