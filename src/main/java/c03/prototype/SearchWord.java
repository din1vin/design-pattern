package c03.prototype;

public class SearchWord {
    private String word;
    private long lastModify;
    private int searchTimes;

    public SearchWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public long getLastModify() {
        return lastModify;
    }

    public void setLastModify(long lastModify) {
        this.lastModify = lastModify;
    }

    public int getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(int searchTimes) {
        this.searchTimes = searchTimes;
    }
}
