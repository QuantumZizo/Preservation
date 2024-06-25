package com.quantumzizo.preservation.spoilage;

import com.quantumzizo.preservation.Preservation;
import com.quantumzizo.preservation.registry.ModDataComponents;
import com.quantumzizo.preservation.spoilage.api.DefaultFoodFreshnessValue;
import com.quantumzizo.preservation.spoilage.api.FoodFreshnessRecord;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SpoilageProcessor {
    @SubscribeEvent
    public static void attachFoodFreshness(ModifyDefaultComponentsEvent event) {
        int totalItemsAttached = 0;

        Set<Item> items = defaultFoodFreshnessValues.keySet();

        for (Item item: items) {
            event.modify(item, builder ->
                    builder.set(ModDataComponents.FOOD_FRESHNESS.get(), new FoodFreshnessRecord(getFreshnessValue(item), getSpoilageValue(item), false))
            );

            if (item.components().has(ModDataComponents.FOOD_FRESHNESS.get())) totalItemsAttached++;
        }

        Preservation.LOGGER.info("Attached freshness component to {} item(s).", totalItemsAttached);
    }

    private static final Map<Item, DefaultFoodFreshnessValue> defaultFoodFreshnessValues = new HashMap<>() {{
        put(Items.COOKED_BEEF, new DefaultFoodFreshnessValue(120, 36));
    }};

    private static int getFreshnessValue(Item item) {
        return defaultFoodFreshnessValues.get(item).getDefaultFreshnessTime();
    }

    private static int getSpoilageValue(Item item) {
        return defaultFoodFreshnessValues.get(item).getDefaultSpoilageTime();
    }
}
