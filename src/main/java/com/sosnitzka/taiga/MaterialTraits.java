package com.sosnitzka.taiga;


import com.sosnitzka.taiga.traits.*;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import static slimeknights.tconstruct.tools.TinkerTraits.*;

public class MaterialTraits {

    // new hardness levels
    public static final int TITANITE = 5;
    public static final int METEORITE = 6;
    public static final int VIBRANIUM = 7;
    public static final int ADAMANTITE = 8;

    // Init of new traits
    public static final AbstractTrait instable = new TraitInstable();
    public static final AbstractTrait naturebound = new TraitNatureBound();
    public static final AbstractTrait uncertain = new TraitUncertain();
    public static final AbstractTrait softy = new TraitSofty();
    public static final AbstractTrait curvature = new TraitCurvature();
    public static final AbstractTrait resonance = new TraitResonance();
    public static final AbstractTrait fracture = new TraitFracture();
    public static final AbstractTrait glimmer = new TraitGlimmer();
    public static final AbstractTrait garishly = new TraitGarishly();
    public static final AbstractTrait pulverizing = new TraitPulverizing();
    public static final AbstractTrait analysing = new TraitAnalysing();
    public static final AbstractTrait cascade = new TraitCascade();
    public static final AbstractTrait blind = new TraitBlind();
    public static final AbstractTrait dark = new TraitDark();
    public static final AbstractTrait bright = new TraitBright();
    public static final AbstractTrait slaughtering = new TraitSlaughtering();
    public static final AbstractTrait haunted = new TraitHaunted();
    public static final AbstractTrait fragile = new TraitFragile();
    public static final AbstractTrait dissolving = new TraitDissolving();
    public static final AbstractTrait organizing = new TraitOrganizing();
    public static final AbstractTrait arcane = new TraitArcane();
    public static final AbstractTrait heroic = new TraitHeroic();
    public static final AbstractTrait hollow = new TraitHollow();
    public static final AbstractTrait diffuse = new TraitDiffuse();
    public static final AbstractTrait randomize = new TraitRandomize();
    public static final AbstractTrait reviving = new TraitReviving();
    public static final AbstractTrait melting = new TraitMelting();
    public static final AbstractTrait traditional = new TraitTraditional();


    public static Material arcanite = new Material("arcanite", TextFormatting.LIGHT_PURPLE).addTrait(arcane, MaterialTypes.HEAD).addTrait(blind, MaterialTypes.HANDLE);
    public static Material tiberium = new Material("tiberium", TextFormatting.GREEN).addTrait(instable);
    public static Material prometheum = new Material("prometheum", TextFormatting.DARK_PURPLE).addTrait(haunted, MaterialTypes.HEAD).addTrait(blind);
    public static Material rubium = new Material("rubium", TextFormatting.RED).addTrait(enderference, MaterialTypes.HEAD).addTrait(blind);
    public static Material violium = new Material("violium", TextFormatting.DARK_GREEN).addTrait(stonebound, MaterialTypes.HANDLE).addTrait(poisonous, MaterialTypes.HEAD);
    public static Material bismuth = new Material("bismuth", TextFormatting.GREEN).addTrait(splintering, MaterialTypes.HEAD).addTrait(splinters, MaterialTypes.HANDLE);
    public static Material karmesine = new Material("karmesine", TextFormatting.DARK_RED).addTrait(aridiculous, MaterialTypes.HANDLE).addTrait(superheat, MaterialTypes.HEAD);
    public static Material mindorite = new Material("mindorite", TextFormatting.AQUA).addTrait(cheap);
    public static Material titanite = new Material("titanite", TextFormatting.GRAY).addTrait(shocking, MaterialTypes.HANDLE).addTrait(sharp, MaterialTypes.HEAD);
    public static Material meteorite = new Material("meteorite", TextFormatting.GRAY).addTrait(established, MaterialTypes.HANDLE).addTrait(momentum, MaterialTypes.HEAD);
    public static Material adamantite = new Material("adamantite", TextFormatting.GRAY).addTrait(coldblooded, MaterialTypes.HEAD).addTrait(magnetic, MaterialTypes.HANDLE);
    public static Material vibranium = new Material("vibranium", TextFormatting.GRAY).addTrait(resonance);
    public static Material ignitite = new Material("ignitite", TextFormatting.RED).addTrait(melting, MaterialTypes.HANDLE).addTrait(flammable, MaterialTypes.HEAD);
    public static Material palladium = new Material("palladium", TextFormatting.DARK_GRAY).addTrait(dark);
    public static Material eternite = new Material("eternite", TextFormatting.AQUA).addTrait(writable2); //.addTrait(traditional)
    public static Material mythril = new Material("mythril", TextFormatting.GRAY).addTrait(holy, MaterialTypes.HEAD).addTrait(hellish, MaterialTypes.HANDLE);
    public static Material imperomite = new Material("imperomite", TextFormatting.DARK_RED).addTrait(cascade);
    public static Material fractoryte = new Material("fractoryte", TextFormatting.DARK_RED).addTrait(fracture);
    public static Material noctunyx = new Material("noctunyx", TextFormatting.LIGHT_PURPLE).addTrait(hollow, MaterialTypes.HEAD).addTrait(reviving, MaterialTypes.HANDLE);
    public static Material nitronite = new Material("nitronite", TextFormatting.YELLOW).addTrait(uncertain);
    public static Material cryptogen = new Material("cryptogen", TextFormatting.DARK_GREEN).addTrait(randomize);
    public static Material seismodium = new Material("seismodium", TextFormatting.WHITE).addTrait(heroic).addTrait(fragile);
    public static Material aegisalt = new Material("aegisalt", TextFormatting.AQUA).addTrait(analysing);
    public static Material ultranite = new Material("ultranite", TextFormatting.AQUA).addTrait(pulverizing);
    public static Material bysmuid = new Material("bysmuid", TextFormatting.AQUA).addTrait(organizing, MaterialTypes.HANDLE).addTrait(melting, MaterialTypes.HEAD);
    public static Material nucleum = new Material("nucleum", TextFormatting.AQUA).addTrait(diffuse).addTrait(bright, MaterialTypes.HEAD);
    public static Material lumixyl = new Material("lumixyl", TextFormatting.YELLOW).addTrait(glimmer);
    public static Material dyonite = new Material("dyonite", TextFormatting.GRAY).addTrait(slaughtering, MaterialTypes.HEAD).addTrait(dissolving, MaterialTypes.HANDLE);
    public static Material terramite = new Material("terramite", TextFormatting.GRAY).addTrait(naturebound).addTrait(fragile);
    public static Material solarium = new Material("solarium", TextFormatting.RED).addTrait(garishly);
    public static Material astrium = new Material("astrium", TextFormatting.DARK_PURPLE).addTrait(curvature);
    public static Material proxideum = new Material("proxideum", TextFormatting.LIGHT_PURPLE).addTrait(softy, MaterialTypes.HANDLE).addTrait(lightweight);
}
