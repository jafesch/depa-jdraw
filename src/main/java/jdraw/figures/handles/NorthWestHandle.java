package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Julian on 01-Nov-16.
 */
public class NorthWestHandle extends BaseFigureHandle {

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

	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		corner = new Point(r.x + r.width, r.y + r.height);
	}

	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}
}