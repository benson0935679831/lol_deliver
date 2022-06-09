package com.example.lol_deliver;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    Button btn_statistics;

    TextView Name, Phone ,Address;
    TextView Mon, Tue, Wed, Thur, Fri, Sat, Sun;
    private DatabaseReference mDataBase;

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

        btn_statistics = (Button) view.findViewById(R.id.btn_sk_statistic);
        btn_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Statistics(view);
            }
        });

        Name = (TextView) view.findViewById(R.id.tv_sk_shopname);
        Phone = (TextView) view.findViewById(R.id.tv_sk_phone);
        Address = (TextView) view.findViewById(R.id.tv_sk_address);
        Mon = (TextView) view.findViewById(R.id.tv_sk_timeMon);
        Tue = (TextView) view.findViewById(R.id.tv_sk_timeTue);
        Wed = (TextView) view.findViewById(R.id.tv_sk_timeWed);
        Thur = (TextView) view.findViewById(R.id.tv_sk_timeThur);
        Fri = (TextView) view.findViewById(R.id.tv_sk_timeFri);
        Sat = (TextView) view.findViewById(R.id.tv_sk_timeSat);
        Sun = (TextView) view.findViewById(R.id.tv_sk_timeSun);

        mDataBase = FirebaseDatabase.getInstance().getReference().child("shops").child("JhuJian");

        loadInfo(mDataBase, "name", Name);
        loadInfo(mDataBase, "phone", Phone);
        loadInfo(mDataBase, "address", Address);
        loadInfo(mDataBase, "Mon", Mon);
        loadInfo(mDataBase, "Tue", Tue);
        loadInfo(mDataBase, "Wed", Wed);
        loadInfo(mDataBase, "Thur", Thur);
        loadInfo(mDataBase, "Fri", Fri);
        loadInfo(mDataBase, "Sat", Sat);
        loadInfo(mDataBase, "Sun", Sun);
        return view;
//        return inflater.inflate(R.layout.fragment_sk_homepage, container, false);
    }

    public void loadInfo(DatabaseReference dbr, String tag, TextView tv){
        dbr.child(tag).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String res = snapshot.getValue(String.class);
                        tv.setText(res);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    public void ModifyInfo(View view) {
        Intent intent = new Intent(SKHomepageFragment.this.getActivity(), SKModifyInfo.class);
        startActivity(intent);
    }

    public void ModifyMenu(View view) {
        Intent intent = new Intent(SKHomepageFragment.this.getActivity(), SKModifyMenu.class);
        startActivity(intent);
    }

    public void Statistics(View view) {
        Intent intent = new Intent(SKHomepageFragment.this.getActivity(), SKStatistics.class);
        startActivity(intent);
    }
}