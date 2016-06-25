package project.kylin.criminalintent;

import android.support.v4.app.Fragment;

import java.text.SimpleDateFormat;

/**
 * Created by jianqi on 2016/4/30.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

        //return new CrimeListFragment();
        return new CrimeListFragment2();
    }
}
