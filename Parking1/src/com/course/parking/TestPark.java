package com.course.parking;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestPark extends TestCase {
	Park mPark;
	static int mID = 0;

	protected void setUp() throws Exception {
		super.setUp();
		mPark= new Park(128);
		mID++;
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetPosition(){
		Assert.assertEquals(mPark.getPosition(), 128);
	}
	
	public void testGetIn() {//and getEmpty()		
		for (int i=1;;i++){
			if(mPark.getIn()==false){ //test return of getIn();
				Assert.assertEquals(i, 129);
				break;
			}
			Assert.assertEquals(mPark.getEmpty(), 128-i);
		}
	}
	
	public void testGetOut() {//and getEmpty()
		for (int i=1;;i++){//make mPark full
			if (mPark.getIn() == false){
				break;
			}
		}
		for (int i=1;;i++){
			if(mPark.getOut()==false){ //test return of getOut();
				Assert.assertEquals(i, 129);
				break;
			}
			Assert.assertEquals(mPark.getEmpty(), i);
		}
	}
	
	public void testGetID(){
		Assert.assertEquals(mPark.getID(), mID);
	}

}
