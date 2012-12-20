package com.course.parking;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestSmartParkingBoy extends TestCase {
	
	SmartParkingBoy mSmartPB;

	protected void setUp() throws Exception {
		super.setUp();
		
		Park park1 = new Park(128);
		Park park2 = new Park(128);
		Park park3 = new Park(128);
		
		for(int i=1;i<=30;i++){
			park1.getIn();
		}
		
		for(int i=1;i<=20;i++){
			park2.getIn();
		}
		
		for(int i=1;i<=50;i++){
			park3.getIn();
		}
		
		mSmartPB = new SmartParkingBoy();
		mSmartPB.charge(park1);
		mSmartPB.charge(park2);
		mSmartPB.charge(park3);		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetIn() {
		mSmartPB.getIn();
		Assert.assertEquals(mSmartPB.getMaxEmptyPark().getEmpty(),107);
	}

	public void testGetMaxEmptyPark() {
		Assert.assertEquals(mSmartPB.getMaxEmptyPark().getEmpty(),108);
	}

}
