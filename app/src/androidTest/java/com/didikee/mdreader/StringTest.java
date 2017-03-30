package com.didikee.mdreader;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by didik on 2017/3/29.
 */
@RunWith(AndroidJUnit4.class)
public class StringTest {

    @Test
    public void stringFor(){
        String text = "## nihao";
        String format = String.format("preview('%s')", text);
        Log.d("test","result: "+format);
    }
}
