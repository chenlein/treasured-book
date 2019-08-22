package com.spring.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.spring.demo.domain.Demo;
import com.spring.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Author leichen.china@gmail.com
 * @Date 2019-08-20 10:52
 * @Describe TODO
 */

@RestController
public class DemoController {

    @Autowired
    private DemoService service;

    @RequestMapping(path = "/showDemo")
    public ResponseEntity<IPage<Demo>> showDemo() {
        return new ResponseEntity<>(this.service.showDemo(), HttpStatus.OK);
    }

    @RequestMapping(path = "/createDemo")
    public ResponseEntity<Integer> createDemo(@RequestBody Demo demo) {
        return new ResponseEntity<>(this.service.createDemo(demo), HttpStatus.OK);
    }

    @RequestMapping(path = "/updateDemo")
    public ResponseEntity<Integer> updateDemo(@RequestBody Demo demo) {
        System.out.println(demo.getUserId());
        return new ResponseEntity<>(this.service.updateDemo(demo), HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteDemo")
    public ResponseEntity<Integer> deleteDemo(@RequestBody Demo demo) {
        return new ResponseEntity<>(this.service.deleteDemo(demo), HttpStatus.OK);
    }

}
