package com.assignment.filters.impl;

public class SharpFilter extends ImageFilter {
    public SharpFilter(){
        weights= new int[]{-1,-1,-1,-1,12,-1,-1,-1,-1};
        scalingFactor=-1;

//        weights= new int[]{0,0,0,0,3,0,0,0,0};
//        scalingFactor=-1; before
    }
}
