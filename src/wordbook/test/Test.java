import wordbook.data.*;

public class Test {
    public static void main(String[] args) {

        new FirstTimeInitializer();
        Word word = new Word();
        String[][] a = {{"boy", "男孩"}, {"girl", "女孩"},
                {"sun", "太阳"}, {"moon", "月亮"},
                {"book", "书籍"}, {"water", "水"}
        };
        AddWord addWord = new AddWord();
        for (int i = 0; i < a.length; i++) {
            word.setEnglishWord(a[i][0]);
            word.setMeaning(a[i][1]);
            addWord.insertWord(word);
        }
        QuerySingleWord q = new QuerySingleWord();
        word.setEnglishWord("boy");
        Word re = q.queryOneWord(word);
        System.out.println("查询到的一个单词:");
        System.out.printf("%-10s", re.getEnglishWord());
        System.out.printf("%-10s\n", re.getMeaning());
        QueryAllWord query = new QueryAllWord();
        Word[] result = query.queryAllWord();
        System.out.println("全部单词:");
        input(result);
        RandomlyQuery random = new RandomlyQuery();
        random.setCount(3); //随机抽取3个单词
        result = random.randomQueryWord();
        System.out.println("随机抽取" + random.getCount() + "个单词:");

        input(result);
        UpdateWord update = new UpdateWord();
        word.setEnglishWord("book");
        word.setMeaning("n.书籍，卷，帐簿，名册，工作簿 vt.预订，登记");
        update.updateWord(word);
        DelWord del = new DelWord();
        word.setEnglishWord("boy");
        del.delWord(word);
        word.setEnglishWord("girl");
        del.delWord(word);
        System.out.println("更新、删除后全部单词:");
        query = new QueryAllWord();
        result = query.queryAllWord();

        //调用input方法输出全部单词
//        input(result);
    }

    // 在命令行中输出表中的所有单词
    static void input(Word[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-10s", result[i].getEnglishWord());
            System.out.printf("%-10s", result[i].getMeaning());
            System.out.println();
        }
    }
}