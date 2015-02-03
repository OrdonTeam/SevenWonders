package com.ordonteam

import groovy.transform.CompileStatic
import org.robolectric.Robolectric
import pl.polidea.robospock.RoboSpecification

@CompileStatic
class MainActivitySpec extends RoboSpecification {

    def "Robospock should run"() {
        given:
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get()

        expect:
        activity.text.getText().toString() == 'Hello Groovy'
    }
}