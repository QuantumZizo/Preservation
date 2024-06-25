package com.quantumzizo.preservation.spoilage;

import com.quantumzizo.preservation.Preservation;
import com.quantumzizo.preservation.registry.ModBlocks;
import com.quantumzizo.preservation.registry.ModDataComponents;
import com.quantumzizo.preservation.spoilage.api.DefaultFoodFreshnessValue;
import com.quantumzizo.preservation.spoilage.api.FoodFreshnessRecord;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SpoilageProcessor {
    @SubscribeEvent
    private void attachFoodFreshness(ModifyDefaultComponentsEvent event) {
        int totalItemsAttached = 0;

        Set<Item> items = defaultFoodFreshnessValues.keySet();

        for (Item item: items) {
            event.modify(item, builder ->
                    builder.set(ModDataComponents.FOOD_FRESHNESS.get(), new FoodFreshnessRecord(getFreshnessValue(item), getSpoilageValue(item), false))
            );

            if (item.components().has(ModDataComponents.FOOD_FRESHNESS.value())) totalItemsAttached++;
        }

        Preservation.LOGGER.debug("Attached the freshness component to {} items.", totalItemsAttached);
    }

    private final Map<Item, DefaultFoodFreshnessValue> defaultFoodFreshnessValues = new HashMap<Item, DefaultFoodFreshnessValue>() {{
        put(Items.COOKED_BEEF, new DefaultFoodFreshnessValue(120, 36));
    }};


    private int getFreshnessValue(Item item) {
        return defaultFoodFreshnessValues.get(item).getDefaultFreshnessTime();
    }

    private int getSpoilageValue(Item item) {
        return defaultFoodFreshnessValues.get(item).getDefaultSpoilageTime();
    }

}
