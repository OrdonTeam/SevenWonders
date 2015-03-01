package com.ordonteam.sevenwonders

import android.app.Activity
import android.os.Bundle
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.ordonteam.sevenwonders.view.RowView
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {
    @InjectView(R.id.rowLabels)
    RowView rowLabels

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        SwissKnife.inject(this)
    }
}