package com.tomcat.beta.设计模式.工厂模式.简单工厂;

import com.tomcat.beta.设计模式.工厂模式.IRuleConfigParser;
import com.tomcat.beta.设计模式.工厂模式.RuleConfig;

/**
 * 简单工厂方法
 * Create by yuzhangbin on 2020/9/21
 */
public class SimpleFactoryDemo {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser iRuleConfigParser = createParser(ruleConfigFileExtension);
        if (iRuleConfigParser == null) {
            return null;
        }
        String configText = "";
        RuleConfig parse = iRuleConfigParser.parse(configText);
        return parse;
    }

    private IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            return parser = new JsonRuleConfigParser();
        }else if ("xml".equalsIgnoreCase(configFormat)) {
            return parser = new XmlRuleConfigParser();
        }else if ("yaml".equalsIgnoreCase(configFormat)) {
            return new YamlRuleConfigParser();
        }else if ("properties".equalsIgnoreCase(configFormat)) {
            return new PropertiesRuleConfigParser();
        }
        return parser;
    }

    private String getFileExtension(String ruleConfigFilePath) {
        return "json";
    }
}
