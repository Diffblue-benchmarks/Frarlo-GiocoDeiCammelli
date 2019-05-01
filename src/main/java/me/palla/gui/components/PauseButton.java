package me.palla.gui.components;

import me.palla.GiocoPalla;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PauseButton extends BaseGuiComponent {

    private int rectColor;
    private int strokeColor;

    private final Collection<Runnable> actionListeners;

    public PauseButton(Runnable... actionListeners) {
        this.actionListeners = new ArrayList<>();
        Collections.addAll(this.actionListeners, actionListeners);

        rectColor = new Color(0xFF42a4f4, true).getRGB();
        strokeColor = new Color(0xFFD9D9D9, true).getRGB();
    }

    @Override
    public void onRender() {
        GiocoPalla.getInstance().pushStyle();

        GiocoPalla.getInstance().fill(rectColor);
        GiocoPalla.getInstance().stroke(strokeColor);
        GiocoPalla.getInstance().strokeWeight(2.5F);

        GiocoPalla.getInstance().rect(x, y, width, height, 10);

        GiocoPalla.getInstance().fill(strokeColor);
        GiocoPalla.getInstance().strokeWeight(1);

        final float topPadding = height / 4;
        final float strokeWidth = width / 6;
        final float leftPadding = height / 4;

        GiocoPalla.getInstance().rect(x + leftPadding, y + topPadding, strokeWidth, height - topPadding * 2);
        GiocoPalla.getInstance().rect(x + width - strokeWidth - leftPadding, y + topPadding, strokeWidth, height - topPadding * 2);

        GiocoPalla.getInstance().popStyle();
    }

    @Override
    public void onClick(float xPos, float yPos) {
        actionListeners.forEach(Runnable::run);
    }

    // Action Listeners

    public void addActionListener(Runnable listener) {
        actionListeners.add(listener);
    }

    public void removeActionListener(Runnable listener) {
        actionListeners.remove(listener);
    }
}