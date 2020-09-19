package com.tomcat.beta.设计模式.工厂模式.工厂方法;

import com.tomcat.beta.设计模式.工厂模式.IRuleConfigParser;
import com.tomcat.beta.设计模式.工厂模式.简单工厂.YamlRuleConfigParser;

/**
 * Create by yuzhangbin on 2020/9/17
 */
public class YamlRuleConfigParsersFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
