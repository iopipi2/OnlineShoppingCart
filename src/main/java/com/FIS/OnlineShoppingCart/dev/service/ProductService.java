package com.FIS.OnlineShoppingCart.dev.service;

import java.util.List;

import com.FIS.OnlineShoppingCart.dev.model.ProductDTO;

public interface ProductService {

    public List<ProductDTO> getAllProduct();

    public ProductDTO getProductById(int id);

    public List<ProductDTO> getProductByCatagories(int categories);

    public List<ProductDTO> getAll(int page, int sizePerPage);

    public List<ProductDTO> search(String keyword, String category, int page, int sizePerPage);

    public long count();

    public List<ProductDTO> getProductForProductPage(String findName, long priceStart, long priceEnd, int start, int length);

    public List<ProductDTO> getProductForProductPagePriceHigh(String sort);
}