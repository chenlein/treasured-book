package com.spring.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.spring.demo.domain.Demo;

/**
 * @ClassName DemoService
 * @Author leichen.china@gmail.com
 * @Date 2019-08-20 11:06
 * @Describe TODO
 */
public interface DemoService {

    IPage<Demo> showDemo();

    Integer createDemo(Demo demo);

    Integer updateDemo(Demo demo);

    Integer deleteDemo(Demo demo);

}
