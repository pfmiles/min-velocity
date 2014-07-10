package com.github.pfmiles.minvelocity;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import junit.framework.TestCase;

/**
 * @author pf-miles
 * 
 */
public class ImplHelperTest extends TestCase {

    public void testFlowing() throws IOException {
        StringReader from = new StringReader("1234567890");
        StringWriter to = new StringWriter();
        int bufferSize = 0;
        int totalSize = 0;
        ImplHelper.flowing(from, to, bufferSize, totalSize);
        assertTrue("1234567890".equals(to.toString()));

        bufferSize = 3;
        totalSize = 9;
        from = new StringReader("1234567890");
        to = new StringWriter();
        ImplHelper.flowing(from, to, bufferSize, totalSize);
        assertTrue("123456789".equals(to.toString()));

        bufferSize = 3;
        totalSize = 7;
        from = new StringReader("1234567890");
        to = new StringWriter();
        ImplHelper.flowing(from, to, bufferSize, totalSize);
        assertTrue("123456789".equals(to.toString()));
    }
}
