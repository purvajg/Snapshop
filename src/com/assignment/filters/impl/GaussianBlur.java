package com.assignment.filters.impl;

public class GaussianBlur extends ComplexImageFilter {
    public GaussianBlur(){
        weights= new int[]{1, 2, 1, 2, 4, 2, 1, 2, 1};
        scalingFactor=16;
    }

}
