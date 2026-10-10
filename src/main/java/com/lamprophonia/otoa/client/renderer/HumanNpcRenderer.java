package com.lamprophonia.otoa.client.renderer;

import com.lamprophonia.otoa.npc.HumanNpc;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * Displays human NPCs with Minecraft's standard wide player model and Steve skin.
 */
public final class HumanNpcRenderer extends MobRenderer<HumanNpc, PlayerModel<HumanNpc>> {
    private static final ResourceLocation STEVE_TEXTURE =
            ResourceLocation.withDefaultNamespace("textures/entity/player/wide/steve.png");

    public HumanNpcRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(HumanNpc npc) {
        return STEVE_TEXTURE;
    }
}
