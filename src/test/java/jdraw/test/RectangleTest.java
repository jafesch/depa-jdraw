package jdraw.test;

import jdraw.figures.BaseFigure;
import jdraw.figures.Rect;

public class RectangleTest extends BaseFigureTest {

	@Override
	BaseFigure createFigure() {
		return new Rect(0, 0, 20, 10);
	}

}
