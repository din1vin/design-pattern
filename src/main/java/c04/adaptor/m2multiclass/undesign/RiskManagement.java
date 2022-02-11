package c04.adaptor.m2multiclass.undesign;

public class RiskManagement {
    private ASensitiveWordsFilter aSensitiveWordsFilter;
    private BSensitiveWordsFilter bSensitiveWordsFilter;
    private CSensitiveWordsFilter cSensitiveWordsFilter;

    public RiskManagement(ASensitiveWordsFilter aSensitiveWordsFilter, BSensitiveWordsFilter bSensitiveWordsFilter,
                          CSensitiveWordsFilter cSensitiveWordsFilter) {
        this.aSensitiveWordsFilter = aSensitiveWordsFilter;
        this.bSensitiveWordsFilter = bSensitiveWordsFilter;
        this.cSensitiveWordsFilter = cSensitiveWordsFilter;
    }

    public String filterSensitiveWords(String text) {
        String maskText = aSensitiveWordsFilter.filterPoliticalWords(text);
        maskText = aSensitiveWordsFilter.filterSexyWords(maskText);
        maskText = bSensitiveWordsFilter.filter(maskText);
        maskText = cSensitiveWordsFilter.filter(maskText);
        return maskText;
    }
}
