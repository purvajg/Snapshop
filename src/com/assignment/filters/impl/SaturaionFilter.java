package com.assignment.filters.impl;

public class SaturaionFilter extends ComplexImageFilter {
    public SaturaionFilter(){
        weights= new int[]{5,5,5,5,9,5,5,5,5};
        scalingFactor=16;

//        weights= new int[]{1,0,3,0,4,0,-3,0,1}; pink saturation
//        scalingFactor=-1;

//
//
    }
}
