package com.course.parking;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestSuperParkingBoy extends TestCase {

	SuperParkingBoy mSuperPB;
	protected void setUp() throws Exception {
		super.setUp();
		
		Park park1 = new Park(40);
		Park park2 = new Park(30);
		Park park3 = new Park(60);
		
		for(int i=1;i<=30;i++){
			park1.getIn();
		}
		
		for(int i=1;i<=20;i++){
			park2.getIn();
		}
		
		for(int i=1;i<=50;i++){
			park3.getIn();
		}
		
		mSuperPB = new SuperParkingBoy();
		mSuperPB.charge(park1);
		mSuperPB.charge(park2);
		mSuperPB.charge(park3);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetIn() {
		mSuperPB.getIn();
		Assert.assertEquals(mSuperPB.getMaxRatePark().getPosition(),30);
		Assert.assertEquals(mSuperPB.getMaxRatePark().getEmpty(),9);
	}

	public void testGetMaxRatePark() {
		Assert.assertEquals(mSuperPB.getMaxRatePark().getPosition(),30);
	}

}
