package com.assignment.filters.impl;
import com.assignment.pixel.Pixel;
import com.assignment.pixel.PixelImage;

/*
Simple conversions like flipHorizontalFilter, flipVerticalFilter, and NegativeFilter class do not require
the ComplexImageFilter class. Hence, not these three classes do not extend ComplexImageFilter class
 */

public class FlipVerticalFilter implements Filter {
    @Override
    public void filter(PixelImage theImage) {

        Pixel[][] data = theImage.getData();

        for (int row = 0; row < theImage.getHeight()/2 ; row++) {
            for (int col = 0; col<theImage.getWidth(); col++) {
                Pixel temp = data[row][col];
                data[row][col] = data[theImage.getHeight()-row-1][col];
                data[theImage.getHeight()-row-1][col] = temp;
            }
        }
        theImage.setData(data);
    }
}
