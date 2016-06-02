package com.ducnv57.accountmanager.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ducnv57.accountmanager.Object.InforOfAccount;
import com.ducnv57.accountmanager.R;

import java.util.ArrayList;

/**
 * Created by W10-PRO on 02-Jun-16.
 */
public class InforAccountAdapter extends ArrayAdapter<InforOfAccount> {
    int layoutId;
    Activity mContext = null;
    ArrayList<InforOfAccount> mListInfor = null;

    public InforAccountAdapter(Activity context, int layoutId, ArrayList<InforOfAccount> objects) {
        super(context, layoutId, objects);
        this.layoutId = layoutId;
        this.mContext = context;
        this.mListInfor = objects;
    }
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            v = inflater.inflate(layoutId, null);
        }

        InforOfAccount item = mListInfor.get(position);

        TextView tvName = (TextView) v.findViewById(R.id.tvTitle);
        TextView tvDetails = (TextView) v.findViewById(R.id.tvDetail);

        tvName.setText(item.getTitle());
        tvDetails.setText(item.getDetail());
        return v;
    }

}
