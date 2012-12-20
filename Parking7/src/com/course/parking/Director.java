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
		System.out.println("        ͣ������ţ�"+park.getID());
		System.out.println("        ��λ����"+park.getPosition());
		System.out.println("        ��λ����"+park.getEmpty());
	}
	
	void print(ParkingBoy pb){
		System.out.println("    ͣ���б�ţ�"+pb.getID());
		System.out.println("    �ܳ�λ����"+pb.getPosition());
		System.out.println("    �ܿ�λ����"+pb.getEmpty());
		Iterator<Park> it = pb.mParks.iterator();
		while(it.hasNext()){
			print(it.next());
		}
	}
	
	void print(Manager manager){
		System.out.println("�����ţ�"+manager.getID());
		System.out.println("�ܳ�λ����"+manager.getPosition());
		System.out.println("�ܿ�λ����"+manager.getEmpty());
		
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
