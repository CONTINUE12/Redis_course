package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//企业开发中，所有的pojo类都会序列化（Serializable）
public class User implements Serializable {

    private String name;
    private int age;

}
