package com.ordonteam.sevenwonders.view

import android.widget.LinearLayout
import org.robolectric.Robolectric
import org.robolectric.res.Attribute
import org.robolectric.shadows.RoboAttributeSet
import pl.polidea.robospock.RoboSpecification

class RowViewTest extends RoboSpecification {
    def "RowView at start should have 3 visible and 4 gone columns"() {
        given:
        RoboAttributeSet attrs = new RoboAttributeSet(
                [new Attribute("android.R:attr/inputType", "2", "com.ordonteam.sevenwonders"),
                 new Attribute("android.R:attr/text", "title", "com.ordonteam.sevenwonders")], Robolectric.application.resources, RowView)
        def rowView = new RowView(Robolectric.application, attrs)

        expect:
        rowView.editTexts[0].visibility == LinearLayout.VISIBLE
        rowView.editTexts[1].visibility == LinearLayout.VISIBLE
        rowView.editTexts[2].visibility == LinearLayout.VISIBLE
        rowView.editTexts[3].visibility == LinearLayout.GONE
        rowView.editTexts[4].visibility == LinearLayout.GONE
        rowView.editTexts[5].visibility == LinearLayout.GONE
        rowView.editTexts[6].visibility == LinearLayout.GONE
    }

    def "after add column should have 1 more visible column"() {
        given:
        RoboAttributeSet attrs = new RoboAttributeSet(
                [new Attribute("android.R:attr/inputType", "2", "com.ordonteam.sevenwonders"),
                 new Attribute("android.R:attr/text", "title", "com.ordonteam.sevenwonders")], Robolectric.application.resources, RowView)
        def rowView = new RowView(Robolectric.application, attrs)

        when:
        rowView.addColumn()

        then:
        rowView.editTexts[0].visibility == LinearLayout.VISIBLE
        rowView.editTexts[1].visibility == LinearLayout.VISIBLE
        rowView.editTexts[2].visibility == LinearLayout.VISIBLE
        rowView.editTexts[3].visibility == LinearLayout.VISIBLE
        rowView.editTexts[4].visibility == LinearLayout.GONE
        rowView.editTexts[5].visibility == LinearLayout.GONE
        rowView.editTexts[6].visibility == LinearLayout.GONE
    }

    def "RowView getValue return 0 at start "(){
        given:
        RoboAttributeSet attrs = new RoboAttributeSet(
                [new Attribute("android.R:attr/inputType", "2", "com.ordonteam.sevenwonders"),
                 new Attribute("android.R:attr/text", "title", "com.ordonteam.sevenwonders")], Robolectric.application.resources, RowView)
        def rowView = new RowView(Robolectric.application, attrs)

        expect:
        rowView.getValue(0) == 0
    }

    def "RowView getValue return value 10 from input"(){
        given:
        RoboAttributeSet attrs = new RoboAttributeSet(
                [new Attribute("android.R:attr/inputType", "2", "com.ordonteam.sevenwonders"),
                 new Attribute("android.R:attr/text", "title", "com.ordonteam.sevenwonders")], Robolectric.application.resources, RowView)
        def rowView = new RowView(Robolectric.application, attrs)
        rowView.editTexts[0].setText("10")

        expect:
        rowView.getValue(0) == 10
    }
}