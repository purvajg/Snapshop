package com.assignment.filters.impl;

public class SimpleBlurFilter extends ImageFilter {
    public SimpleBlurFilter(){
        weights= new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};
        scalingFactor=9;
    }

}
