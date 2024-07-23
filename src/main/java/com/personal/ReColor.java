package com.personal;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReColor {
    private static final Predicate<Color> mask = c -> c.getAlpha() > 200 && c.getGreen() > 150;
    static final List<Color> rainbowColors = new ArrayList<>(){{
        for (int i = 0; i < Constant.HUE_COARSENESS; i++) {
            float hue = (float) 1/Constant.HUE_COARSENESS * i;
            int rgb = Color.HSBtoRGB(hue, 1.0f, 1.0f);
            add(new Color(rgb));
        }
    }};

    public static BufferedImage recolor(BufferedImage in, int newColor){
        int xSize = in.getWidth();
        int ySize = in.getHeight();

        BufferedImage out = new BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                Color originalColor = new Color(in.getRGB(i, j), true);
                if (mask.test(originalColor)){
                    out.setRGB(i, j, getRgbForHue(newColor));
                }else {
                    out.setRGB(i, j, originalColor.getRGB());
                }
            }
        }
        return out;
    }

    private static int getRgbForHue(int hue) {
        return rainbowColors.get(hue - 1).getRGB();
    }
}
