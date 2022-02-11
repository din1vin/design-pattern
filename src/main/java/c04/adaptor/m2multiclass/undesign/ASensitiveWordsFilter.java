package c04.adaptor.m2multiclass.undesign;

public class ASensitiveWordsFilter {
    /**
     * 过滤色情词汇
     *
     * @param text 原始文本
     * @return 用**替换的文本
     */
    public String filterSexyWords(String text) {
        return text.replaceAll("(性感|荷官).+", "**");
    }

    /**
     * 过滤政治敏感词
     *
     * @param text 原始文本
     * @return ** 替换敏感词
     */
    public String filterPoliticalWords(String text) {
        return text.replaceAll("(外交|资本)","**");
    }
}


