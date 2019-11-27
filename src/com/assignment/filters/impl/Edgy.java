package com.assignment.filters.impl;

public class Edgy extends ComplexImageFilter {
    //-1 scaling factor means the image does not need scaling
    public Edgy(){
        weights= new int[]{-1,-1,-1,-1,9,-1,-1,-1,-1};
        scalingFactor=-1;
    }
}
