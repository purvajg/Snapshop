package com.assignment.filters.impl;
import com.assignment.pixel.Pixel;
import com.assignment.pixel.PixelImage;

/*This class would be a helper class for all other complex filters like ExampleFiveByFive class
It creates an image given a array of weight and scaling factor.
 */
public class FiveByFiveFilter implements Filter {
    protected int[] weights;
    protected int scalingFactor;
    protected int matrixSize;
    private Pixel[] colorArray;


    public FiveByFiveFilter() {
        this.colorArray = new Pixel[matrixSize*matrixSize];//because 5x5 array, so length is 25
    }

    @Override
    public void filter(PixelImage theImage) {
        Pixel[][] originalImage = theImage.getData();
        Pixel[][] resultImage = theImage.getData();

        for (int row = 2; row < theImage.getHeight() - 2; row++) {
            for (int column = 2; column < theImage.getWidth() - 2; column++) {

                createColorArray(originalImage, row, column);

                Pixel pixel = convertWeightedArrayToPixel(scalingFactor);

                resultImage[row][column] = pixel;

            }
        }

        theImage.setData(resultImage);
    }

    /*
    here we are converting the 5x5 color array from the original image to an array so it would we helpful later to
    multiply it by weights in convertWeightedArrayToPixel()
     */
    public void createColorArray(Pixel[][] originalImage, int row, int column) {
        int index = 0;

        for (int i = -2; i < 3; i++) {
            for (int k = -2; k < 3; k++) {
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

        while (index < 25) { //multiplying the colors with weights and taking total simultaneously
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
