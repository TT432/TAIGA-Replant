package com.sosnitzka.taiga.traits.abs;

import com.sosnitzka.taiga.keys.KeyServer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

/**
 * @author DustW
 */
public abstract class AbstractKeyBindTrait extends AbstractTrait {
    public AbstractKeyBindTrait(String identifier, TextFormatting color) {
        super(identifier, color);
    }

    public AbstractKeyBindTrait(String identifier, int color) {
        super(identifier, color);
    }

    public static boolean canActive(AbstractTrait trait, ItemStack tool) {
        return TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), trait.identifier) && KeyServer.alt.isDown();
    }

    protected boolean canActive(ItemStack tool) {
        return TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier) && KeyServer.alt.isDown();
    }
}
