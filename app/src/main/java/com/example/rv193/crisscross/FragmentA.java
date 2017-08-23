package com.example.rv193.crisscross;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

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
                String f = "a string to test pull request with git can be deleted";
                sendTextCommunication stc = (sendTextCommunication)getActivity();
                stc.setTheText(s);
            }
        });
        return v;
    }
    public interface sendTextCommunication {

        public void setTheText(String s);
    }
}
