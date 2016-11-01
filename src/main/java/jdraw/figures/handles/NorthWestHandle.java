package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Julian on 01-Nov-16.
 */
public class NorthWestHandle extends BaseFigureHandle {
	private Figure owner;

	public NorthWestHandle(Figure owner) {
		this.owner = owner;
	}

	@Override
	public Figure getOwner() { return owner; }

	@Override
	public Point getLocation() {
		return owner.getBounds().getLocation();
	}

	@Override
	public void draw(Graphics g) {
		Point loc = getLocation();
		g.setColor(Color.WHITE); g.fillRect(loc.x - 3, loc.y - 3, 6, 6);
		g.setColor(Color.BLACK); g.drawRect(loc.x - 3, loc.y - 3, 6, 6);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
	}

	@Override
	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {

	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {

	}

	@Override
	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {

	}
}