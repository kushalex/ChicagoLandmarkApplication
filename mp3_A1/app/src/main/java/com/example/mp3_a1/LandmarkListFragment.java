package com.example.mp3_a1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LandmarkListFragment extends Fragment {

    private ListView listView;
    private String[] landmarks;
    private String[] webpages;

    // create ListView of Chicago Landmarks
    // displayed in landmark_fragment id XML

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        listView = view.findViewById(R.id.fragmentListView);

        landmarks =  new String[]{
                getString(R.string.landmark1_title),
                getString(R.string.landmark2_title),
                getString(R.string.landmark3_title),
                getString(R.string.landmark4_title),
                getString(R.string.landmark5_title),
                getString(R.string.landmark6_title)
        };

        webpages =  getResources().getStringArray(R.array.landmark_webpage);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_activated_1, landmarks);
        listView.setAdapter(myAdapter);

        // works with method in MainActivityA1
        // highlight selected element

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivityA1) requireActivity()).LandmarkHighlighted(webpages[position]);
                listView.setItemChecked(position, true);
            }
        });
        return view;
    }
}
