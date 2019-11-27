package com.assignment.filters.impl;

public class UnsharpMaskingFilter extends ComplexImageFilter {
    //-1 scaling factor means the image does not need scaling
    public UnsharpMaskingFilter(){
        weights= new int[]{-1,-2,-1,-2,28,-2,-1,-2,-1};
        scalingFactor=16;
    }
}
