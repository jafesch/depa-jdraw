package jdraw.figures.handles;

import jdraw.framework.FigureHandle;

import java.awt.*;

/**
 * Created by Julian on 01-Nov-16.
 */
public abstract class BaseFigureHandle implements FigureHandle {

	@Override
	public boolean contains(int x, int y) {
		return new Rectangle(getLocation().x - 3, getLocation().y - 3, 6, 6).contains(x, y);
	}
}
