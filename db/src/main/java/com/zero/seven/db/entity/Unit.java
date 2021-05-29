package com.zero.seven.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("s_unit")
public class Unit {

    @TableId(type = IdType.AUTO)
    private int id;

    private String name;

    private int age;
}
