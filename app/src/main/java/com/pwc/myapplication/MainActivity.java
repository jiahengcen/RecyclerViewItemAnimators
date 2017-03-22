package com.pwc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pwc.myapplication.ui.AnimationGridActivity;
import com.pwc.myapplication.ui.AnimationListActivity;
import com.pwc.myapplication.ui.GridActivity;
import com.pwc.myapplication.ui.ListActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void linear(View viw){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

    public void grid(View viw){
        Intent intent = new Intent(this,GridActivity.class);
        startActivity(intent);
    }

    public void adapterList(View viw){
        Intent intent = new Intent(this, AnimationListActivity.class);
        startActivity(intent);
    }

    public void adapterGrid(View viw){
        Intent intent = new Intent(this, AnimationGridActivity.class);
        startActivity(intent);
    }

}
