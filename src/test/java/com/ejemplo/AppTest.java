package com.ejemplo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testSumar() {
        App app = new App();
        assertEquals(5, app.sumar(2, 3));
    }
}
