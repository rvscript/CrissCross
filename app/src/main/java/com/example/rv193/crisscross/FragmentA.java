package com.example.rv193.crisscross;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {
    public static final String DEFAULT = "fragmentA default text";
    EditText editText; TextView textView; Button button;
    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_, container, false);
        editText = (EditText)v.findViewById(R.id.editText);
        textView = (TextView)v.findViewById(R.id.textview);
        button = (Button)v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();

                sendTextCommunication stc = (sendTextCommunication)getActivity();
                stc.setTheText(s);

            }
        });

        SharedPreferences spf1 = getActivity().getSharedPreferences("MyData",Context.MODE_PRIVATE);
        String stringf1 = spf1.getString("string1",DEFAULT);
        if(stringf1.equals(DEFAULT)){
            Toast.makeText(getActivity(),"fragment1 default text", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"fragment2 saved text", Toast.LENGTH_SHORT).show();
            textView.setText(stringf1);
        }
        return v;
    }
    public interface sendTextCommunication {

        public void setTheText(String s);
    }
}
