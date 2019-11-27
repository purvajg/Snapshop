package com.assignment.snapshop;

// Write your short report here (-2 if there is no report)
/*
Gaussian blur:
- The loop was looping infinitely, because I had was not incrementing the index in convertWeightedArrayToPixel
- It was a hazzle to match the 3x3 weight array to the pixels, so I just converted the weights 2D array to single
dimensional array
- that gave me an idea to store all the weighted pixels in a single dimensional array too
- then I retrived each color pixel from the pixels and divided the total weight of each color by 16


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
        theShop.addFilter(new PinkEdgesFilter(),"Pink Edges");
        theShop.addFilter(new RainbowFilter(),"Rainbow");
        theShop.addFilter(new SaturaionFilter(),"Saturation");
        theShop.addFilter(new SimpleBlurFilter(),"Simple Blur");
        theShop.addFilter(new SharpFilter(),"Sharp");


        // add your other filters below
    }
}
