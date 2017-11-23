package com.zachary_moore.gameoflife.model.pattern;


import com.zachary_moore.gameoflife.model.core.SingleCell;

public class SavedPattern {

    private SingleCell[][] patternRep;

    private String patternName;

    public SavedPattern(SingleCell[][] patternRep, String patternName) {
        this.patternRep = patternRep;
        this.patternName = patternName;
    }

    public String getPatternName() {
        return patternName;
    }

    public SingleCell[][] getPatternRep() {
        return patternRep;
    }



}
