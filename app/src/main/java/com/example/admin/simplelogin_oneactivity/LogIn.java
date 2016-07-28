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


/**
 * A simple {@link Fragment} subclass.
 */
public class LogIn extends Fragment {

    private static final String TAG = "LogInTAG_";
    private Button mLogbtn;
    private Button mRegbtn;
    private EditText name;
    private EditText pass;
    private Bundle data;
    private Fragment fragment;
    private FragmentTransaction transaction;
    private int index=0;
    private Bundle userdata;
    private String[][] usrdb = new String[10][3];

    public LogIn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userdata = this.getArguments();
        if(userdata!=null && index<10) {
            usrdb[index][0] = userdata.getString("newname");
            usrdb[index][1] = userdata.getString("newemail");
            usrdb[index][2] = userdata.getString("newpass");
            index++;
        }

        mLogbtn = (Button) view.findViewById(R.id.a_log_btn);
        mRegbtn = (Button) view.findViewById(R.id.a_signup_btn);
        name = (EditText) view.findViewById(R.id.a_main_name);
        pass = (EditText) view.findViewById(R.id.a_main_pass);

        mLogbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + name.getText().toString());
                Log.d(TAG, "onClick: " + pass.getText().toString());
                for(int i = 0; i<10; i++){
                    if(name.getText().toString().equals(usrdb[i][0]) && pass.getText().toString().equals(usrdb[i][2])){
                        data = new Bundle();
                        data.putString("name",name.getText().toString());
                        data.putString("pass",pass.getText().toString());
                        fragment = new Welcome();
                        fragment.setArguments(data);
                        transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.a_main_frame, fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                }
            }
        });

        mRegbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + "signupbtn");
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.a_main_frame, new Register());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
