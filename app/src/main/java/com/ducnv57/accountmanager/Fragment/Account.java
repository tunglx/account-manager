package com.ducnv57.accountmanager.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ducnv57.accountmanager.Adapter.InforAccountAdapter;
import com.ducnv57.accountmanager.Object.InforOfAccount;
import com.ducnv57.accountmanager.R;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

import java.util.ArrayList;

/**
 * Created by W10-PRO on 02-Jun-16.
 */
public class Account extends Fragment {

    ArrayList<InforOfAccount> listSim1 = new ArrayList<InforOfAccount>();
    ArrayList<InforOfAccount> listSim2 = new ArrayList<InforOfAccount>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        listSim1.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim1.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim1.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim1.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim1.add(new InforOfAccount("Tài khoản chính", "50000 VND"));

        listSim2.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim2.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim2.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim2.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim2.add(new InforOfAccount("Tài khoản chính", "50000 VND"));
        listSim2.add(new InforOfAccount("Tài khoản chính", "50000 VND"));


        InforAccountAdapter adapterSim1 = new InforAccountAdapter(getActivity(), R.layout.item_infor_listview, listSim1);
        InforAccountAdapter adapterSim2 = new InforAccountAdapter(getActivity(), R.layout.item_infor_listview, listSim2);

        ListView lvSim1 = (ListView) getActivity().findViewById(R.id.lvSim1);
        ListView lvSim2 = (ListView) getActivity().findViewById(R.id.lvSim2);

        lvSim1.setAdapter(adapterSim1);
        lvSim2.setAdapter(adapterSim2);

        ListUtils.setDynamicHeight(lvSim1);
        ListUtils.setDynamicHeight(lvSim2);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();


        }

    }
}
