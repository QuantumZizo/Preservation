package com.quantumzizo.preservation.registry;

import com.quantumzizo.preservation.Preservation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModBlocks {
    private ModBlocks() {}

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Preservation.MODID);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
