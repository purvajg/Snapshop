package com.assignment.snapshop;

// Write your short report here (-2 if there is no report)

import com.assignment.filters.impl.FlipHorizontalFilter;
import com.assignment.filters.impl.FlipVerticalFilter;
import com.assignment.filters.impl.NegativeFilter;

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

        // add your other filters below
    }
}
