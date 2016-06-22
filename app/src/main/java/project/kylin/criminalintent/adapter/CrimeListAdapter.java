package project.kylin.criminalintent.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import project.kylin.criminalintent.R;
import project.kylin.criminalintent.model.Crime;

/**
 * Created by jianqi on 2016/6/22.
 */
public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.ViewHolder> {

    private List<Crime> crimeList;

    public CrimeListAdapter(List<Crime> crimeList) {
        this.crimeList = crimeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_crime,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Crime crime = crimeList.get(position);
        holder.tv_crimetitle.setText(crime.getmTitle());
        holder.tv_crimedate.setText(crime.getDate()+"");
        holder.cb_crime.setChecked(crime.ismSolved());

    }

    @Override
    public int getItemCount() {
        return crimeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CheckBox cb_crime;
        public TextView tv_crimetitle,tv_crimedate;

        public ViewHolder(View itemView) {
            super(itemView);

            cb_crime = (CheckBox) itemView.findViewById(R.id.crim_list_item_solvedCheckBox);
            tv_crimetitle = (TextView) itemView.findViewById(R.id.crim_list_item_titleTextView);
            tv_crimedate = (TextView)itemView.findViewById(R.id.crim_list_item_dateTextView);
        }
    }
}
