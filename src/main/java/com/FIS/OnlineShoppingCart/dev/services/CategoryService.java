package com.FIS.OnlineShoppingCart.dev.services;

import com.FIS.OnlineShoppingCart.dev.entities.Category;

import com.FIS.OnlineShoppingCart.dev.repositories.CategoryRepo;
import com.FIS.OnlineShoppingCart.dev.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @PersistenceContext
    protected EntityManager entityManager;
    @Autowired
    private CategoryRepo categoryRepo;

    //Find Category by Id
    Optional<Category> findCategoryById(Integer id)
    {
        return categoryRepo.findById(id);
    }
    //List all Category
    public List<Category> listAllCategory()
    {
        return categoryRepo.findAll();
    }
    //Save Category
    public void saveCategory(Category category)
    {
        categoryRepo.save(category);
    }
    //Delete Category
    public void deleteCategory(Category category)
    {
        categoryRepo.delete(category);
    }
}
