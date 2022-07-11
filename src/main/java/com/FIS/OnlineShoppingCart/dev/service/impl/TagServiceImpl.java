package com.FIS.OnlineShoppingCart.dev.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FIS.OnlineShoppingCart.dev.dao.TagDAO;
import com.FIS.OnlineShoppingCart.dev.entities.Tag;
import com.FIS.OnlineShoppingCart.dev.model.TagDTO;
import com.FIS.OnlineShoppingCart.dev.service.TagService;

@Transactional
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDAO tagDao;

    @Override
    public List<TagDTO> getAllTag() {
        List<Tag> listTag = tagDao.getAllTag();

        List<TagDTO> listTagDTO = new ArrayList<>();

        for(Tag t : listTag) {

            TagDTO tagDTO = new TagDTO();

            tagDTO.setId(t.getId());
            tagDTO.setType(t.getType());

            listTagDTO.add(tagDTO);
        }

        return listTagDTO;
    }

}
