package com.spring.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.demo.domain.Demo;
import com.spring.demo.mapper.DemoMapper;
import com.spring.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName DemoServiceImpl
 * @Author leichen.china@gmail.com
 * @Date 2019-08-20 11:06
 * @Describe TODO
 */

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper mapper;

    @Override
    public IPage<Demo> showDemo() {
        return this.mapper.showDemo(new Page<>());
    }

    @Override
    public Integer createDemo(Demo demo) {
        return this.mapper.insert(demo);
    }

    @Override
    public Integer updateDemo(Demo demo) {
        return this.mapper.updateById(demo);
    }

    @Override
    public Integer deleteDemo(Demo demo) {
        return this.mapper.deleteById(demo);
    }

}
