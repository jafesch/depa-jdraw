package jdraw.figures.decorator;

import jdraw.figures.Rect;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.util.List;

/**
 * Created by Julian on 26-Jan-17.
 */
public class BorderDecorator extends DecoratorFigure {
    private static final int BORDER_OFFSET = 5;

    public BorderDecorator(Figure figure) {
        super(figure);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Rectangle r = getBounds();
        g.setColor(Color.white);
        g.drawLine(r.x, r.y, r.x, r.y+ r.height);
        g.drawLine(r.x, r.y, r.x+ r.width, r.y);
        g.setColor(Color.gray);
        g.drawLine(r.x+ r.width, r.y, r.x+ r.width, r.y+ r.height);
        g.drawLine(r.x, r.y+ r.height, r.x+ r.width, r.y+ r.height);
    }

    @Override
    public void move(int dx, int dy) {
        inner.move(dx, dy);
    }

    @Override
    public boolean contains(int x, int y) {
        return getBounds().contains(x, y);
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        inner.setBounds(origin, corner);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle r = inner.getBounds();
        r.grow(BORDER_OFFSET, BORDER_OFFSET);
        return r;
    }

    @Override
    public List<FigureHandle> getHandles() {
        return null;
    }
}
