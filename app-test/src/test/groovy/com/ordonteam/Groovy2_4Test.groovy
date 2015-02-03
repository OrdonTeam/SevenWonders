package com.ordonteam;

import groovy.transform.Canonical
import groovy.transform.CompileStatic;
import spock.lang.Specification;

@CompileStatic
class Groovy2_4Test extends Specification {
    def "Tests should run with groovy 2.4"() {
        when:
        PointHelper p1 = new PointHelper(0, 0)
        PointHelper p2 = new PointHelper(0, 0)

        then:
        p1==p2
    }

    @Canonical
    private class PointHelper {
        final int x;
        final int y;
        PointHelper(int x,int y){
            this.x = x
            this.y = y
        }
    }
}