package com.secertsanta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author anuj singh
   @class : In this class will choose a Secret Santa for everyone given a list of all the members
    of your extended family. Obviously, a person cannot be their own Secret Santa.
*/
public class SecertSantaPartOne {
	List<String> fMembers;
	public SecertSantaPartOne(List<String> fMembers) {
        this.fMembers = fMembers;
    }
	
	/**
	 * In this method we are trying to rotate family list data on some random number
	 * */
	public Map<String,String> getSantaMap() {
		int sizeOffamily = fMembers.size();
		Map<String, String> santaMap = new HashMap<>(sizeOffamily);
		// generate number that will use to shift the data list excluding 0 and last index value
		int rotateindex = new Random().nextInt(sizeOffamily-1);
		for (int i = 0; i < sizeOffamily; i++) {
            int rotatedIndex = (i + rotateindex + 1) % sizeOffamily;
            santaMap.put(fMembers.get(i), fMembers.get(rotatedIndex));
        }
		return santaMap;
	}

}
