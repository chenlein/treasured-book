package com.spring.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.spring.demo.domain.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DemoMapper extends BaseMapper<Demo> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<Demo> showDemo(IPage<Demo> page);

}
