package project.kylin.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import project.kylin.criminalintent.adapter.CrimeListAdapter;
import project.kylin.criminalintent.model.Crime;

/**
 * Created by jianqi on 2016/6/22.
 */
public class CrimeListFragment2 extends Fragment {

    RecyclerView recyclerView;
    private CrimeListAdapter crimeListAdapter;
    private List<Crime> list = new ArrayList<Crime>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        crimeListAdapter = new CrimeListAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        Log.i("CrimeListFragment", (layoutManager == null) + "");
        recyclerView = (RecyclerView) view.findViewById(R.id.crim_list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(crimeListAdapter);

        text();
        return view;
    }

    public void text() {
        Crime crime = new Crime();
        crime.setmSolved(true);
        crime.setmTitle("test RecyclerView");
        list.add(crime);
        crimeListAdapter.notifyDataSetChanged();
    }


}
