package com.swx.sapiinterface.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName toxic_soups
 */
@TableName(value ="toxic_soups")
@Data
public class ToxicSoups implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 
     */
    private String data;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}