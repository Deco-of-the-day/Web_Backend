package com.dotd.api.core.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface ProductController {

    //upload Product
    //1. Image Upload Test
    @CrossOrigin(origins = "*")
    @ResponseStatus(value= HttpStatus.OK)
    @PostMapping(
            value = "/product/{productId}",
            consumes = "application/json",
            produces = "application/json")
    ProductInfoDto sendProduct(@PathVariable int productId, @RequestBody ProductInfoDto productInfoDto);

}
