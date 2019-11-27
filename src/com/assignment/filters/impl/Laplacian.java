package com.assignment.filters.impl;

import com.assignment.pixel.PixelImage;

public class Laplacian implements Filter {

    private static final int[][] weights = new int[][]{{-1,-1,-1}, {-1,8,-1}, {-1,-1,-1}};

    @Override
    public void filter(PixelImage theImage) {

    }
}
