package com.course.parking;
import java.util.*;

public class ParkingBoy{
	static int sNum = 0;
	int mID;
	Set<Park> mParks = new HashSet<Park>();
	
	ParkingBoy(){
		sNum++;
		mID = sNum;
	}
	
	int getID(){
		return mID;
	}
	
	void charge(Park park){
		if(mParks.add(park)==true){
			park.setParkingBoy(this);
		}
	}
	
	void uncharge(Park park){
		if(mParks.remove(park)==true){
			park.setParkingBoy(null);
		}
	}
	
	boolean getIn(){
		Iterator<Park> it = mParks.iterator();
		while(it.hasNext()){
			Park park = it.next();
			if(park.getEmpty()>0){
				park.getIn();
				return true;
			}
		}
		return false;
	}
	
	boolean getOut(Park park){
		if(park.getEmpty() < park.getPosition()){
			park.getOut();
			return true;
		}
		return false;
	}
	
	int getEmpty(){
		int empty = 0;
		Iterator<Park> it = mParks.iterator();
		while(it.hasNext()){
			empty += it.next().getEmpty();
		}
		return empty;
	}
		
}