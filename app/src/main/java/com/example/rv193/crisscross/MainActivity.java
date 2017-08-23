package com.example.rv193.crisscross;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        FragmentA.sendTextCommunication, FragmentB.SendTextCommunication2 {
    FragmentA fragment1;
    FragmentB fragment2;
    //App that shows communication between fragments using an interface and implementing it in
    // the mainActivity
    // CrissCross is a simple and effective example of passing information from fragment to
    // activity to fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragment1 == null) {
            fragment1 = new FragmentA();
        }
        if (fragment2 == null) {
            fragment2 = new FragmentB();
        }

        if (!fragment1.isInLayout()) {
            transaction.add(R.id.fragment1container, fragment1);

        }
        if (!fragment2.isInLayout()) {
            transaction.add(R.id.fragment2container, fragment2);

        }
        transaction.commit();
    }
    //Criss Cross Fragment text A to Fragment text B
    @Override
    public void setTheText(String s) {
        SharedPreferences sp= getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("string1", s);
        editor.commit();
        Toast.makeText(this,"string1 saved", Toast.LENGTH_SHORT).show();
        fragment2.textView2.setText(s);
    }

    @Override
    public void setTheText2(String s) {
        SharedPreferences sp2 = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.commit();
        Toast.makeText(this, "string2 is saved", Toast.LENGTH_SHORT).show();
        fragment1.textView.setText(s);
    }
}
