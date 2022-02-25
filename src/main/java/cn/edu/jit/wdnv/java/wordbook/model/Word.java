package cn.edu.jit.wdnv.java.wordbook.model;
/**
 * 定义 单词类
 * get set方法
 */

public class Word {
    String englishWord;     //单词
    String meaning;         //解释

    //获取单词
    public String getEnglishWord() {
        return englishWord;
    }

    //设置单词
    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    //获取解释
    public String getMeaning() {
        return meaning;
    }

    //设置解释
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
