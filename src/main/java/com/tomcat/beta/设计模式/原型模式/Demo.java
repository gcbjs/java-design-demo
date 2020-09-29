package com.tomcat.beta.设计模式.原型模式;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {

    private ConcurrentHashMap<String,SearchWord> currentKeywords = new ConcurrentHashMap<String, SearchWord>();
    private long lastUpdateTime = -1;

    public void refresh() {
        List<SearchWord> toBeUpdateSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;
        for (SearchWord searchWord:toBeUpdateSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }

            if (currentKeywords.contains(searchWord.getKeyWord())) {
                currentKeywords.replace(searchWord.getKeyWord(),searchWord);
            }else {
                currentKeywords.put(searchWord.getKeyWord(),searchWord);
            }

            lastUpdateTime = maxNewUpdateTime;
        }
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        //TODO 从数据库取出更新时间 > lastUpdateTime的数据
        return null;
    }
}
