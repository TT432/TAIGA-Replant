package com.sosnitzka.ztic_addon.main.util.recipes;


import com.sosnitzka.ztic_addon.main.ZTiC;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.RandomUtils;

public class Smelting {
    public Smelting(){
        register();
    }

    private void register(){
        GameRegistry.addSmelting(ZTiC.slagironOre, new ItemStack(ZTiC.slagironIngot), 1.0F);
        GameRegistry.addSmelting(new ItemStack(ZTiC.slagironIngot, 3), new ItemStack(ZTiC.iron_nugget), 0);
        GameRegistry.addSmelting(new ItemStack(ZTiC.slaggoldIngot, 3), new ItemStack(Items.GOLD_NUGGET), 0);
        GameRegistry.addSmelting(new ItemStack(ZTiC.tiberiumShardInstable), new ItemStack(ZTiC.tiberiumShardStable), 0.2F);


        GameRegistry.addSmelting(ZTiC.aardiumOre, new ItemStack(ZTiC.aardiumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.arcaniteOre, new ItemStack(ZTiC.arcaniteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.adamantiteOre, new ItemStack(ZTiC.adamantiteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.axiidianOre, new ItemStack(ZTiC.axiidianIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.bismuthOre, new ItemStack(ZTiC.bismuthIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.eterniteOre, new ItemStack(ZTiC.eterniteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.ignititeOre, new ItemStack(ZTiC.ignititeIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.karmesineOre, new ItemStack(ZTiC.karmesineIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.meteoriteOre, new ItemStack(ZTiC.meteoriteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.mindoriteOre, new ItemStack(ZTiC.mindoriteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.mythrilOre, new ItemStack(ZTiC.mythrilIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.palladiumOre, new ItemStack(ZTiC.palladiumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.prometheumOre, new ItemStack(ZTiC.prometheumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.tiberiumOre, new ItemStack(ZTiC.tiberiumShardStable, 2), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.vibraniumOre, new ItemStack(ZTiC.vibraniumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZTiC.yrdeanOre, new ItemStack(ZTiC.yrdeanIngot), RandomUtils.nextFloat(0F, 2F));

    }
}
