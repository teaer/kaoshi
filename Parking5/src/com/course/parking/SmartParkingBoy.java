package com.course.parking;

import java.util.Iterator;

public class SmartParkingBoy extends ParkingBoy {
	
	Park getMaxEmptyPark(){
		if(mParks.size() == 0){
			return null;
		}
		Iterator<Park> it = mParks.iterator();
		Park maxEmptyPark = it.next();
		while(it.hasNext()){
			Park park = it.next();
			if (maxEmptyPark.getEmpty() < park.getEmpty()){
				maxEmptyPark = park;
			}
		}
		if(maxEmptyPark.getEmpty() == 0){
			return null;
		}
		return maxEmptyPark;
	}
	
	@Override
	boolean getIn() {
		Park park = getMaxEmptyPark();
		if (park == null){
			return false;
		}
		return park.getIn();
	}

}
