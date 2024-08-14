package com.swx.sapiinterface.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName lovetalk
 */
@TableName(value ="lovetalk")
@Data
public class Lovetalk implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String data;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}