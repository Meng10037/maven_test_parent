package com.study.dao;

import com.study.domain.Items;

// dao层用Mapper配置文件配置了,不能再用@Repository咯,当初的教训(死活想不明白哪来的两个AccountDao)
public interface ItemsDao {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    Items findById(Integer id);

}
