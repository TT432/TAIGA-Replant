package com.sosnitzka.taiga;


import com.sosnitzka.taiga.traits.*;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import static com.sosnitzka.taiga.Fluids.obsidioriteFluid;
import static slimeknights.tconstruct.tools.TinkerTraits.alien;
import static slimeknights.tconstruct.tools.TinkerTraits.crumbling;

public class MaterialTraits {

    // new hardness levels
    public static final int DURANITE = 5;
    public static final int VALYRIUM = 6;
    public static final int VIBRANIUM = 7;

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
    public static final AbstractTrait fragile = new TraitFragile();
    public static final AbstractTrait dissolving = new TraitDissolving();
    public static final AbstractTrait arcane = new TraitArcane();
    public static final AbstractTrait heroic = new TraitHeroic();
    public static final AbstractTrait hollow = new TraitHollow();
    public static final AbstractTrait diffuse = new TraitDiffuse();
    public static final AbstractTrait reviving = new TraitReviving();
    public static final AbstractTrait melting = new TraitMelting();
    public static final AbstractTrait traditional = new TraitTraditional();
    public static final AbstractTrait tantrum = new TraitTantrum();
    public static final AbstractTrait catcher = new TraitCatcher();
    public static final AbstractTrait congenial = new TraitCongenial();
    public static final AbstractTrait souleater = new TraitSoulEater();
    public static final AbstractTrait cursed = new TraitCursed();
    public static final AbstractTrait ported = new TraitPorted();
    public static final AbstractTrait decay = new TraitDecay();
    public static final AbstractTrait whirl = new TraitWhirl();
    public static final AbstractTrait superheavy = new TraitSuperHeavy();
    public static final AbstractTrait dev = new TraitDevelopement();
    public static final AbstractTrait carousel = new TraitCarousel();
    public static final AbstractTrait beserk = new TraitBeserk();
    public static final AbstractTrait leveled1 = new TraitLeveled(1);
    public static final AbstractTrait leveled2 = new TraitLeveled(2);
    public static final AbstractTrait leveled3 = new TraitLeveled(3);
    public static final AbstractTrait crushing = new TraitCrushing();
    public static final AbstractTrait mutate = new TraitMutate();


    /**
     * Assign traits to related materials. <br>
     * <p>
     * <p> Example:
     * .addTrait(x, HandleMaterialStats.TYPE).addTrait(y, HeadMaterialStats.TYPE)
     * .addTrait(z)
     */

    public static Material tiberium = new Material("tiberium", TextFormatting.GREEN).addTrait(instable);
    public static Material aurorium = new Material("aurorium", TextFormatting.RED).addTrait(arcane);
    public static Material prometheum = new Material("prometheum", TextFormatting.DARK_PURPLE).addTrait(blind, MaterialTypes.HANDLE).addTrait(catcher);
    public static Material duranite = new Material("duranite", TextFormatting.YELLOW).addTrait(analysing);
    public static Material valyrium = new Material("valyrium", TextFormatting.DARK_GRAY).addTrait(congenial);
    public static Material vibranium = new Material("vibranium", TextFormatting.GRAY).addTrait(resonance, MaterialTypes.HANDLE).addTrait(heroic, MaterialTypes.HEAD);
    public static Material terrax = new Material("terrax", TextFormatting.DARK_GRAY).addTrait(slaughtering);
    public static Material palladium = new Material("palladium", TextFormatting.GOLD).addTrait(dark).addTrait(cursed);
    public static Material uru = new Material("uru", TextFormatting.DARK_RED).addTrait(diffuse);
    public static Material basalt = new Material("basalt", TextFormatting.WHITE).addTrait(softy);
    public static Material eezo = new Material("eezo", TextFormatting.GOLD).addTrait(dissolving).addTrait(superheavy);
    public static Material triberium = new Material("triberium", TextFormatting.GREEN).addTrait(fragile);
    public static Material fractum = new Material("fractum", TextFormatting.DARK_RED).addTrait(fracture);
    public static Material violium = new Material("violium", TextFormatting.DARK_PURPLE).addTrait(arcane);
    public static Material proxii = new Material("proxii", TextFormatting.LIGHT_PURPLE).addTrait(curvature);
    public static Material tritonite = new Material("tritonite", TextFormatting.GOLD).addTrait(whirl);
    public static Material ignitz = new Material("ignitz", TextFormatting.RED).addTrait(melting).addTrait(garishly, MaterialTypes.HANDLE);
    public static Material imperomite = new Material("imperomite", TextFormatting.DARK_RED).addTrait(hollow);
    public static Material solarium = new Material("solarium", TextFormatting.YELLOW).addTrait(superheavy).addTrait(crushing);
    public static Material nihilite = new Material("nihilite", TextFormatting.DARK_GRAY).addTrait(souleater);
    public static Material adamant = new Material("adamant", TextFormatting.GOLD).addTrait(beserk).addTrait(leveled1, MaterialTypes.EXTRA).addTrait(leveled2, MaterialTypes.HANDLE).addTrait(leveled3, MaterialTypes.HEAD); //.addTrait(dev);
    public static Material dyonite = new Material("dyonite", TextFormatting.GREEN).addTrait(tantrum);
    public static Material nucleum = new Material("nucleum", TextFormatting.YELLOW).addTrait(decay).addTrait(mutate);
    public static Material lumix = new Material("lumix", TextFormatting.YELLOW).addTrait(bright, MaterialTypes.HANDLE).addTrait(glimmer, MaterialTypes.HEAD);
    public static Material seismum = new Material("seismum", TextFormatting.GREEN).addTrait(cascade);
    public static Material astrium = new Material("astrium", TextFormatting.DARK_PURPLE).addTrait(ported);
    public static Material niob = new Material("niob", TextFormatting.RED).addTrait(reviving);
    public static Material yrdeen = new Material("yrdeen", TextFormatting.RED).addTrait(naturebound);
    public static Material meteorite = new Material("meteorite", TextFormatting.DARK_GREEN).addTrait(crumbling, MaterialTypes.HEAD).addTrait(pulverizing);
    public static Material obsidiorite = new Material("obsidiorite", obsidioriteFluid.getColor()).addTrait(alien);

    public static Material osram = new Material("osram", TextFormatting.GOLD);
    public static Material abyssum = new Material("abyssum", TextFormatting.GOLD);
    public static Material iox = new Material("iox", TextFormatting.RED);
    public static Material ovium = new Material("ovium", TextFormatting.BLUE);
    public static Material jauxum = new Material("jauxum", TextFormatting.YELLOW);
    public static Material karmesine = new Material("karmesine", TextFormatting.RED);
    public static Material dilithium = new Material("dilithium", TextFormatting.BLUE);

}
