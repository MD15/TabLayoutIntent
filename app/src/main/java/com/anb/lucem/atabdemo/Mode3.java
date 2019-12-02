package com.anb.lucem.atabdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Mode3 extends Fragment {

    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mode_3, container, false);
        context = getActivity();
        ListView lv = (ListView) view.findViewById(R.id.listView3);
        String[] awayStrings = {
                "1-50", "51-100", "101-150",
                "151-200", "201-250", "251-300",
                "301-350", "351-400", "401-450",
                "451-500"
        };

        ArrayAdapter<String> lva = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                awayStrings
        );

        lv.setAdapter(lva);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), InfinityLoop1.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_away);

        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        ((MainActivity) getActivity()).refreshNow();
                        Toast.makeText(getContext(), "Refreshed", Toast.LENGTH_LONG).show();
                    }
                }
        );
        return view;
    }
}