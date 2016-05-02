package project.kylin.criminalintent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by jianqi on 2016/4/30.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    public CrimeLab(Context mAppContext) {
        this.mAppContext = mAppContext;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0;i < 100; i++) {
            Crime c = new Crime();
            c.setmTitle("Crime #"+i);
            c.setmSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context c){
        if (null == sCrimeLab) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime c : mCrimes) {
            if(c.getmId().equals(id)){
                return c;
            }
        }
        return null;
    }
}
