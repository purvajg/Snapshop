package com.assignment.filters.impl;

public class LaplacianFilter extends ImageFilter {
    //-1 scaling factor means the image does not need scaling
    public LaplacianFilter(){
        weights= new int[]{-1,-1,-1,-1,8,-1,-1,-1,-1};
        scalingFactor=-1;
    }
}
