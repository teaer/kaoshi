package com.course.parking;

import java.util.Iterator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestDirector extends TestCase {
	
	Director mDirector;

	protected void setUp() throws Exception {
		super.setUp();
		
		ParkingBoy PB1 = new ParkingBoy();
		PB1.charge(new Park(100));
		PB1.charge(new Park(100));
		
		ParkingBoy PB2 = new ParkingBoy();
		PB2.charge(new Park(100));
		PB2.charge(new Park(100));
		
		SmartParkingBoy smartPB1 = new SmartParkingBoy();
		smartPB1.charge(new Park(100));
		smartPB1.charge(new Park(100));
		
		SmartParkingBoy smartPB2 = new SmartParkingBoy();
		smartPB2.charge(new Park(100));
		smartPB2.charge(new Park(100));
		
		SuperParkingBoy superPB1 = new SuperParkingBoy();
		superPB1.charge(new Park(100));
		superPB1.charge(new Park(100));
		
		SuperParkingBoy superPB2 = new SuperParkingBoy();
		superPB2.charge(new Park(100));
		superPB2.charge(new Park(100));		
		
		Manager mManager1 = new Manager();
		mManager1.charge(superPB1);
		mManager1.charge(PB1);
		mManager1.charge(smartPB1);
		
		Manager mManager2 = new Manager();
		mManager2.charge(superPB2);
		mManager2.charge(PB2);
		mManager2.charge(smartPB2);
		
		for(int i=1; i<=450; i++){
			mManager1.getIn();
			mManager2.getIn();
		}
		
		mDirector = new Director();
		mDirector.charge(mManager1);
		mDirector.charge(mManager2);	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCharge() {
		Assert.assertEquals(mDirector.mManagers.size(),2);
	}

	public void testUncharge() {
		Iterator<Manager> it = mDirector.mManagers.iterator();
		Manager manager = it.next();
		
		mDirector.uncharge(manager);
		
		Assert.assertEquals(mDirector.mManagers.size(),1);
	}

	public void testPrintList() {
		mDirector.printList();
	}

}
