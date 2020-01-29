package com.assignment.filters.impl;
import com.assignment.pixel.Pixel;
import com.assignment.pixel.PixelImage;

/*
Simple conversions like flipHorizontalFilter, flipVerticalFilter, and NegativeFilter class do not require
the ComplexImageFilter class. Hence, not these three classes do not extend ComplexImageFilter class
 */

public class NegativeFilter implements Filter {
    @Override
    public void filter(PixelImage theImage) {

        Pixel[][] data = theImage.getData();

        for (int row = 0; row < theImage.getHeight(); row++) {
            for (int col = 0; col<theImage.getWidth(); col++) {
                Pixel pixel = data[row][col];
                pixel.red = 255 - pixel.red;
                pixel.green = 255 - pixel.green;
                pixel.blue = 255 - pixel.blue;
            }
        }

        theImage.setData(data);
    }
}
