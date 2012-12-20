package com.course.parking;

import java.util.Iterator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestManager extends TestCase {

	Manager mManager;
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
		
		ParkingBoy PB = new ParkingBoy();
		PB.charge(park1);
		
		SmartParkingBoy smartPB = new SmartParkingBoy();
		smartPB.charge(park2);
		
		SuperParkingBoy superPB = new SuperParkingBoy();
		superPB.charge(park3);
		
		mManager = new Manager();
		mManager.charge(superPB);
		mManager.charge(PB);
		mManager.charge(smartPB);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCharge() {
		Assert.assertEquals(mManager.mPBs.size(),3);
	}

	public void testUncharge() {
		Iterator<ParkingBoy> it = mManager.mPBs.iterator();
		ParkingBoy pb = it.next();
		
		mManager.uncharge(pb);
		
		Assert.assertEquals(mManager.mPBs.size(),2);
	}

	public void testGetIn() {
		mManager.getIn();
		Assert.assertEquals(mManager.getMaxRatePB().getPosition(),30);
		Assert.assertEquals(mManager.getMaxRatePB().getEmpty(),9);
	}

	public void testGetMaxRatePark() {
		Assert.assertEquals(mManager.getMaxRatePB().getPosition(),30);
	}

	public void testGetEmpty() {
		Assert.assertEquals(mManager.getEmpty(),30);
	}

}
