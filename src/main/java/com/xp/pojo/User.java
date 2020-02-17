package com.xp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @DateTimeFormat(pattern = "yyyy-mm-dd") //接收指定格式日期
    private Date date;
    private Integer id;
    private String name;
    private Integer age;
}
