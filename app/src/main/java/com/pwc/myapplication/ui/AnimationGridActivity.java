/*
 * ******************************************************************************
 *   Copyright (c) 2014 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */
package com.pwc.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.pwc.myapplication.R;
import com.pwc.myapplication.adapter.AnimationGridAdapter;
import com.pwc.mylibrary.adapter.AlphaAnimatorAdapter;
import com.pwc.mylibrary.adapter.ScaleInAnimatorAdapter;
import com.pwc.mylibrary.adapter.SlideInBottomAnimatorAdapter;
import com.pwc.mylibrary.adapter.SlideInLeftAnimatorAdapter;
import com.pwc.mylibrary.adapter.SlideInRightAnimatorAdapter;
import com.pwc.mylibrary.adapter.SwingBottomInAnimationAdapter;


public class AnimationGridActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    protected AnimationGridAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //Setup Spinner
        setupSpinner();

        //Setup RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        mAdapter = new AnimationGridAdapter(this);
        AlphaAnimatorAdapter animatorAdapter = new AlphaAnimatorAdapter(mAdapter, mRecyclerView);
        animatorAdapter.getViewAnimator().setInitialDelayMillis(500);
        mRecyclerView.setAdapter(animatorAdapter);

    }


    private void setupSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.adapters, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        AlphaAnimatorAdapter animatorAdapter = new AlphaAnimatorAdapter(mAdapter, mRecyclerView);
                        mRecyclerView.setAdapter(animatorAdapter);
                        break;
                    case 1:
                        SlideInLeftAnimatorAdapter slideInLeftAnimationRecyclerViewAdapter = new SlideInLeftAnimatorAdapter(mAdapter, mRecyclerView);
                        mRecyclerView.setAdapter(slideInLeftAnimationRecyclerViewAdapter);
                        break;
                    case 2:
                        SlideInRightAnimatorAdapter slideInRightAnimatorAdapter = new SlideInRightAnimatorAdapter(mAdapter, mRecyclerView);
                        mRecyclerView.setAdapter(slideInRightAnimatorAdapter);
                        break;
                    case 3:
                        SlideInBottomAnimatorAdapter slideInBottomAnimatorAdapter= new SlideInBottomAnimatorAdapter(mAdapter, mRecyclerView);
                        mRecyclerView.setAdapter(slideInBottomAnimatorAdapter);
                        break;
                    case 4:
                        ScaleInAnimatorAdapter scaleInRecyclerViewAnimationAdapter = new ScaleInAnimatorAdapter(mAdapter, mRecyclerView);
                        mRecyclerView.setAdapter(scaleInRecyclerViewAnimationAdapter);
                        break;
                    case 5:
                        SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(mAdapter, mRecyclerView);
                        mRecyclerView.setAdapter(swingBottomInAnimationAdapter);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
