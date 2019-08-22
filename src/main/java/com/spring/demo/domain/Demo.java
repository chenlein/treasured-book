package com.spring.demo.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Demo
 * @Author leichen.china@gmail.com
 * @Date 2019-08-20 11:14
 * @Describe TODO
 */

@ApiModel("Demo实体类")
@Data
public class Demo extends BaseEntity implements Serializable {

    @TableId
    private String name;

    private String address;

    private Date birthday;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer isDel;

    @Version
    private Integer version;

}
