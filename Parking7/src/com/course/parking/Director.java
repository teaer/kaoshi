package com.course.parking;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Director {
	Set<Manager> mManagers = new HashSet<Manager>();
	
	void charge(Manager manager){
		if(mManagers.add(manager)==true){
			manager.setDirector(this);
		}
	}
	
	void uncharge(Manager manager){
		if(mManagers.remove(manager)==true){
			manager.setDirector(null);
		}
	}
	
	void print(Park park){
		System.out.println("        停车场编号："+park.getID());
		System.out.println("        车位数："+park.getPosition());
		System.out.println("        空位数："+park.getEmpty());
	}
	
	void print(ParkingBoy pb){
		System.out.println("    停车仔编号："+pb.getID());
		System.out.println("    总车位数："+pb.getPosition());
		System.out.println("    总空位数："+pb.getEmpty());
		Iterator<Park> it = pb.mParks.iterator();
		while(it.hasNext()){
			print(it.next());
		}
	}
	
	void print(Manager manager){
		System.out.println("经理编号："+manager.getID());
		System.out.println("总车位数："+manager.getPosition());
		System.out.println("总空位数："+manager.getEmpty());
		
		Iterator<Park> it = manager.mSelf.mParks.iterator();
		while(it.hasNext()){
			print(it.next());
		}
		
		Iterator<ParkingBoy> it2 = manager.mPBs.iterator();
		while(it2.hasNext()){
			print(it2.next());
		}
	}
	
	void printList(){
		Iterator<Manager> it = mManagers.iterator();
		while(it.hasNext()){
			print(it.next());
		}
	}
}
