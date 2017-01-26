package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFigure implements Figure {

	private final List<FigureListener> listeners = new ArrayList<>();

	@Override
	public void addFigureListener(FigureListener listener) {
		if (listener != null && !listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	@Override
	public void removeFigureListener(FigureListener listener) {
		listeners.remove(listener);
	}

	protected void notifyListeners(Figure f) {
		FigureEvent figureEvent = new FigureEvent(f);
		for (FigureListener listener : new ArrayList<>(listeners)) {
			listener.figureChanged(figureEvent);
		}
	}

	public Figure clone() throws CloneNotSupportedException { throw new CloneNotSupportedException(); }
}
