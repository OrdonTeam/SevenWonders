package com.ordonteam.sevenwonders

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {
    @InjectView(R.id.textView)
    TextView textView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        SwissKnife.inject(this)
        textView.setText('Hello 7 Wonders')
    }
}