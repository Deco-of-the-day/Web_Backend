package com.dotd.api.core.product;

public class ProductInfoDto {

    private final String productUrl;

    public ProductInfoDto(){
        productUrl = "nothing";
    }

    public ProductInfoDto(String productUrl){
        this.productUrl = productUrl;
    }

    public String getProductUrl(){
        return productUrl;
    }

}
