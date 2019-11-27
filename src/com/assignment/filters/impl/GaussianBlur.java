package com.assignment.filters.impl;

public class GaussianBlur extends ImageFilter {
    //-1 scaling factor means the image does not need scaling
    public GaussianBlur(){
        weights= new int[]{1, 2, 1, 2, 4, 2, 1, 2, 1};
        scalingFactor=16;
    }

}
