package com.dotd.api.core.product;

import com.dotd.api.core.payload.FileUploadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

public interface ProductController {

    //upload Product
    //1. Image Upload Test
    @CrossOrigin(origins = "*")
    @ResponseStatus(value= HttpStatus.OK)
    @PostMapping(
            value = "/product/{productId}",
            consumes = "application/json",
            produces = "application/json")
    FileUploadResponse sendProduct(@PathVariable int productId, @RequestParam("file") MultipartFile file,  @RequestBody ProductInfoDto productInfoDto);

}
