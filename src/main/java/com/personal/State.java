package com.personal;

import java.awt.image.BufferedImage;
import java.util.Objects;

public class State {
    private final BufferedImage baseImage;
    private final int hue;

    public State(BufferedImage baseImage, int hue) {
        this.baseImage = baseImage;
        this.hue = hue;
    }

    public BufferedImage getBaseImage() {
        return baseImage;
    }

    public int getHue() {
        return hue;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        State state = (State) object;
        return hue == state.hue && Objects.equals(baseImage, state.baseImage);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), baseImage, hue);
    }
}
