package com.oak.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("test_dict")
public class Dict {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String type;

    private String name;

    private Integer value;

    private Integer sort;

}
