package com.tomcat.beta.设计模式.工厂模式.工厂方法;

import com.tomcat.beta.设计模式.工厂模式.IRuleConfigParser;

/**
 * Create by yuzhangbin on 2020/9/17
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
