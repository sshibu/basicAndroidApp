package com.example.android.basicandroidapp;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


/**
 * Created by sherin on 7/20/17.
 */

public class CrashUnitTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void useAppContext() throws Exception {
        // test using ExpectedException rule instead of try-catch
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("This is a crash");
    }

}
