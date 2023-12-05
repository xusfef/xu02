package com.oak.system.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test_emp")
public class InfoEmp {

    @TableId(type = IdType.AUTO)
    @ExcelProperty("序号")
    private Integer id;

    @ExcelProperty("姓名")
    private String empName;

    @ExcelProperty("性别")
    private String sex;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty(value = "部门")
    private String deptName;

    @ExcelProperty("学历")
    private String empDegreeName;
}
