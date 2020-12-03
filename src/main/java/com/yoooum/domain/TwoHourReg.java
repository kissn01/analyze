package com.yoooum.domain;

import lombok.Data;

@Data
public class TwoHourReg
{
	private String myDate;
	private Integer peopleNum;
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
    private Integer platformId;

    public TwoHourReg(String myDate, Integer peopleNum, Integer zeroToTwo,
                      Integer twoAndFour, Integer fourAndSix, Integer sixAndEight,
                      Integer eightAndTen, Integer tenAndTwelve,
                      Integer twelveAndFourteen, Integer fourteenAndSixteeen,
                      Integer sixteeenAndEighteen, Integer eighteenAndTwenty,
                      Integer twentyAndTwentyTwo, Integer twentyTwoAndTwentyFour,
                      Integer platformId) {
        super();
        this.myDate = myDate;
        this.peopleNum = peopleNum;
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
        this.platformId = platformId;
    }
	
}
