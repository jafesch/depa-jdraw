package jdraw.test;

import jdraw.figures.decorator.BorderDecorator;
import jdraw.framework.Figure;
import org.junit.Before;

/**
 * Created by Julian on 26-Jan-17.
 */
public class BorderRectangleTest {
    private Figure f;
    private int cnt;

    @Before
    public void setUp() {
        f = new BorderDecorator(new jdraw.figures.Rect(0, 0, 20, 10));
        cnt = 0;
    }
}
