package com.example.admin.simplelogin_oneactivity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Welcome extends Fragment {

    private static final String TAG = "WelcomeTAG_";
    private Button mBackbtn;
    private Bundle getdata;
    private TextView mTextview;
    private FragmentTransaction transaction;

    public Welcome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBackbtn = (Button) view.findViewById(R.id.a_logout_btn);
        mTextview = (TextView) view.findViewById(R.id.a_hello_tv);
        transaction = getFragmentManager().beginTransaction();
        getdata = this.getArguments();
        String name = getdata.getString("name");
        String pass = getdata.getString("pass");

        mTextview.setText("Welcome " + name + " with pass:" + pass);

        mBackbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + "logoutbtn");
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.a_main_frame, new LogIn());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
