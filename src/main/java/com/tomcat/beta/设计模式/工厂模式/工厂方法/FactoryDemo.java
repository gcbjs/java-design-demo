package com.tomcat.beta.设计模式.工厂模式.工厂方法;

import com.tomcat.beta.设计模式.工厂模式.IRuleConfigParser;
import com.tomcat.beta.设计模式.工厂模式.RuleConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法为了减少if判断逻辑
 * Create by yuzhangbin on 2020/9/21
 */
public class FactoryDemo {

    private static final Map<String,IRuleConfigParserFactory> map = new HashMap<>();

    static {
        map.put("json",new JsonRuleConfigParsersFactory());
        map.put("xml",new XmlRuleConfigParsersFactory());
        map.put("yaml",new YamlRuleConfigParsersFactory());
    }


    public RuleConfig load(String ruleConfigFilePath) {
        String extension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory iRuleConfigParserFactory = map.get(extension);
        if (iRuleConfigParserFactory == null) {
            return null;
        }
        String configText ="";
        IRuleConfigParser parser = iRuleConfigParserFactory.createParser();
        return parser.parse(configText);
    }

    private String getFileExtension(String ruleConfigFilePath) {
        return "json";
    }
}
