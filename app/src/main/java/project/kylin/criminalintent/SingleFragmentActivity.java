package project.kylin.criminalintent;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by jianqi on 2016/4/30.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity{
    protected abstract Fragment createFragment();
    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //set toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.mipmap.ic_menu);
        //mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitle(R.string.crime_title);
        mToolbar.setTitleTextColor(0xffffffff);
        mToolbar.inflateMenu(R.menu.base_toolbar_menu);//set menu

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_add:
                         Toast.makeText(SingleFragmentActivity.this,"click",Toast.LENGTH_SHORT).show();

                    case R.id.action_notification:
                        Toast.makeText(SingleFragmentActivity.this,"click notification",Toast.LENGTH_SHORT).show();

                    case R.id.action_search:
                        Toast.makeText(SingleFragmentActivity.this,"click search",Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (null == fragment) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragmentContainer,fragment).commit();
        }
    }
}
