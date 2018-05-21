
/**
 * Created by poojab26 on 22-May-18.
 */


import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivityFragment;


import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;
@RunWith(AndroidJUnit4.class)
public class TestAsyncTask {
    @Test
    public void testDoInBackground() throws Exception {
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.testFlag = true;

        new EndpointsAsyncTask().execute(fragment);
        Thread.sleep(10000);
        assertTrue("Error: Joke: " + fragment.joke_loaded, fragment.joke_loaded != null);
    }
}
