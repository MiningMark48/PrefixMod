package com.miningmark48.prefixation.init;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixation.triggers.PrefixTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModTriggers {

    private static Method CriterionRegister;

    public static void init() {
        Advancements.prefix = (PrefixTrigger) registerAdvancementTrigger(new PrefixTrigger());
    }

    public static <T extends ICriterionInstance> ICriterionTrigger<T> registerAdvancementTrigger(ICriterionTrigger<T> trigger) {
        if(CriterionRegister == null) {
            CriterionRegister = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a", ICriterionTrigger.class);
            CriterionRegister.setAccessible(true);
        }
        try {
            trigger = (ICriterionTrigger<T>) CriterionRegister.invoke(null, trigger);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            ModLogger.info("Failed to register trigger " + trigger.getId() + "!");
            e.printStackTrace();
        }
        return trigger;
    }

    public static class Advancements {
        public static PrefixTrigger prefix;
    }

}
