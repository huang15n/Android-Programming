package com.example.dictionaryactivitylifecycle;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bad#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bad extends Fragment {
    ListView lv;
    Button butt;
    EditText et;

    View view;


    ArrayList<String> dictionary;
    ArrayAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bad() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bad.
     */
    // TODO: Rename and change types and number of parameters
    public static bad newInstance(String param1, String param2) {
        bad fragment = new bad();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        dictionary = new ArrayList<>();
        view = inflater.inflate(R.layout.fragment_bad,container,false);

        lv = view.findViewById(R.id.dictionary);
        butt = view.findViewById(R.id.butt);
        et = view.findViewById(R.id.et);

        dictionary.add("one");
        dictionary.add("two");
        dictionary.add("three");

        butt.setText("hhelloooo");


       adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,dictionary);



        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dictionary.remove(position);
                adapter.notifyDataSetChanged();
            }
        });


        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dictionary.add(et.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        Fragment myFrag = getFragmentManager().findFragmentById(R.id.fragment_good);
        if (myFrag != null) {
            myFrag.something();
        }

        return view;
    }
}