package com.example.lol_deliver;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SKHomepageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SKHomepageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btn_modifyInfo;
    Button btn_modifyMenu;

    public SKHomepageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SKHomepageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SKHomepageFragment newInstance(String param1, String param2) {
        SKHomepageFragment fragment = new SKHomepageFragment();
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
        View view = inflater.inflate(R.layout.fragment_sk_homepage, null);
        btn_modifyInfo = (Button) view.findViewById(R.id.btn_sk_modifyInfo);
        btn_modifyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModifyInfo(view);
            }
        });

        btn_modifyMenu = (Button) view.findViewById(R.id.btn_sk_modifyMenu);
        btn_modifyMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModifyMenu(view);
            }
        });

        return view;
//        return inflater.inflate(R.layout.fragment_sk_homepage, container, false);
    }

    public void ModifyInfo(View view) {
        Intent intent = new Intent(SKHomepageFragment.this.getActivity(), SKModifyInfo.class);
        startActivity(intent);
    }

    public void ModifyMenu(View view) {
        Intent intent = new Intent(SKHomepageFragment.this.getActivity(), SKModifyMenu.class);
        startActivity(intent);
    }
}