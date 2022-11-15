package com.ktb;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.Timestamp;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.getTime());
    }
}
