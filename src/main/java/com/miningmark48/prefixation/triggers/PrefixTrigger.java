package com.miningmark48.prefixation.triggers;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixation.reference.Reference;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrefixTrigger implements ICriterionTrigger<PrefixTrigger.Instance> {

    private static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "prefix");
    private final Map<PlayerAdvancements, PrefixTrigger.Listeners> listeners = Maps.<PlayerAdvancements, PrefixTrigger.Listeners>newHashMap();

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void addListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener<PrefixTrigger.Instance> listener) {
        PrefixTrigger.Listeners consumeitemtrigger$listeners = this.listeners.get(playerAdvancementsIn);

        if (consumeitemtrigger$listeners == null) {
            consumeitemtrigger$listeners = new PrefixTrigger.Listeners(playerAdvancementsIn);
            this.listeners.put(playerAdvancementsIn, consumeitemtrigger$listeners);
        }

        consumeitemtrigger$listeners.add(listener);
    }

    @Override
    public void removeListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener<PrefixTrigger.Instance> listener) {
        PrefixTrigger.Listeners consumeitemtrigger$listeners = this.listeners.get(playerAdvancementsIn);

        if (consumeitemtrigger$listeners != null) {
            consumeitemtrigger$listeners.remove(listener);

            if (consumeitemtrigger$listeners.isEmpty()) {
                this.listeners.remove(playerAdvancementsIn);
            }
        }
    }

    @Override
    public void removeAllListeners(PlayerAdvancements playerAdvancementsIn) {
        this.listeners.remove(playerAdvancementsIn);
    }

    @Override
    public PrefixTrigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
        String prefix = JsonUtils.getString(json, "prefix");

        return new PrefixTrigger.Instance(prefix);
    }

    public static class Instance extends AbstractCriterionInstance {
        private final String prefix;

        public Instance(String prefix) {
            super(PrefixTrigger.ID);
            this.prefix = prefix;
        }

        public boolean test(String prefix_test) {
            return prefix_test.equalsIgnoreCase(this.prefix);
        }
    }

    public void trigger(EntityPlayerMP player, String prefix) {
        PrefixTrigger.Listeners listeners = this.listeners.get(player.getAdvancements());

        if (listeners != null) {
            listeners.trigger(player, prefix);
        }
    }

    static class Listeners {
        private final PlayerAdvancements playerAdvancements;
        private final Set<Listener<Instance>> listeners = Sets.newHashSet();

        public Listeners(PlayerAdvancements playerAdvancementsIn) {
            this.playerAdvancements = playerAdvancementsIn;
        }

        public boolean isEmpty() {
            return this.listeners.isEmpty();
        }

        public void add(ICriterionTrigger.Listener<PrefixTrigger.Instance> listener) {
            this.listeners.add(listener);
        }

        public void remove(ICriterionTrigger.Listener<PrefixTrigger.Instance> listener) {
            this.listeners.remove(listener);
        }

        public void trigger(EntityPlayerMP player, String prefix) {
            List<Listener<Instance>> list = null;

            for (ICriterionTrigger.Listener<PrefixTrigger.Instance> listener : this.listeners) {
                if (listener.getCriterionInstance().test(prefix)) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }

                    list.add(listener);
                }
            }

            if (list != null) {
                for (ICriterionTrigger.Listener<PrefixTrigger.Instance> listener1 : list) {
                    listener1.grantCriterion(this.playerAdvancements);
                }
            }
        }
    }

}
