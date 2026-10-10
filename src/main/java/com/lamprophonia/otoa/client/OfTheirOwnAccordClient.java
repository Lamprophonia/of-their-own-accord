package com.lamprophonia.otoa.client;

import com.lamprophonia.otoa.OfTheirOwnAccord;
import com.lamprophonia.otoa.client.renderer.HumanNpcRenderer;
import com.lamprophonia.otoa.registry.ModEntityTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * Client-only entry point for presentation registration.
 */
@Mod(value = OfTheirOwnAccord.MOD_ID, dist = Dist.CLIENT)
public final class OfTheirOwnAccordClient {
    public OfTheirOwnAccordClient(IEventBus modBus) {
        modBus.addListener(OfTheirOwnAccordClient::registerRenderers);
    }

    private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.HUMAN.get(), HumanNpcRenderer::new);
    }
}
