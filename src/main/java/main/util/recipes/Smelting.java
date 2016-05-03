package main.util.recipes;


import main.ZCompression;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.RandomUtils;

public class Smelting {
    public Smelting(){
        register();
    }

    private void register(){
        GameRegistry.addSmelting(ZCompression.slagironOre, new ItemStack(ZCompression.slagironIngot),1.0F);
        GameRegistry.addSmelting(new ItemStack(ZCompression.slagironIngot, 3),new ItemStack(ZCompression.iron_nugget), 0);
        GameRegistry.addSmelting(new ItemStack(ZCompression.slaggoldIngot, 3),new ItemStack(Items.GOLD_NUGGET), 0);

        GameRegistry.addSmelting(ZCompression.aardiumOre, new ItemStack(ZCompression.aardiumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.arcaniteOre, new ItemStack(ZCompression.arcaniteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.adamantiteOre, new ItemStack(ZCompression.adamantiteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.axiidianOre, new ItemStack(ZCompression.axiidianIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.bismuthOre, new ItemStack(ZCompression.bismuthIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.eterniteOre, new ItemStack(ZCompression.eterniteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.ignititeOre, new ItemStack(ZCompression.ignititeIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.karmesineOre, new ItemStack(ZCompression.karmesineIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.meteoriteOre, new ItemStack(ZCompression.meteoriteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.mindoriteOre, new ItemStack(ZCompression.mindoriteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.mythrilOre, new ItemStack(ZCompression.mythrilIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.palladiumOre, new ItemStack(ZCompression.palladiumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.prometheumOre, new ItemStack(ZCompression.prometheumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.tiberiumOre, new ItemStack(ZCompression.tiberiumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.vibraniumOre, new ItemStack(ZCompression.vibraniumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ZCompression.yrdeanOre, new ItemStack(ZCompression.yrdeanIngot), RandomUtils.nextFloat(0F, 2F));

    }
}
