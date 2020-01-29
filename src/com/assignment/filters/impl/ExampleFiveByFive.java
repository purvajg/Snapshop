package com.assignment.filters.impl;

public class ExampleFiveByFive extends FiveByFiveFilter {
    public ExampleFiveByFive(){
        weights=new int[]{1,2,1,-2,1,2,-1,1,1,1,-1,1,2,1,1,3,1,1,1,1,4,1,1,4,0,};
        scalingFactor=16;
    }
}
