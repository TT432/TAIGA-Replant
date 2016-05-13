package com.sosnitzka.ztic_addon;


import com.sosnitzka.ztic_addon.generic.BasicTinkerFluid;
import com.sosnitzka.ztic_addon.util.Utils;
import net.minecraftforge.fluids.Fluid;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class Fluids {

    public static Fluid arcaniteFluid = new BasicTinkerFluid("arcaniteFluid", 0xFF272354, true, 200, 10, 4000);
    public static Fluid aardiumFluid = new BasicTinkerFluid("aardiumFluid", 0xFFC3F93D, true, 200, 10, 4000);
    public static Fluid adamantiteFluid = new BasicTinkerFluid("adamantiteFluid", 0xFFc45c82, true, 200, 10, 4000);
    public static Fluid axiidianFluid = new BasicTinkerFluid("axiidianFluid", 0xFF77a19a, true, 200, 10, 4000);
    public static Fluid bismuthFluid = new BasicTinkerFluid("bismuthFluid", 0xFF555555, true, 200, 10, 4000);
    public static Fluid eterniteFluid = new BasicTinkerFluid("eterniteFluid", 0xFFfafa98, true, 200, 10, 4000);
    public static Fluid ignititeFluid = new BasicTinkerFluid("ignititeFluid", 0xFFd29453, true, 200, 10, 4000);
    public static Fluid karmesineFluid = new BasicTinkerFluid("karmesineFluid", 0xFFc16d6d, true, 200, 10, 4000);
    public static Fluid meteoriteFluid = new BasicTinkerFluid("meteoriteFluid", 0xFF6e6a62, true, 200, 10, 4000);
    public static Fluid mindoriteFluid = new BasicTinkerFluid("mindoriteFluid", 0xFF6bbbbf, true, 200, 10, 4000);
    public static Fluid mythrilFluid = new BasicTinkerFluid("mythrilFluid", 0xFFa8c0ba, true, 200, 10, 4000);
    public static Fluid palladiumFluid = new BasicTinkerFluid("palladiumFluid", 0xFFfe5c05, true, 200, 10, 4000);
    public static Fluid prometheumFluid = new BasicTinkerFluid("prometheumFluid", 0xFF2b282f, true, 200, 10, 4000);
    public static Fluid tiberiumFluid = new BasicTinkerFluid("tiberiumFluid", 0xFF86bd5a, true, 200, 10, 4000);
    public static Fluid vibraniumFluid = new BasicTinkerFluid("vibraniumFluid", 0xFFb6bba8, true, 200, 10, 4000);
    public static Fluid yrdeanFluid = new BasicTinkerFluid("yrdeanFluid", 0xFF3e3c6f, true, 200, 10, 4000);

    public static Fluid astriumFluid = new BasicTinkerFluid("astriumFluid", 0xFF7a3b74, true, 200, 10, 4000);
    public static Fluid instableNitroniteFluid = new BasicTinkerFluid("instableNitroniteFluid", 0xFF659933, true, 200, 10, 4000);
    public static Fluid proxideumFluid = new BasicTinkerFluid("proxideumFluid", 0xFF416565, true, 200, 10, 4000);
    public static Fluid instablePolyniumFluid = new BasicTinkerFluid("instablePolyniumFluid", 0xFF6c6aa3, true, 200, 10, 4000);
    public static Fluid imperomiteFluid = new BasicTinkerFluid("imperomiteFluid", 0xFF339966, true, 200, 10, 4000);
    public static Fluid cryptogenFluid = new BasicTinkerFluid("cryptogenFluid", 0xFF9f8a4a, true, 200, 10, 4000);
    public static Fluid fractoryteFluid = new BasicTinkerFluid("fractoryteFluid", 0xFFb44a14, true, 200, 10, 4000);
    public static Fluid seismodiumFluid = new BasicTinkerFluid("seismodiumFluid", 0xFF46131D, true, 200, 10, 4000);
    public static Fluid terramiteFluid = new BasicTinkerFluid("terramiteFluid", 0xFFa6b27a, true, 200, 10, 4000);
    public static Fluid instablePrysociteFluid = new BasicTinkerFluid("instablePrysociteFluid", 0xFFbde398, true, 200, 10, 4000);
    public static Fluid blazingXylititeFluid = new BasicTinkerFluid("blazingXylititeFluid", 0xFFffc81d, true, 200, 10, 4000);
    public static Fluid instableDyoniteFluid = new BasicTinkerFluid("instableDyoniteFluid", 0xFFff6743, true, 200, 10, 4000);
    public static Fluid ultraniteFluid = new BasicTinkerFluid("ultraniteFluid", 0xFFfff69b, true, 200, 10, 4000);
    public static Fluid radiantPliniumFluid = new BasicTinkerFluid("radiantPliniumFluid", 0xFFc1ff68, true, 200, 10, 4000);
    public static Fluid dysprosaniumFluid = new BasicTinkerFluid("dysprosaniumFluid", 0xFFb7a2bd, true, 200, 10, 4000);
    public static Fluid refractiveBysmuidFluid = new BasicTinkerFluid("refractiveBysmuidFluid", 0xFF7b97b0, true, 200, 10, 4000);


    static void register() {
        Field[] declaredFields = Fluids.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                Class<?> targetType = field.getType();
                try {
                    Object newInstance = targetType.newInstance();
                    BasicTinkerFluid fluid = (BasicTinkerFluid) field.get(newInstance);
                    Utils.registerTinkerFluid(StringUtils.capitalize(field.getName().replace("Fluid", "")), fluid, fluid.isToolForge());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
