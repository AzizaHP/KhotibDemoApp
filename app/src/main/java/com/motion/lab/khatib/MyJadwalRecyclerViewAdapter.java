package com.motion.lab.khatib;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.motion.lab.khatib.model.Jadwal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Jadwal} and makes a call to the
 * specified {@link com.motion.lab.khatib.JadwalFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyJadwalRecyclerViewAdapter extends RecyclerView.Adapter<MyJadwalRecyclerViewAdapter.ViewHolder> {

    private final List<Jadwal> mValues;
    private final JadwalFragment.OnListFragmentInteractionListener mListener;

    public MyJadwalRecyclerViewAdapter(List<Jadwal> items, JadwalFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mMasjidText.setText(mValues.get(position).getMasjid().getName());
        DateFormat df = new SimpleDateFormat("dd MMM", Locale.US);
        holder.mDateText.setText(df.format(mValues.get(position).getDate()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mMasjidText;
        public final TextView mDateText;
        public Jadwal mItem;

        public ViewHolder(View view) {
            super(view);
            mMasjidText = (TextView) view.findViewById(R.id.masjid_text);
            mDateText = (TextView) view.findViewById(R.id.date_text);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMasjidText.getText() + "'";
        }
    }


}
