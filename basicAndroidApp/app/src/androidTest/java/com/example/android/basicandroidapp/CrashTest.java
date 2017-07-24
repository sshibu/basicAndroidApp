package com.example.android.basicandroidapp;

import android.support.test.runner.AndroidJUnit4;
import com.xamarin.testcloud.espresso.Factory;
import com.xamarin.testcloud.espresso.ReportHelper;

import org.junit.Test;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


/**
 * Created by sherin on 7/20/17.
 */

public class CrashTest {

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void useAppContext() throws Exception {
        // test using ExpectedException rule instead of try-catch
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("This is a crash");
        reportHelper.label("testing crash functionality");
    }
    @After
    public void TearDown(){
        reportHelper.label("Stopping App");
    }
}