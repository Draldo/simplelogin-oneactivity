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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment {

    private static final String TAG = "RegisterTAG_";
    private Button mRegisterbtn;
    private Bundle senddata;
    private EditText mname;
    private EditText memail;
    private EditText mpass;
    private EditText mpass2;
    private Fragment fragment;
    private FragmentTransaction transaction;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mname = (EditText) view.findViewById(R.id.reg_name);
        memail = (EditText) view.findViewById(R.id.reg_mail);
        mpass = (EditText) view.findViewById(R.id.reg_pass);
        mpass2 = (EditText) view.findViewById(R.id.reg_pass2);

        mRegisterbtn = (Button) view.findViewById(R.id.a_register_btn);
        transaction = getFragmentManager().beginTransaction();

        mRegisterbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + "regbtn");
                if(mpass.getText().toString().equals(mpass2.getText().toString())){
                    senddata = new Bundle();
                    senddata.putString("newname",mname.getText().toString());
                    senddata.putString("newpass",mpass.getText().toString());
                    senddata.putString("newemail", memail.getText().toString());
                    fragment = new LogIn();
                    fragment.setArguments(senddata);
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.a_main_frame, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity().getBaseContext(),"Passwords must match", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
