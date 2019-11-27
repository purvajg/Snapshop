package com.assignment.filters.impl;

public class RainbowFilter extends ImageFilter {
    public RainbowFilter(){
        weights= new int[]{5,5,-1,-1,9,5,-1,-1,5};
        scalingFactor=-1;
    }
}
