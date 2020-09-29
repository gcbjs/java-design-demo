package com.tomcat.beta.设计模式.原型模式;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SearchWord {

    private String keyWord;

    private long count;

    private long lastUpdateTime;
}
