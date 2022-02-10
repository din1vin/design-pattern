package c03.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 需求: 五分钟更新searchWords,要求原子性更新,意思是currentWords不存在部分更新
 * 说明: 假设SearchWords创建比较复杂.
 */
public class SearchWordsUpdate {
    private Map<String, SearchWord> currentWords = new HashMap<>();
    private long lastModify;

    public void refresh() {
        List<SearchWord> searchWords = getSearchWords(lastModify);
        HashMap<String, SearchWord> newWords = new HashMap<>(currentWords); // shadow copy

        long maxUpdateTime = lastModify;
        for (SearchWord searchWord : searchWords) {
            if (searchWord.getSearchTimes() > maxUpdateTime) {
                maxUpdateTime = searchWord.getSearchTimes();
            }
            newWords.remove(searchWord.getWord());
            newWords.put(searchWord.getWord(), searchWord);

        }
        lastModify = maxUpdateTime;
        currentWords = newWords;
    }

    private List<SearchWord> getSearchWords(long lastModify) {
        // TODO select search_words from search_records where last_modify > ${lastModify}
        return null;
    }
}
