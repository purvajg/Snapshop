package com.assignment.snapshop;

// Write your short report here (-2 if there is no report)
/*
The same class ComplexImageFilter class acts as the helper class for all other complex transformations
ComplexImageFilter:
- The loop was looping infinitely, because I had was not incrementing the index in convertWeightedArrayToPixel
- It was a hazzle to match the 3x3 weight array to the pixels, so I just converted the weights 2D array to single
dimensional array
- that gave me an idea to store all the weighted pixels in a single dimensional array too
- then I retrived each color pixel from the pixels and divided the total weight of each color by 16



Extra filters implemented:
- PinkEdgesFilter
- Rainbow Filter
- SaturationFilter
- SharpFilter
- SimpleBlurFilter

Simple conversions like flipHorizontalFilter, flipVerticalFilter, and NegativeFilter class do not require
the ComplexImageFilter class. Hence, not those three classes do not extend ComplexImageFilter class

5x5 filter:
for 5x5 filter , a class called FiveByFiveFilter is created. Other classes like ExampleFiveByFive,
 extend that class

In this class my challenge was to figure out how to use the same 3x3 class for 5x5
I just changed the weight length, color array length, and the loop start and end in the method createColorArray()
 */

import com.assignment.filters.impl.*;

/**
 * A class to configure the SnapShop application
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnapShopConfiguration
{
    /**
     * Method to configure the SnapShop.  Call methods like addFilter
     * and setDefaultFilename here.
     * @param theShop A pointer to the application
     */
    public static void configure(SnapShop theShop)
    {

        theShop.setDefaultFilename("/Users/purvadalvi/Seattle_central_College_Assignments/CSC_142/HomeWork/Assignments/Assignment3/resources/images/billg.jpg");
        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
        theShop.addFilter(new NegativeFilter(), "Negative Filter");
        theShop.addFilter(new GaussianBlur(),"Gaussian Blur");
        theShop.addFilter(new LaplacianFilter(),"Laplacian");
        theShop.addFilter(new UnsharpMaskingFilter(),"Unsharp Masking");
        theShop.addFilter(new Edgy(),"Edgy");

        // add your other filters below
        theShop.addFilter(new PinkEdgesFilter(),"Pink Edges");
        theShop.addFilter(new RainbowFilter(),"Rainbow");
        theShop.addFilter(new SaturaionFilter(),"Saturation");
        theShop.addFilter(new SimpleBlurFilter(),"Simple Blur");
        theShop.addFilter(new SharpFilter(),"Sharp");

        //5x5 filter
        theShop.addFilter(new ExampleFiveByFive(),"ExampleFiveByFive");

    }
}
