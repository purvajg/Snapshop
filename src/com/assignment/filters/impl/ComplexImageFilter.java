package com.assignment.filters.impl;

import com.assignment.pixel.Pixel;
import com.assignment.pixel.PixelImage;

public class ComplexImageFilter implements Filter {
    protected int[] weights;

    private Pixel[] colorArray;

    protected int scalingFactor;

    public ComplexImageFilter() {
        this.colorArray = new Pixel[9];
    }

    @Override
    public void filter(PixelImage theImage) {
        Pixel[][] originalImage = theImage.getData();
        Pixel[][] resultImage = theImage.getData();

        for (int row = 1; row < theImage.getHeight() - 1; row++) {
            for (int column = 1; column < theImage.getWidth() - 1; column++) {

                createColorArray(originalImage, row, column);

                Pixel pixel = convertWeightedArrayToPixel(scalingFactor);

                resultImage[row][column] = pixel;

            }
        }

        theImage.setData(resultImage);
    }

    public void createColorArray(Pixel[][] originalImage, int row, int column) {
        int index = 0;

        for (int i = -1; i < 2; i++) {
            for (int k = -1; k < 2; k++) {
                colorArray[index] = originalImage[row + i][column + i];
                index++;
            }
        }
    }

    public Pixel convertWeightedArrayToPixel(int scalingFactor) {
        Pixel pixel;

        int index = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        while (index < 9) {
            red += (colorArray[index].red) * weights[index];
            green += (colorArray[index].green) * weights[index];
            blue += (colorArray[index].blue) * weights[index];
            index++;
        }

        if(scalingFactor>-1){
            red= scaleDown(red,16,'/');
            green= scaleDown(green,16,'/');
            blue= scaleDown(blue,16,'/');
        }

        red = checkRGBValue(red);
        green = checkRGBValue(green);
        blue = checkRGBValue(blue);

        pixel = new Pixel(red, green, blue);
        return pixel;
    }

    public int checkRGBValue(int redGreenOrBlue) {
        if (redGreenOrBlue > 255) redGreenOrBlue = 255;
        if (redGreenOrBlue < 0) redGreenOrBlue = 0;
        return redGreenOrBlue;
    }

    public int scaleDown(int redGreenOrBlue, int scalingFactor, char operation){
        if(operation=='/'){
            return redGreenOrBlue/scalingFactor;
        }
        return 0;
    }
}
