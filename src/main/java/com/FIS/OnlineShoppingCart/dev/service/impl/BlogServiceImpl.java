package com.FIS.OnlineShoppingCart.dev.service.impl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.FIS.OnlineShoppingCart.dev.dao.BlogDAO;
import com.FIS.OnlineShoppingCart.dev.dao.BlogRepository;
import com.FIS.OnlineShoppingCart.dev.entities.Blog;
import com.FIS.OnlineShoppingCart.dev.entities.CategoriesForBlog;
import com.FIS.OnlineShoppingCart.dev.entities.Tag;
import com.FIS.OnlineShoppingCart.dev.model.BlogDTO;
import com.FIS.OnlineShoppingCart.dev.model.CategoriesForBlogDTO;
import com.FIS.OnlineShoppingCart.dev.model.TagDTO;
import com.FIS.OnlineShoppingCart.dev.service.BlogService;

@Transactional
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDAO blogDao;

    @Autowired
    BlogRepository blogRepo;

    @Override
    public List<BlogDTO> getAllBlogs() {
        List<Blog> listBlogs = blogDao.getAllBlogs();

        List<BlogDTO> listBlogDTO = new ArrayList<BlogDTO>();

        for (Blog b : listBlogs) {
            BlogDTO blogDTO = new BlogDTO();

            blogDTO.setId(b.getId());
            blogDTO.setTitle(b.getTitle());
            blogDTO.setContent(b.getContent());
            blogDTO.setCreated_time(b.getCreated_time());
            blogDTO.setCreated_day(b.getCreated_day());
            blogDTO.setCreated_month(b.getCreated_month());
            blogDTO.setImageBlog(b.getImageBlog());

            List<TagDTO> setTagDTO = new ArrayList<TagDTO>();

            for (Tag t : b.getTags()) {
                TagDTO tagDTO = new TagDTO();

                tagDTO.setId(t.getId());
                tagDTO.setType(t.getType());

                setTagDTO.add(tagDTO);
            }

            blogDTO.setTags(setTagDTO);

            CategoriesForBlogDTO categoryForBlogDTO = new CategoriesForBlogDTO();
            categoryForBlogDTO.setId(b.getCategoriesForBlog().getId());
            categoryForBlogDTO.setType(b.getCategoriesForBlog().getType());

            blogDTO.setCategoriesForBlogDTO(categoryForBlogDTO);

            listBlogDTO.add(blogDTO);
        }
        return listBlogDTO;
    }

    @Override
    public BlogDTO getOneBlog(Integer id) {
        Blog b = blogDao.getOneBlog(id);

        BlogDTO blogDTO = new BlogDTO();

        blogDTO.setId(b.getId());
        blogDTO.setTitle(b.getTitle());
        blogDTO.setContent(b.getContent());
        blogDTO.setCreated_time(b.getCreated_time());
        blogDTO.setCreated_day(b.getCreated_day());
        blogDTO.setCreated_month(b.getCreated_month());
        blogDTO.setImageBlog(b.getImageBlog());

        List<TagDTO> setTagDTO = new ArrayList<TagDTO>();

        for (Tag t : b.getTags()) {
            TagDTO tagDTO = new TagDTO();

            tagDTO.setId(t.getId());
            tagDTO.setType(t.getType());

            setTagDTO.add(tagDTO);
        }

        blogDTO.setTags(setTagDTO);

        CategoriesForBlogDTO categoryForBlogDTO = new CategoriesForBlogDTO();
        categoryForBlogDTO.setId(b.getCategoriesForBlog().getId());
        categoryForBlogDTO.setType(b.getCategoriesForBlog().getType());

        blogDTO.setCategoriesForBlogDTO(categoryForBlogDTO);

        return blogDTO;
    }

    @Override
    public Blog addNewBlog(BlogDTO blogDTO) {

        LocalDateTime myDateObj = LocalDateTime.now();

        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("MMM yyyy");
        DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedMonthYear = myDateObj.format(myFormatObj1);
        String formattedDay = myDateObj.format(myFormatObj2);
        String formattedTime = myDateObj.format(myFormatObj3);

        Blog blog = new Blog();

//		blog.setId(blogDTO.getId());
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setCreated_time(String.valueOf(formattedTime));
        blog.setCreated_day(Integer.valueOf(formattedDay));
        blog.setCreated_month(formattedMonthYear);
        blog.setImageBlog(blogDTO.getImageBlog());

        CategoriesForBlog categoriesForBlog = new CategoriesForBlog();
        categoriesForBlog.setId(blogDTO.getCategoriesForBlogDTO().getId());
        categoriesForBlog.setType(blogDTO.getCategoriesForBlogDTO().getType());
        blog.setCategoriesForBlog(categoriesForBlog);

        Set<Tag> setTag = new HashSet<>();

        for (int tagId : blogDTO.getTagIds()) {
            Tag tag = new Tag();
            tag.setId(tagId); // ;khi them va edit dung tagIds

            setTag.add(tag);
        }

        blog.setTags(setTag);

        blogDao.addNewBlog(blog);

        return blog;
    }

    @Override
    public Blog editBlog(BlogDTO blogDTO) {

        LocalDateTime myDateObj = LocalDateTime.now();

        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("MMM yyyy");
        DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedMonthYear = myDateObj.format(myFormatObj1);
        String formattedDay = myDateObj.format(myFormatObj2);
        String formattedTime = myDateObj.format(myFormatObj3);

        Blog blog = blogDao.getOneBlog(blogDTO.getId());

        blog.setId(blogDTO.getId());
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setCreated_time(String.valueOf(formattedTime));
        blog.setCreated_day(Integer.valueOf(formattedDay));
        blog.setCreated_month(formattedMonthYear);
        blog.setImageBlog(blogDTO.getImageBlog());

        CategoriesForBlog categoriesForBlog = new CategoriesForBlog();
        categoriesForBlog.setId(blogDTO.getCategoriesForBlogDTO().getId());
        categoriesForBlog.setType(blogDTO.getCategoriesForBlogDTO().getType());
        blog.setCategoriesForBlog(categoriesForBlog);

        // blog.setCategoriesForBlog(new
        // CategoriesForBlog(blog.getCategoriesForBlog().getId()));

        System.out.println(blogDTO.getCategoriesForBlogDTO().getId());

        Set<Tag> setTag = new HashSet<>();

        for (int t : blogDTO.getTagIds()) {
            Tag tag = new Tag();

            tag.setId(t);


            setTag.add(tag);
        }

        blog.setTags(setTag);

        blogDao.editBlog(blog);

        return blog;

    }

    @Override
    public void deleteBlog(int id) {
        Blog blog = blogDao.getOneBlog(id);

        if (blog != null) {
            blogDao.deleteBlog(blog);
        }
    }

    @Override
    public List<BlogDTO> getBlogForBlogPage(String keyword, String category, String month, String tag, int page, int sizePerPage) {

        Pageable pageable = (Pageable) PageRequest.of(page, sizePerPage, Sort.by("id").descending());

        List<Blog> listBlogs = blogRepo.findAll(keyword, category, month, tag, pageable);

        List<BlogDTO> listBlogDTO = new ArrayList<BlogDTO>();

        for (Blog b : listBlogs) {
            BlogDTO blogDTO = new BlogDTO();

            blogDTO.setId(b.getId());
            blogDTO.setTitle(b.getTitle());
            blogDTO.setContent(b.getContent());
            blogDTO.setCreated_time(b.getCreated_time());
            blogDTO.setCreated_day(b.getCreated_day());
            blogDTO.setCreated_month(b.getCreated_month());
            blogDTO.setImageBlog(b.getImageBlog());

            List<TagDTO> setTagDTO = new ArrayList<TagDTO>();

            for (Tag t : b.getTags()) {
                TagDTO tagDTO = new TagDTO();

                tagDTO.setId(t.getId());
                tagDTO.setType(t.getType());

                setTagDTO.add(tagDTO);
            }

            blogDTO.setTags(setTagDTO);

            CategoriesForBlogDTO categoryForBlogDTO = new CategoriesForBlogDTO();
            categoryForBlogDTO.setId(b.getCategoriesForBlog().getId());
            categoryForBlogDTO.setType(b.getCategoriesForBlog().getType());

            blogDTO.setCategoriesForBlogDTO(categoryForBlogDTO);

            listBlogDTO.add(blogDTO);
        }

        return listBlogDTO;
    }

    @Override
    public long count() {

        return blogRepo.count();
    }
}