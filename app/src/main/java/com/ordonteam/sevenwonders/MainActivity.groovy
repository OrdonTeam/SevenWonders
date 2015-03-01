package com.ordonteam.sevenwonders

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.arasthel.swissknife.annotations.OnClick
import com.ordonteam.sevenwonders.view.RowViews
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {

    @InjectView(R.id.rows)
    RowViews rows

    @InjectView(R.id.playerNumber)
    TextView playerNumber

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        SwissKnife.inject(this)
    }
    @OnClick(R.id.minusButton)
    void onMinusButtonClicked(){
        def value = playerNumber.getText().toInteger()
        if (value > 3 ){
            playerNumber.setText("${value-1}")
            rows.removeColumn()
        }
    }

    @OnClick(R.id.plusButton)
    void onPlusButtonClicked(){
        def value = playerNumber.getText().toInteger()
        if (value < 7 ){
            playerNumber.setText("${value+1}")
            rows.addColumn()
        }
    }

    @OnClick(R.id.calculate)
    void calculateSum(){
        rows.sum()
    }

}