package com.quantumzizo.preservation.registry;

import com.quantumzizo.preservation.Preservation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {
    private ModItems() {}

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Preservation.MODID);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
