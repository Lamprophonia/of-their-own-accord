package com.lamprophonia.otoa.registry;

import com.lamprophonia.otoa.OfTheirOwnAccord;
import com.lamprophonia.otoa.npc.HumanNpc;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Entity types and their default attributes, registered on the mod event bus.
 */
public final class ModEntityTypes {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, OfTheirOwnAccord.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<HumanNpc>> HUMAN =
            ENTITY_TYPES.register("human", id -> EntityType.Builder.<HumanNpc>of(HumanNpc::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F)
                    .eyeHeight(1.62F)
                    .clientTrackingRange(10)
                    .build(id.toString()));

    private ModEntityTypes() {
    }

    public static void register(IEventBus modBus) {
        ENTITY_TYPES.register(modBus);
        modBus.addListener(ModEntityTypes::registerAttributes);
    }

    private static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(HUMAN.get(), HumanNpc.createAttributes().build());
    }
}
