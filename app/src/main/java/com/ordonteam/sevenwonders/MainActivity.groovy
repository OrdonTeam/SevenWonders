package com.ordonteam.sevenwonders

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.ordonteam.sevenwonders.view.PlayerView
import groovy.transform.CompileStatic
import org.w3c.dom.Text

@CompileStatic
class MainActivity extends Activity {
    @InjectView(R.id.player1)
    PlayerView player1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        SwissKnife.inject(this)
    }
}