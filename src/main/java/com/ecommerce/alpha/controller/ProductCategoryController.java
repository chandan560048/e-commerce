package com.ecommerce.alpha.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.alpha.dtos.ProductCategoryInputDto;
import com.ecommerce.alpha.dtos.ProductCategoryOutputDto;
import com.ecommerce.alpha.dtos.ProductOutputDto;
import com.ecommerce.alpha.service.ProductCategoryService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("api/v1")
public class ProductCategoryController {
	
	
	private ProductCategoryService productCategoryService;
	
	public ProductCategoryController(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
		
	}
	
	
	@ApiResponses({
	    @ApiResponse(responseCode = "201", content = {
	                @Content(schema = @Schema(implementation = ProductCategoryInputDto.class), mediaType = "application/json")
	    }),
	    @ApiResponse(responseCode = "500", content = {
	                @Content(schema = @Schema(implementation = Exception.class), mediaType = "application/json")
	    }),
	})
	@PostMapping("/addCategory")
	public ResponseEntity<ProductCategoryOutputDto> addProduct(@RequestBody ProductCategoryInputDto productCategory) {
		return new ResponseEntity<ProductCategoryOutputDto>(productCategoryService.addCategory(productCategory), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAllCategory")
	public ResponseEntity<List<ProductCategoryOutputDto>> fetchAllCategory() {
		return new ResponseEntity<List<ProductCategoryOutputDto>>(productCategoryService.fetchAllCategory(), HttpStatus.OK);
	}
	
	@GetMapping("/fetchProducts")
	public ResponseEntity<List<ProductOutputDto>> fetchProductsWithCategoryName(@RequestParam String categoryName) {
		return new ResponseEntity<List<ProductOutputDto>>(productCategoryService.fetchProductsWithCategoryName(categoryName), HttpStatus.OK);
	}

}
