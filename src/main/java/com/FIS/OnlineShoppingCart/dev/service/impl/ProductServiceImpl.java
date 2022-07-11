package com.FIS.OnlineShoppingCart.dev.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FIS.OnlineShoppingCart.dev.dao.ProductDAO;
import com.FIS.OnlineShoppingCart.dev.dao.ProductRepository;
import com.FIS.OnlineShoppingCart.dev.entities.Product;
import com.FIS.OnlineShoppingCart.dev.model.CategoriesDTO;
import com.FIS.OnlineShoppingCart.dev.model.ProductDTO;
import com.FIS.OnlineShoppingCart.dev.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> listProduct = productDAO.getAllProduct();

        List<ProductDTO> dtos = new ArrayList<ProductDTO>();

        for (Product p : listProduct) {

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setPrice(p.getPrice());
            productDTO.setDescription(p.getDescription());
            productDTO.setImg_main(p.getImg_main());
            productDTO.setImg_hover(p.getImg_hover());
            productDTO.setImg_sub(p.getImg_sub());


            dtos.add(productDTO);
        }

        return dtos;
    }

    @Override
    public ProductDTO getProductById(int id) {
        ProductDTO productDTO = new ProductDTO();

        Product p = productDAO.getProductById(id);

        productDTO.setId(p.getId());
        productDTO.setName(p.getName());
        productDTO.setPrice(p.getPrice());
        productDTO.setDescription(p.getDescription());
        productDTO.setImg_main(p.getImg_main());
        productDTO.setImg_hover(p.getImg_hover());
        productDTO.setImg_sub(p.getImg_sub());

        return productDTO;
    }

    @Override
    public List<ProductDTO> getProductByCatagories(int categories) {

        List<Product> listProduct = productDAO.getProductByCategories(categories);

        List<ProductDTO> dtos = new ArrayList<ProductDTO>();

        for (Product p : listProduct) {

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setPrice(p.getPrice());

            CategoriesDTO categoriesDTO = new CategoriesDTO();
            categoriesDTO.setId_cate(p.getCategory().getId());
            categoriesDTO.setType(p.getCategory().getType());
            productDTO.setCategory(categoriesDTO);

            productDTO.setDescription(p.getDescription());
            productDTO.setImg_main(p.getImg_main());
            productDTO.setImg_hover(p.getImg_hover());
            productDTO.setImg_sub(p.getImg_sub());


            dtos.add(productDTO);
        }

        return dtos;
    }

    @Override
    public List<ProductDTO> getAll(int page, int sizePerPage) {

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        Pageable pageable = (Pageable) PageRequest.of(page, sizePerPage, Sort.by("id").descending());

        Page<Product> productEntities = productRepository.findAll(pageable);

        for(Product p : productEntities) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setPrice(p.getPrice());

            CategoriesDTO categoriesDTO = new CategoriesDTO();
            categoriesDTO.setId_cate(p.getCategory().getId());
            categoriesDTO.setType(p.getCategory().getType());
            productDTO.setCategory(categoriesDTO);

            productDTO.setDescription(p.getDescription());
            productDTO.setImg_main(p.getImg_main());
            productDTO.setImg_hover(p.getImg_hover());
            productDTO.setImg_sub(p.getImg_sub());

            productDTOs.add(productDTO);
        }

        return productDTOs;
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public List<ProductDTO> search(String keyword, String category, int page, int sizePerPage) {
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        Pageable pageable = (Pageable) PageRequest.of(page, sizePerPage, Sort.by("id").descending());

        List<Product> productEntities = productDAO.findAll(keyword,category, pageable);

        for(Product p : productEntities) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setPrice(p.getPrice());

            CategoriesDTO categoriesDTO = new CategoriesDTO();
            categoriesDTO.setId_cate(p.getCategory().getId());
            categoriesDTO.setType(p.getCategory().getType());
            productDTO.setCategory(categoriesDTO);

            productDTO.setDescription(p.getDescription());
            productDTO.setImg_main(p.getImg_main());
            productDTO.setImg_hover(p.getImg_hover());
            productDTO.setImg_sub(p.getImg_sub());

            productDTOs.add(productDTO);
        }

        return productDTOs;
    }

    @Override
    public List<ProductDTO> getProductForProductPage(String findName,long priceStart, long priceEnd, int start, int length) {

        List<Product> listProducts = productDAO.getProductForProductPage(findName,priceStart,priceEnd, start, length);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        for(Product p : listProducts) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setPrice(p.getPrice());

            CategoriesDTO categoriesDTO = new CategoriesDTO();
            categoriesDTO.setId_cate(p.getCategory().getId());
            categoriesDTO.setType(p.getCategory().getType());
            productDTO.setCategory(categoriesDTO);

            productDTO.setDescription(p.getDescription());
            productDTO.setImg_main(p.getImg_main());
            productDTO.setImg_hover(p.getImg_hover());
            productDTO.setImg_sub(p.getImg_sub());

            productDTOs.add(productDTO);
        }

        return productDTOs;
    }

    @Override
    public List<ProductDTO> getProductForProductPagePriceHigh(String sort) {

        List<Product> listProducts = productDAO.getProductPriceLowtoHigh(sort);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        for(Product p : listProducts) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setPrice(p.getPrice());

            CategoriesDTO categoriesDTO = new CategoriesDTO();
            categoriesDTO.setId_cate(p.getCategory().getId());
            categoriesDTO.setType(p.getCategory().getType());
            productDTO.setCategory(categoriesDTO);

            productDTO.setDescription(p.getDescription());
            productDTO.setImg_main(p.getImg_main());
            productDTO.setImg_hover(p.getImg_hover());
            productDTO.setImg_sub(p.getImg_sub());

            productDTOs.add(productDTO);
        }

        return productDTOs;
    }
}
