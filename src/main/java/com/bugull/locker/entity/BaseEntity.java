package com.bugull.locker.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-05 16:18
 **/
@Setter
@Getter
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 5490271191981379678L;

    private String id;

    private String createUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date createDate;

    private String modifyUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date modifyDate;

    private Integer version;

    private Integer status;

    private String remark;
}
