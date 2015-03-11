package com.ordonteam.sevenwonders.view.common

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.ordonteam.sevenwonders.R
import groovy.transform.CompileStatic

@CompileStatic
class AttributeExtractor {
    static String extractStringAttribute(Context context, AttributeSet attrs, int id) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RowView,
                0, 0)

        try {
            return a.getString(id)
        } finally {
            a.recycle()
        }
    }

    static int extractIntAttribute(Context context, AttributeSet attrs, int id) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RowView,
                0, 0)

        try {
            return a.getInteger(id, 0)
        } finally {
            a.recycle()
        }
    }

    static boolean extractBooleanAttribute(Context context, AttributeSet attrs, int id) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RowView,
                0, 0)

        try {
            return a.getBoolean(id, false)
        } finally {
            a.recycle()
        }
    }
}
