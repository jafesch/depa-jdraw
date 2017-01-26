package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Julian on 01-Nov-16.
 */
public class SouthWestHandle extends BaseFigureHandle {

	public SouthWestHandle(Figure owner) {
		this.owner = owner;
	}

	@Override
	public Figure getOwner() { return owner; }

	@Override
	public Point getLocation() {
		Rectangle bounds = owner.getBounds();
		return new Point(bounds.x, bounds.y + bounds.height);
	}

	@Override
	public void draw(Graphics g) {
		Point loc = getLocation();
		g.setColor(Color.RED); g.fillRect(loc.x - 3, loc.y - 3, 6, 6);
		g.setColor(Color.BLACK); g.drawRect(loc.x - 3, loc.y - 3, 6, 6);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
	}

	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		corner = new Point(r.x + r.width, r.y);
	}

	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}

}