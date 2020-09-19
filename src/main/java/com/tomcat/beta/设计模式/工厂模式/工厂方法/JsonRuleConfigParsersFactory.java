package com.tomcat.beta.设计模式.工厂模式.工厂方法;

import com.tomcat.beta.设计模式.工厂模式.IRuleConfigParser;
import com.tomcat.beta.设计模式.工厂模式.简单工厂.JsonRuleConfigParser;

/**
 * Create by yuzhangbin on 2020/9/17
 */
public class JsonRuleConfigParsersFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
