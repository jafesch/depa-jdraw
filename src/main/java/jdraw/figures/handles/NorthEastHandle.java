package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Julian on 01-Nov-16.
 */
public class NorthEastHandle extends BaseFigureHandle {

	public NorthEastHandle(Figure owner) {
		this.owner = owner;
	}

	@Override
	public Figure getOwner() { return owner; }

	@Override
	public Point getLocation() {
		Rectangle bounds = owner.getBounds();
		return new Point(bounds.x + bounds.width, bounds.y);
	}

	@Override
	public void draw(Graphics g) {
		Point loc = getLocation();
		g.setColor(Color.BLUE); g.fillRect(loc.x - 3, loc.y - 3, 6, 6);
		g.setColor(Color.BLACK); g.drawRect(loc.x - 3, loc.y - 3, 6, 6);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
	}

	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		corner = new Point(r.x, r.y + r.height);
	}

	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}

}