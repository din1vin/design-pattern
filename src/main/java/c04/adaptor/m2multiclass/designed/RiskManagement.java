package c04.adaptor.m2multiclass.designed;

import java.util.ArrayList;
import java.util.List;

public class RiskManagement {
    private final List<SensitiveWordsFilter> sensitiveWordsFilterList = new ArrayList<>();

    public RiskManagement() {
    }

    public void addFilter(SensitiveWordsFilter sensitiveWordsFilter) {
        sensitiveWordsFilterList.add(sensitiveWordsFilter);
    }


    public String filterWords(String text) {
        for (SensitiveWordsFilter sensitiveWordsFilter : sensitiveWordsFilterList) {
            text = sensitiveWordsFilter.filter(text);
        }
        return text;
    }
}
