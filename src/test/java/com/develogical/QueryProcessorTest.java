package com.develogical;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class QueryProcessorTest {

    @Test
    public void canGreetYou() {
        String result = new QueryProcessor().process("hi");
        assertNotNull(result);
        assertThat(result, is("hello"));
    }

    @Test
    public void returnsEmptyStringForUnknownQueries() {
        String result = new QueryProcessor().process("unknown");
        assertNotNull(result);
        assertThat(result, is(""));
    }

    @Test
    public void returnsPlusResult_13_9_eq_22() {
        String result = new QueryProcessor().process("what is 13 plus 9");
        assertNotNull(result);
        assertThat(result, is("22"));
    }
}



