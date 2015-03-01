package com.ordonteam.sevenwonders

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {
    TextView text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        LinearLayout linearLayout = new LinearLayout(this)
        linearLayout.setOrientation(LinearLayout.VERTICAL)

        text = new TextView(this)
        text.setText('Hello Groovy')
        linearLayout.addView(text)

        setContentView(linearLayout)
    }
}