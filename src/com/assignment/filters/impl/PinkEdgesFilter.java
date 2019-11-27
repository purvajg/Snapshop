package com.assignment.filters.impl;

public class PinkEdgesFilter extends ImageFilter {
    public PinkEdgesFilter(){
        weights= new int[]{-1,5,-1,-1,9,5,-1,-1,-1};
        scalingFactor=-1;
    }
}
