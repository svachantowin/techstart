package com.techstart.productrankservice.controller;

import com.techstart.productrankservice.payload.CategoryRankResponse;
import com.techstart.productrankservice.payload.CategoryRequest;
import com.techstart.productrankservice.payload.ProductRankResponse;
import com.techstart.productrankservice.service.ProductRankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/productRanks")
@RestController
public class ProductRankController {

    private ProductRankService productRankService;

    @Autowired
    public ProductRankController(ProductRankService productRankService) {
        this.productRankService = productRankService;
    }

    @Operation(summary = "Endpoint to fetch the Sales rank of Given productId in all related categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched rank of the product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductRankResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Arguments supplied",
                    content = @Content)
    })
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductRank(@PathVariable(value = "productId") Long productId) throws EntityNotFoundException {
        return ResponseEntity.ok(new ProductRankResponse());
    }

    @GetMapping("/byCategory")
    @Operation(summary = "Endpoint to fetch top n products in given categoryId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched top n product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryRankResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Arguments supplied",
                    content = @Content)
    })
    public ResponseEntity<?> getTopNrank(@RequestBody CategoryRequest categoryRequest) throws EntityNotFoundException {
        return ResponseEntity.ok(new CategoryRankResponse());
    }


}
