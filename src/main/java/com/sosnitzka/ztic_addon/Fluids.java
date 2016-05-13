package com.sosnitzka.ztic_addon;


import com.sosnitzka.ztic_addon.generic.BasicTinkerFluid;
import com.sosnitzka.ztic_addon.util.Utils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Fluids {

    public static BasicTinkerFluid arcaniteFluid = new BasicTinkerFluid("arcanite_fluid", 0xFF272354, true, 200, 10, 4000);
    public static BasicTinkerFluid aardiumFluid = new BasicTinkerFluid("aardium_fluid", 0xFFC3F93D, true, 200, 10, 4000);
    public static BasicTinkerFluid adamantiteFluid = new BasicTinkerFluid("adamantite_fluid", 0xFFc45c82, true, 200, 10, 4000);
    public static BasicTinkerFluid axiidianFluid = new BasicTinkerFluid("axiidian_fluid", 0xFF77a19a, true, 200, 10, 4000);
    public static BasicTinkerFluid bismuthFluid = new BasicTinkerFluid("bismuth_fluid", 0xFF555555, true, 200, 10, 4000);
    public static BasicTinkerFluid eterniteFluid = new BasicTinkerFluid("eternite_fluid", 0xFFfafa98, true, 200, 10, 4000);
    public static BasicTinkerFluid ignititeFluid = new BasicTinkerFluid("ignitite_fluid", 0xFFd29453, true, 200, 10, 4000);
    public static BasicTinkerFluid karmesineFluid = new BasicTinkerFluid("karmesine_fluid", 0xFFc16d6d, true, 200, 10, 4000);
    public static BasicTinkerFluid meteoriteFluid = new BasicTinkerFluid("meteorite_fluid", 0xFF6e6a62, true, 200, 10, 4000);
    public static BasicTinkerFluid mindoriteFluid = new BasicTinkerFluid("mindorite_fluid", 0xFF6bbbbf, true, 200, 10, 4000);
    public static BasicTinkerFluid mythrilFluid = new BasicTinkerFluid("mythril_fluid", 0xFFa8c0ba, true, 200, 10, 4000);
    public static BasicTinkerFluid palladiumFluid = new BasicTinkerFluid("palladium_fluid", 0xFFfe5c05, true, 200, 10, 4000);
    public static BasicTinkerFluid prometheumFluid = new BasicTinkerFluid("prometheum_fluid", 0xFF2b282f, true, 200, 10, 4000);
    public static BasicTinkerFluid tiberiumFluid = new BasicTinkerFluid("tiberium_fluid", 0xFF86bd5a, true, 200, 10, 4000);
    public static BasicTinkerFluid vibraniumFluid = new BasicTinkerFluid("vibranium_fluid", 0xFFb6bba8, true, 200, 10, 4000);
    public static BasicTinkerFluid yrdeanFluid = new BasicTinkerFluid("yrdean_fluid", 0xFF3e3c6f, true, 200, 10, 4000);

    public static BasicTinkerFluid astriumFluid = new BasicTinkerFluid("astrium_fluid", 0xFF7a3b74, true, 200, 10, 4000);
    public static BasicTinkerFluid instableNitroniteFluid = new BasicTinkerFluid("instableNitronite_fluid", 0xFF659933, true, 200, 10, 4000);
    public static BasicTinkerFluid proxideumFluid = new BasicTinkerFluid("proxideum_fluid", 0xFF416565, true, 200, 10, 4000);
    public static BasicTinkerFluid instablePolyniumFluid = new BasicTinkerFluid("instablePolynium_fluid", 0xFF6c6aa3, true, 200, 10, 4000);
    public static BasicTinkerFluid imperomiteFluid = new BasicTinkerFluid("imperomite_fluid", 0xFF339966, true, 200, 10, 4000);
    public static BasicTinkerFluid cryptogenFluid = new BasicTinkerFluid("cryptogen_fluid", 0xFF9f8a4a, true, 200, 10, 4000);
    public static BasicTinkerFluid fractoryteFluid = new BasicTinkerFluid("fractoryte_fluid", 0xFFb44a14, true, 200, 10, 4000);
    public static BasicTinkerFluid seismodiumFluid = new BasicTinkerFluid("seismodium_fluid", 0xFF46131D, true, 200, 10, 4000);
    public static BasicTinkerFluid terramiteFluid = new BasicTinkerFluid("terramite_fluid", 0xFFa6b27a, true, 200, 10, 4000);
    public static BasicTinkerFluid instablePrysociteFluid = new BasicTinkerFluid("instablePrysocite_fluid", 0xFFbde398, true, 200, 10, 4000);
    public static BasicTinkerFluid blazingXylititeFluid = new BasicTinkerFluid("blazingXylitite_fluid", 0xFFffc81d, true, 200, 10, 4000);
    public static BasicTinkerFluid instableDyoniteFluid = new BasicTinkerFluid("instableDyonite_fluid", 0xFFff6743, true, 200, 10, 4000);
    public static BasicTinkerFluid ultraniteFluid = new BasicTinkerFluid("ultranite_fluid", 0xFFfff69b, true, 200, 10, 4000);
    public static BasicTinkerFluid radiantPliniumFluid = new BasicTinkerFluid("radiantPlinium_fluid", 0xFFc1ff68, true, 200, 10, 4000);
    public static BasicTinkerFluid dysprosaniumFluid = new BasicTinkerFluid("dysprosanium_fluid", 0xFFb7a2bd, true, 200, 10, 4000);
    public static BasicTinkerFluid refractiveBysmuidFluid = new BasicTinkerFluid("refractiveBysmuid_fluid", 0xFF7b97b0, true, 200, 10, 4000);


    static void register() {
        Field[] declaredFields = Fluids.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                Class<?> targetType = field.getType();
                try {
                    BasicTinkerFluid fluid = (BasicTinkerFluid) field.get(targetType);

                    String oreDictName;
                    String[] nameParts = fluid.getName().split("_");

                    if (nameParts.length > 2) {
                        oreDictName = Arrays.toString(Arrays.copyOfRange(nameParts, 0, nameParts.length - 1));
                    } else {
                        oreDictName = nameParts[0];
                    }

                    Utils.registerTinkerFluid("fluid" + StringUtils.capitalize(oreDictName), fluid, fluid.isToolForge());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
