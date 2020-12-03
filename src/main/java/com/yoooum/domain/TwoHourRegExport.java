package com.yoooum.domain;

import lombok.Data;

@Data
public class TwoHourRegExport
{
	private Integer zeroToTwo;
	private Integer twoAndFour;
	private Integer fourAndSix;
	private Integer sixAndEight;
	private Integer eightAndTen;
	private Integer tenAndTwelve;
	private Integer twelveAndFourteen;
	private Integer fourteenAndSixteeen;
	private Integer sixteeenAndEighteen;
	private Integer eighteenAndTwenty;
	private Integer twentyAndTwentyTwo;
	private Integer twentyTwoAndTwentyFour;

    public TwoHourRegExport(Integer zeroToTwo,
                            Integer twoAndFour, Integer fourAndSix, Integer sixAndEight,
                            Integer eightAndTen, Integer tenAndTwelve,
                            Integer twelveAndFourteen, Integer fourteenAndSixteeen,
                            Integer sixteeenAndEighteen, Integer eighteenAndTwenty,
                            Integer twentyAndTwentyTwo, Integer twentyTwoAndTwentyFour
                           ) {
        super();
        this.zeroToTwo = zeroToTwo;
        this.twoAndFour = twoAndFour;
        this.fourAndSix = fourAndSix;
        this.sixAndEight = sixAndEight;
        this.eightAndTen = eightAndTen;
        this.tenAndTwelve = tenAndTwelve;
        this.twelveAndFourteen = twelveAndFourteen;
        this.fourteenAndSixteeen = fourteenAndSixteeen;
        this.sixteeenAndEighteen = sixteeenAndEighteen;
        this.eighteenAndTwenty = eighteenAndTwenty;
        this.twentyAndTwentyTwo = twentyAndTwentyTwo;
        this.twentyTwoAndTwentyFour = twentyTwoAndTwentyFour;
    }
	
}
