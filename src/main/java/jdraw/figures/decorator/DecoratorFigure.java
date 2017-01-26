package jdraw.figures.decorator;

import jdraw.figures.BaseFigure;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Julian on 26-Jan-17.
 */
public abstract class DecoratorFigure extends BaseFigure {
    Figure inner;
    private List<FigureHandle> handles;

    public DecoratorFigure(Figure figure) {
        this.inner = figure;
    }

    public Figure getDecoratedFigure() {
        return inner;
    }

    @Override
    public void draw(Graphics g) {
        inner.draw(g);
    }

    @Override
    public DecoratorFigure clone() {
        try {
            DecoratorFigure f = (DecoratorFigure) super.clone();
            f.inner = (Figure) inner.clone();
            f.handles = null;
            return f;
        } catch (CloneNotSupportedException e){
            throw new InternalError(e);
        }
    }

}
