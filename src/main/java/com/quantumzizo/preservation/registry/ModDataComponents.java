package com.quantumzizo.preservation.registry;

import com.quantumzizo.preservation.Preservation;
import com.quantumzizo.preservation.spoilage.api.FoodFreshnessRecord;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModDataComponents {
    private ModDataComponents() {}

    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Preservation.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<FoodFreshnessRecord>> FOOD_FRESHNESS = DATA_COMPONENTS
            .registerComponentType("food_freshness", builder -> builder.persistent(FoodFreshnessRecord.CODEC).networkSynchronized(FoodFreshnessRecord.STREAM_CODEC));

    public static void register(IEventBus modEventBus) {
        DATA_COMPONENTS.register(modEventBus);
    }
}
