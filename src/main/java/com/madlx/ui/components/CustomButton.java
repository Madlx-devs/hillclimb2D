package com.madlx.ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/** *
 * this is AI generated Custom button
 * because I suck at ui and all
 * so let the Ai handle the UI stuffs
 */
public class CustomButton extends JComponent {

    private String label;
    private Color baseColor;
    private boolean hovered = false;
    private boolean pressed = false;
    private List<ActionListener> listeners = new ArrayList<>();

    public CustomButton(String label, Color baseColor) {
        this.label = label;
        this.baseColor = baseColor;
        setPreferredSize(new Dimension(300, 60));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e)  { fireActionPerformed(); }
            @Override public void mouseEntered(MouseEvent e)  { hovered = true;  repaint(); }
            @Override public void mouseExited(MouseEvent e)   { hovered = false; repaint(); }
            @Override public void mousePressed(MouseEvent e)  { pressed = true;  repaint(); }
            @Override public void mouseReleased(MouseEvent e) { pressed = false; repaint(); }
        });
    }

    public void addActionListener(ActionListener l) { listeners.add(l); }

    private void fireActionPerformed() {
        ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, label);
        listeners.forEach(l -> l.actionPerformed(e));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int w =100;
        final int h = 30;
        final int arc = 20; // fully rounded ends
        int shadowOffset = 3;
        int borderThickness = 2;

        Color color = pressed ? baseColor.darker() : hovered ? baseColor.brighter() : baseColor;
        Color borderColor = color.darker().darker();
        Color shadowColor = new Color(0, 0, 0, 60);

        // 1. Drop shadow
        g2.setColor(shadowColor);
        g2.fillRoundRect(shadowOffset, shadowOffset, w - shadowOffset, h - shadowOffset + 4, arc, arc);

        // 2. Dark border (gives the "rim" look)
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, w - shadowOffset, h, arc, arc);

        // 3. Main button body
        g2.setColor(color);
        g2.fillRoundRect(borderThickness, borderThickness,
                w - shadowOffset - borderThickness * 2,
                h - borderThickness * 2, arc, arc);

        // 4. Gloss sheen (top highlight)
        if (!pressed) {
            int sheenH = h / 3;
            GradientPaint gloss = new GradientPaint(
                    0, borderThickness,
                    new Color(255, 255, 255, 120),
                    0, borderThickness + sheenH,
                    new Color(255, 255, 255, 0)
            );
            g2.setPaint(gloss);
            // clip to button shape so gloss doesn't bleed out
            g2.setClip(new java.awt.geom.RoundRectangle2D.Float(
                    borderThickness, borderThickness,
                    w - shadowOffset - borderThickness * 2,
                    h - borderThickness * 2, arc, arc));
            g2.fillRect(borderThickness, borderThickness,
                    w - shadowOffset - borderThickness * 2, sheenH);
            g2.setClip(null);
        }
        // 5. Label
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g2.getFontMetrics();
        int tx = (w - shadowOffset - fm.stringWidth(label)) / 2;
        int ty = (h + fm.getAscent() - fm.getDescent()) / 2;
        // subtle text shadow
        g2.setColor(new Color(0, 0, 0, 80));
        g2.drawString(label, tx + 1, ty + 1);
        g2.setColor(Color.WHITE);
        g2.drawString(label, tx, ty);

        g2.dispose();
    }
}