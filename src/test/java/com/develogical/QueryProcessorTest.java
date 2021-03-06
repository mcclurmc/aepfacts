package com.develogical;

import org.junit.Assert;
import org.junit.Test;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    @Test
    public void powersTest() {
        String result = new QueryProcessor().process("123123:what is 12 to the power of 13");
        assertNotNull(result);
        assertThat(result, is("106993205379072"));
    }

    @Test
    public void canGreetYou() {
        String result = new QueryProcessor().process("123123:which of the following numbers is the largest : 23,43,4,86 ");
        assertNotNull(result);
        assertThat(result, is("86"));
    }

    @Test
     public void fibs() {
        String result = new QueryProcessor().process("123123: what is the 4th number in the Fibonacci sequence");
        assertNotNull(result);
        assertThat(result, is("3"));
    }

    @Test
    public void isCubeAndSquare() {
        String result = new QueryProcessor().process("123123:which of the following numbers is both a square and a cube : 1,3,1000000,1024");
        assertNotNull(result);
        assertThat(result, is("1,1000000"));
    }

    @Test
    public void whoPlayedJamesBondInDrNo() {
        String result = new QueryProcessor().process("123123:who played James Bond in the film Dr No");
        assertNotNull(result);
        assertThat(result, is("Sean Connery"));
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

    @Test
    public void returnsPlusResult_13_9_plus_5_eq_22() {
        String result = new QueryProcessor().process("what is 13 plus 9 plus 5");
        assertNotNull(result);
        assertThat(result, is("27"));
    }

    @Test
    public void returnsMinusResult_13_9_eq_4() {
        String result = new QueryProcessor().process("what is 13 minus 9");
        assertNotNull(result);
        assertThat(result, is("4"));
    }

    @Test
    public void returnsMultResult_4_times_3() {
        String result = new QueryProcessor().process("what is 4 multiplied by 3");
        assertNotNull(result);
        assertThat(result, is("12"));
    }

    @Test
    public void primes() {
        String result = new QueryProcessor().process("02837:which of the following numbers are primes: 3, 345, 5, 13");
        assertNotNull(result);
        assertThat(result, is("3,5,13"));
    }

    @Test
    public void plusAndMult() {
        String result = new QueryProcessor().process("66106940: what is 6 plus 18 multiplied by 16");
        assertNotNull(result);
        assertThat(result, is("294"));
    }
}



