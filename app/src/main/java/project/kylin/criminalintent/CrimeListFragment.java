package project.kylin.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import project.kylin.criminalintent.model.Crime;
import project.kylin.criminalintent.model.CrimeLab;

/**
 * Created by jianqi on 2016/4/30.
 */
public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mCrimes;
    private static  final int REQUEST_CRIME = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getActivity().setTitle(R.string.crime_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
       // ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
        Log.d("CrimListFragment",c.getmId()+"");
        Intent i = new Intent(getActivity(),CrimePageActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
        startActivity(i);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CRIME) {

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_crime:
                Crime crime = new Crime();
                CrimeLab.get(getActivity()).addCrime(crime);
                Intent i = new Intent(getActivity(),CrimePageActivity.class);
                i.putExtra(CrimeFragment.EXTRA_CRIME_ID,crime.getmId());
                startActivityForResult(i,0);
                return true;
            case R.id.menu_item_show_subtitle:
                getActivity().getActionBar().setSubtitle(R.string.subtitle);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class CrimeAdapter extends ArrayAdapter<Crime> {
        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (null == convertView) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }else {
                holder =(ViewHolder) convertView.getTag();
            }
            Crime c = getItem(position);
            holder.crimListItemTitleTextView.setText(c.getmTitle());
            holder.crimListItemDateTextView.setText(c.getDate().toString());
            holder.crimListItemSolvedCheckBox.setChecked(c.ismSolved());
            return  convertView;
        }

         final class ViewHolder {
            @Bind(R.id.crim_list_item_solvedCheckBox)
            CheckBox crimListItemSolvedCheckBox;
            @Bind(R.id.crim_list_item_titleTextView)
            TextView crimListItemTitleTextView;
            @Bind(R.id.crim_list_item_dateTextView)
            TextView crimListItemDateTextView;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
