package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Julian on 01-Nov-16.
 */
public abstract class BaseFigureHandle implements FigureHandle {
	protected Figure owner;
	protected Point corner;

	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		owner.setBounds(new Point(x, y), corner);
	}

	@Override
	public boolean contains(int x, int y) {
		return new Rectangle(getLocation().x - 3, getLocation().y - 3, 6, 6).contains(x, y);
	}
}
