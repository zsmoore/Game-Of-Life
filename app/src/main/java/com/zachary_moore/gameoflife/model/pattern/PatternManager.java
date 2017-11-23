package com.zachary_moore.gameoflife.model.pattern;

import java.util.ArrayList;

public class PatternManager {

    private ArrayList<SavedPattern> patterns;

    public PatternManager() {
        this.patterns = new ArrayList<>();
    }

    public void addPattern(SavedPattern toAdd) {
        patterns.add(toAdd);
    }
}
