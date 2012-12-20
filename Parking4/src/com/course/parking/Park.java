package com.course.parking;
import java.util.*;

public class Park{
	static int sNum = 0;
	int mID;
	int mPosition;//total position number
	int mEmpty;//empty position number
	ParkingBoy mPB;
	
	public Park(int position) {
		sNum++;
		mID = sNum;
		mPosition = position;
		mEmpty = position;
	}
	
	public boolean getIn(){
		if (mEmpty == 0){
			return false;
		}
		mEmpty--;
		return true;
	}
	
	public boolean getOut(){
		if (mEmpty == mPosition){
			return false;
		}
		mEmpty++;
		return true;
	}
	
	public int getPosition(){
		return mPosition;
	}
	
	public int getEmpty(){
		return mEmpty;
	}
	
	public int getID(){
		return mID;
	}

	void setParkingBoy(ParkingBoy pb){
		mPB = pb;
	}
	
	@Override
	public boolean equals(Object o) {

	     if (this == o) {
		       return true;
		     }

		     if (!(o instanceof Park)) {
		       return false;
		     }

		     Park lhs = (Park) o;

		     return mID == lhs.mID;
	}	
}