package com.tomcat.beta.设计模式.原型模式;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class DemoV1 {

    private HashMap<String,SearchWord> currentKeywords = new HashMap<String, SearchWord>();

    private long lastUpdateTime = -1;

    public void refresh() {
        //Deep copy
        HashMap<String,SearchWord> newKeyWords = new HashMap<String, SearchWord>();

        for (HashMap.Entry<String,SearchWord> e:currentKeywords.entrySet()) {
            SearchWord searchWord = e.getValue();
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyWord(),searchWord.getCount(),searchWord.getLastUpdateTime());
            newKeyWords.put(e.getKey(),newSearchWord);
        }

        //从数据库取出更新时间lastUpdateTime的数据，放入到newKeywords
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord:toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeyWords.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeyWords.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            }else {
                newKeyWords.put(searchWord.getKeyWord(),searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeyWords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        return null;
    }

    //先将对象序列化，然后再反序列化成新的对象
    public Object deepCopy(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(object);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
