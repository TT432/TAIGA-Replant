package com.sosnitzka.ztic_addon;


import com.sosnitzka.ztic_addon.generic.BasicTinkerFluid;
import com.sosnitzka.ztic_addon.util.Utils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class Fluids {

    public static BasicTinkerFluid arcaniteFluid = new BasicTinkerFluid("arcanite", 0xFF272354, true, 200, 10, 4000);
    public static BasicTinkerFluid aardiumFluid = new BasicTinkerFluid("aardium", 0xFFC3F93D, true, 200, 10, 4000);
    public static BasicTinkerFluid adamantiteFluid = new BasicTinkerFluid("adamantite", 0xFFc45c82, true, 200, 10, 4000);
    public static BasicTinkerFluid axiidianFluid = new BasicTinkerFluid("axiidian", 0xFF77a19a, true, 200, 10, 4000);
    public static BasicTinkerFluid bismuthFluid = new BasicTinkerFluid("bismuth", 0xFF555555, true, 200, 10, 4000);
    public static BasicTinkerFluid eterniteFluid = new BasicTinkerFluid("eternite", 0xFFfafa98, true, 200, 10, 4000);
    public static BasicTinkerFluid ignititeFluid = new BasicTinkerFluid("ignitite", 0xFFd29453, true, 200, 10, 4000);
    public static BasicTinkerFluid karmesineFluid = new BasicTinkerFluid("karmesine", 0xFFc16d6d, true, 200, 10, 4000);
    public static BasicTinkerFluid meteoriteFluid = new BasicTinkerFluid("meteorite", 0xFF6e6a62, true, 200, 10, 4000);
    public static BasicTinkerFluid mindoriteFluid = new BasicTinkerFluid("mindorite", 0xFF6bbbbf, true, 200, 10, 4000);
    public static BasicTinkerFluid mythrilFluid = new BasicTinkerFluid("mythril", 0xFFa8c0ba, true, 200, 10, 4000);
    public static BasicTinkerFluid palladiumFluid = new BasicTinkerFluid("palladium", 0xFFfe5c05, true, 200, 10, 4000);
    public static BasicTinkerFluid prometheumFluid = new BasicTinkerFluid("prometheum", 0xFF2b282f, true, 200, 10, 4000);
    public static BasicTinkerFluid tiberiumFluid = new BasicTinkerFluid("tiberium", 0xFF86bd5a, true, 200, 10, 4000);
    public static BasicTinkerFluid vibraniumFluid = new BasicTinkerFluid("vibranium", 0xFFb6bba8, true, 200, 10, 4000);
    public static BasicTinkerFluid yrdeanFluid = new BasicTinkerFluid("yrdean", 0xFF3e3c6f, true, 200, 10, 4000);

    public static BasicTinkerFluid astriumFluid = new BasicTinkerFluid("astrium", 0xFF7a3b74, true, 200, 10, 4000);
    public static BasicTinkerFluid instableNitroniteFluid = new BasicTinkerFluid("instable_nitronite", 0xFF659933, true, 200, 10, 4000);
    public static BasicTinkerFluid proxideumFluid = new BasicTinkerFluid("proxideum", 0xFF416565, true, 200, 10, 4000);
    public static BasicTinkerFluid instablePolyniumFluid = new BasicTinkerFluid("instablePolynium", 0xFF6c6aa3, true, 200, 10, 4000);
    public static BasicTinkerFluid imperomiteFluid = new BasicTinkerFluid("imperomite", 0xFF339966, true, 200, 10, 4000);
    public static BasicTinkerFluid cryptogenFluid = new BasicTinkerFluid("cryptogen", 0xFF9f8a4a, true, 200, 10, 4000);
    public static BasicTinkerFluid fractoryteFluid = new BasicTinkerFluid("fractoryte", 0xFFb44a14, true, 200, 10, 4000);
    public static BasicTinkerFluid seismodiumFluid = new BasicTinkerFluid("seismodium", 0xFF46131D, true, 200, 10, 4000);
    public static BasicTinkerFluid terramiteFluid = new BasicTinkerFluid("terramite", 0xFFa6b27a, true, 200, 10, 4000);
    public static BasicTinkerFluid instablePrysociteFluid = new BasicTinkerFluid("instable_prysocite", 0xFFbde398, true, 200, 10, 4000);
    public static BasicTinkerFluid blazingXylititeFluid = new BasicTinkerFluid("blazing_xylitite", 0xFFffc81d, true, 200, 10, 4000);
    public static BasicTinkerFluid instableDyoniteFluid = new BasicTinkerFluid("instable_dyonite", 0xFFff6743, true, 200, 10, 4000);
    public static BasicTinkerFluid ultraniteFluid = new BasicTinkerFluid("ultranite", 0xFFfff69b, true, 200, 10, 4000);
    public static BasicTinkerFluid radiantPliniumFluid = new BasicTinkerFluid("radiant_plinium", 0xFFc1ff68, true, 200, 10, 4000);
    public static BasicTinkerFluid dysprosaniumFluid = new BasicTinkerFluid("dysprosanium", 0xFFb7a2bd, true, 200, 10, 4000);
    public static BasicTinkerFluid refractiveBysmuidFluid = new BasicTinkerFluid("refractive_bysmuid", 0xFF7b97b0, true, 200, 10, 4000);


    static void register() {
        Field[] declaredFields = Fluids.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                Class<?> targetType = field.getType();
                try {
                    BasicTinkerFluid fluid = (BasicTinkerFluid) field.get(targetType);

                    Utils.registerTinkerFluid(StringUtils.capitalize(fluid.getName()), fluid, fluid.isToolForge());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
