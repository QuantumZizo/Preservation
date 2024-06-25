package com.quantumzizo.preservation;

import com.mojang.logging.LogUtils;
import com.quantumzizo.preservation.registry.ModBlocks;
import com.quantumzizo.preservation.registry.ModDataComponents;
import com.quantumzizo.preservation.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(Preservation.MODID)
public class Preservation {
    public static final String MODID = "preservation";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Preservation(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDataComponents.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}