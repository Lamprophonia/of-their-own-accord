package com.lamprophonia.otoa;

import com.lamprophonia.otoa.registry.ModEntityTypes;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

/**
 * Common mod entry point, constructed by NeoForge on clients and dedicated servers.
 * Keep client presentation code in separate, client-only classes when it is needed.
 */
@Mod(OfTheirOwnAccord.MOD_ID)
public final class OfTheirOwnAccord {
    // This must match mod_id in gradle.properties.
    public static final String MOD_ID = "otoa";

    private static final Logger LOGGER = LogUtils.getLogger();

    public OfTheirOwnAccord(IEventBus modBus) {
        ModEntityTypes.register(modBus);
        LOGGER.info("Of Their Own Accord ({}) initialized.", MOD_ID);
    }
}
