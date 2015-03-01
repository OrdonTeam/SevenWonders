package com.ordonteam.sevenwonders.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import groovy.transform.CompileStatic

@CompileStatic
class PlayerView extends LinearLayout{
    PlayerView(Context context) {
        super(context)
    }

    PlayerView(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    PlayerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
    }
}
