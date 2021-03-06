package com.assignment.filters.impl;
import com.assignment.pixel.Pixel;
import com.assignment.pixel.PixelImage;

/*This class would be a helper class for all othe complex filters like Gaussian, Edgy, Laplacian, etc.
It creates an image given a array of weight and scaling factor.
 */
public class ComplexImageFilter implements Filter {
    protected int[] weights;
    protected int scalingFactor;
    private Pixel[] colorArray;


    public ComplexImageFilter() {
        this.colorArray = new Pixel[9];//because 3x3 array, so length is 9
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

    /*
    here we are converting the 3x3 color array from the original image to an array so it would we helpful later to
    multiply it by weights in convertWeightedArrayToPixel()
     */
    public void createColorArray(Pixel[][] originalImage, int row, int column) {
        int index = 0;

        for (int i = -1; i < 2; i++) {
            for (int k = -1; k < 2; k++) {
                colorArray[index] = originalImage[row + i][column + k];
                index++;
            }
        }
    }

    /*
    Here, we are just taking out each color from the pixel, multiplying it with weights and taking total simultaneously
     */
    public Pixel convertWeightedArrayToPixel(int scalingFactor) {
        Pixel pixel;

        int index = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        while (index < 9) { //multiplying the colors with weights and taking total simultaneously
            red += (colorArray[index].red) * weights[index];
            green += (colorArray[index].green) * weights[index];
            blue += (colorArray[index].blue) * weights[index];
            index++;
        }

        /*
        scaling down if required
        -1 scaling factor means no scaling is required
         */
        if(scalingFactor>-1){
            red= scaleDown(red,16,'/'); //calling the scaledown()
            green= scaleDown(green,16,'/');
            blue= scaleDown(blue,16,'/');
        }

        red = checkRGBValue(red);
        green = checkRGBValue(green);
        blue = checkRGBValue(blue);

        pixel = new Pixel(red, green, blue); //returning the resultant weighted pixel
        return pixel;
    }

    /*
    making sure the color values are not beyond the limits
     */
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
