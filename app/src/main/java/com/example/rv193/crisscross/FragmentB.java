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
public class FragmentB extends Fragment {
    EditText editText2; TextView textView2; Button button2;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_b, container, false);
        editText2 = (EditText)v.findViewById(R.id.editText2);
        textView2 = (TextView)v.findViewById(R.id.textview2);
        button2 = (Button)v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2 = editText2.getText().toString();
                SendTextCommunication2 stc2=(SendTextCommunication2)getActivity();
                stc2.setTheText2(s2);
            }
        });
        return v;
    }

    public interface SendTextCommunication2 {
        public void setTheText2(String s);
    }
}
