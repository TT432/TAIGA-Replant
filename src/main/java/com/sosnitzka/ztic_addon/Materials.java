package com.sosnitzka.ztic_addon;


import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

import static com.sosnitzka.ztic_addon.ZTiC.*;
import static slimeknights.tconstruct.tools.TinkerMaterials.enderference;

public class Materials {
    public static Material arcanite = new Material("arcanite", TextFormatting.LIGHT_PURPLE).addTrait(arcane, HeadMaterialStats.TYPE).addTrait(blind);
    public static Material tiberium = new Material("tiberium", TextFormatting.GREEN).addTrait(instable);
    public static Material prometheum = new Material("prometheum", TextFormatting.DARK_PURPLE).addTrait(haunted, HeadMaterialStats.TYPE).addTrait(blind);
    public static Material rubium = new Material("rubium", TextFormatting.RED).addTrait(enderference, HeadMaterialStats.TYPE).addTrait(blind);
    public static Material violium = new Material("violium", TextFormatting.DARK_GREEN).addTrait(analysing);
    public static Material bismuth = new Material("bismuth", TextFormatting.DARK_GREEN);
    public static Material karmesine = new Material("karmesine", TextFormatting.DARK_GREEN);
    public static Material mindorite = new Material("mindorite", TextFormatting.DARK_GREEN);
    public static Material titanite = new Material("titanite", TextFormatting.GRAY);
    public static Material meteorite = new Material("meteorite", TextFormatting.GRAY);
    public static Material adamantite = new Material("adamantite", TextFormatting.GRAY);
    public static Material vibranium = new Material("vibranium", TextFormatting.GRAY).addTrait(resonance);
    public static Material ignitite = new Material("ignitite", TextFormatting.AQUA);
    public static Material palladium = new Material("palladium", TextFormatting.AQUA);
    public static Material eternite = new Material("eternite", TextFormatting.AQUA);
    public static Material mythril = new Material("mythril", TextFormatting.GRAY).addTrait(pulverizing, HeadMaterialStats.TYPE).addTrait(bentonite, HandleMaterialStats.TYPE);

    public static Material astrium = new Material("astrium", TextFormatting.LIGHT_PURPLE);
    public static Material nitronite = new Material("nitronite", TextFormatting.LIGHT_PURPLE);
    public static Material proxideum = new Material("proxideum", TextFormatting.LIGHT_PURPLE);
    public static Material noctunyx = new Material("noctunyx", TextFormatting.LIGHT_PURPLE);
    public static Material imperomite = new Material("imperomite", TextFormatting.DARK_GREEN).addTrait(heroic);
    public static Material cryptogen = new Material("cryptogen", TextFormatting.DARK_GREEN);
    public static Material fractoryte = new Material("fractoryte", TextFormatting.DARK_RED).addTrait(frature, HeadMaterialStats.TYPE).addTrait(fragile);
    public static Material seismodium = new Material("seismodium", TextFormatting.DARK_GREEN).addTrait(cascade, HeadMaterialStats.TYPE).addTrait(fragile);
    public static Material terramite = new Material("terramite", TextFormatting.GRAY);
    public static Material lumixyl = new Material("lumixyl", TextFormatting.YELLOW).addTrait(glimmer);
    public static Material solarium = new Material("solarium", TextFormatting.RED).addTrait(garishly);
    public static Material dyonite = new Material("dyonite", TextFormatting.GRAY).addTrait(slaughtering, HeadMaterialStats.TYPE).addTrait(dissolving);
    public static Material ultranite = new Material("ultranite", TextFormatting.AQUA);
    public static Material nucleum = new Material("nucleum", TextFormatting.AQUA);
    public static Material aegisalt = new Material("aegisalt", TextFormatting.AQUA);
    public static Material bysmuid = new Material("bysmuid", TextFormatting.AQUA);
}
