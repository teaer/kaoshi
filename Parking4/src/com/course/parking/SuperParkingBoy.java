package com.course.parking;

import java.util.Iterator;

public class SuperParkingBoy extends ParkingBoy {
	Park getMaxRatePark(){
		if(mParks.size() == 0){
			return null;
		}
		Iterator<Park> it = mParks.iterator();
		Park maxEmptyPark = it.next();
		System.out.println(maxEmptyPark.getPosition());
		while(it.hasNext()){
			Park park = it.next();
			System.out.println(park.getPosition());
			if ((float)maxEmptyPark.getEmpty()/(float)maxEmptyPark.getPosition() < (float)park.getEmpty()/(float)park.getPosition()){
				maxEmptyPark = park;
				//System.out.println(park.getPosition());
			}
		}
		if(maxEmptyPark.getEmpty() == 0){
			return null;
		}
		return maxEmptyPark;
	}
	
	@Override
	boolean getIn() {
		Park park = getMaxRatePark();
		if (park == null){
			return false;
		}
		return park.getIn();
	}
}
