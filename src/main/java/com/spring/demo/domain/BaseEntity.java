package com.spring.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName BaseEntity
 * @Author leichen.china@gmail.com
 * @Date 2019-08-21 15:38
 * @Describe TODO
 */
@Data
public class BaseEntity {

    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private String userId;

}
