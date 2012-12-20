package com.course.parking;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Manager {
	static int sNum = 0;
	int mID;
	Set<ParkingBoy> mPBs = new HashSet<ParkingBoy>();
	SuperParkingBoy mSPB = new SuperParkingBoy();//works as a super parking boy while manage cars directly.
	
	Manager(){
		sNum++;
		mID = sNum;
	}
	
	int getID(){
		return mID;
	}
	
	void charge(ParkingBoy pb){
		if(mPBs.add(pb)==true){
			pb.setManager(this);
		}
	}
	
	void uncharge(ParkingBoy pb){
		if(mPBs.remove(pb)==true){
			pb.setManager(null);
		}
	}
	
	ParkingBoy getMaxRatePB(){
		if(mPBs.size() == 0){
			return null;
		}
		Iterator<ParkingBoy> it = mPBs.iterator();
		ParkingBoy maxRatePB = it.next();
		while(it.hasNext()){
			ParkingBoy pb = it.next();
			if ((float)maxRatePB.getEmpty()/(float)maxRatePB.getPosition() < (float)pb.getEmpty()/(float)pb.getPosition()){
				maxRatePB = pb;
			}
		}
		if(maxRatePB.getEmpty() == 0){
			return null;
		}
		return maxRatePB;
	}
	
	boolean getIn() {
		ParkingBoy pb = getMaxRatePB();
		if (pb == null){
			return false;
		}
		return pb.getIn();
	}
	
	int getEmpty(){
		int empty = 0;
		Iterator<ParkingBoy> it = mPBs.iterator();
		while(it.hasNext()){
			empty += it.next().getEmpty();
		}
		return empty;
	}
	
	int getPosition(){
		int postion = 0;
		Iterator<ParkingBoy> it = mPBs.iterator();
		while(it.hasNext()){
			postion += it.next().getPosition();
		}
		return postion;
	}
}
