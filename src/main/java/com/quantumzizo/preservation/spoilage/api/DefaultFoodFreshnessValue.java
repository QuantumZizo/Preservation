package com.quantumzizo.preservation.spoilage.api;

import net.minecraft.world.item.Item;

public class DefaultFoodFreshnessValue {;
    private final int f;
    private final int s;

    public DefaultFoodFreshnessValue(int defaultFreshnessTime, int defaultSpoilageTime) {
        f = defaultFreshnessTime;
        s = defaultSpoilageTime;
    }

    public int getDefaultFreshnessTime() {
        return f;
    }

    public int getDefaultSpoilageTime() {
        return s;
    }
}