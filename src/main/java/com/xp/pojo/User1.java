package com.xp.pojo;

import com.alibaba.fastjson.annotation.JSONField;
    import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User1 {
//    @JsonFormat(pattern = "yyyy-mm-dd") //jackson的格式化注解
    @JSONField(format = "yyyy-mm-dd") //fastjson的格式化注解
    private Date date;
    private Integer id;
    private String name;
    private Integer age;
}
