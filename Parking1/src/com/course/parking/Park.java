package com.course.parking;
import java.util.*;

public class Park{
	static int sNum = 0;
	int mID;
	int mPosition;//total position number
	int mEmpty;//empty position number
	
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
}