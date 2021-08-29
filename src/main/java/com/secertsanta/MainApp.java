package com.secertsanta;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import com.secertsanta.model.FamilyMember;

public class MainApp {
	public static void main(String[] args) throws Exception {
		List<String> fmember = getMemberList();
		SecertSantaPartOne partOne = new SecertSantaPartOne(fmember);
		partOne.getSantaMap().entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});
		
		List<FamilyMember> fmember2 = getMemberListParttwo();
		SecertSantaPartTwo partTwo = new SecertSantaPartTwo(fmember2);
		partTwo.getSantaMap().entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});
		
		
		List<FamilyMember> fmember3 = getMemberListParttwo();
		SecertSantaPartThree partThree = new SecertSantaPartThree(fmember3);
		partThree.getSantaMap().entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});
		
	}
	
	private static List<String> getMemberList() {
		List<String> fmember = new ArrayList<>();
		fmember.add("A");
		fmember.add("B");
		fmember.add("C");
		fmember.add("D");
		fmember.add("E");
		fmember.add("F");
		fmember.add("G");
		return fmember;
	}
	
	private static List<FamilyMember> getMemberListParttwo() {
		List<FamilyMember> fmember = new ArrayList<>();
		Queue<FamilyMember> santaHistory = new CircularFifoQueue<FamilyMember>();
		santaHistory.add(new FamilyMember("B"));
		FamilyMember member = new FamilyMember("A");
		member.setSantaHistory(santaHistory);
		fmember.add(member);
		fmember.add(new FamilyMember("B"));
		fmember.add(new FamilyMember("C"));
		fmember.add(new FamilyMember("D"));
		fmember.add(new FamilyMember("E"));
		fmember.add(new FamilyMember("F"));
		fmember.add(new FamilyMember("G"));
		return fmember;
	}
}
