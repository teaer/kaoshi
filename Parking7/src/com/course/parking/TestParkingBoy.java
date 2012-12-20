package com.course.parking;

import java.util.Iterator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestParkingBoy extends TestCase {
	
	ParkingBoy mPB;
	
	protected void setUp() throws Exception {
		super.setUp();
		mPB = new ParkingBoy();
		for(int i=1;i<=50;i++){//charge 50 parks
			Park park = new Park(128);
			mPB.charge(park);
		}
		for(int i=1;i<=300;i++){//get in 300 cars
			mPB.getIn();
		}
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCharge() {
		Assert.assertEquals(mPB.mParks.size(), 50);
	}

	public void testUncharge() {
		Iterator<Park> it = mPB.mParks.iterator();
		while(it.hasNext()){
			Park park = it.next();
			if(park.getID()%2 == 0){
				mPB.uncharge(park);
				it = mPB.mParks.iterator();//rebuild iterator after remove
			}
		}
		Assert.assertEquals(mPB.mParks.size(), 25);
	}

	public void testGetIn() {
		Iterator<Park> it = mPB.mParks.iterator();
		Assert.assertEquals(it.next().getEmpty(), 0);
		Assert.assertEquals(it.next().getEmpty(), 0);
		Assert.assertEquals(it.next().getEmpty(), 128-(300-128*2));
	}

	public void testGetOut() {
		Iterator<Park> it = mPB.mParks.iterator();
		mPB.getOut(it.next());
		mPB.getOut(it.next());	
		mPB.getOut(it.next());
		it = mPB.mParks.iterator();
		Assert.assertEquals(it.next().getEmpty(), 1);
		Assert.assertEquals(it.next().getEmpty(), 1);
		Assert.assertEquals(it.next().getEmpty(), 128-(300-128*2)+1);
	}

}
