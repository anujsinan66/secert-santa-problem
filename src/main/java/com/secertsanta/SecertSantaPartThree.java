package com.secertsanta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.secertsanta.model.FamilyMember;

import repository.FamilyRepositoryImp;

/**
 * @author anuj singh
   @class : Families usually get gifts for members of their immediate family, so it
doesn’t make a lot of sense for anyone to be a Secret Santa for a member of their
immediate family (spouse, parents, or children). Modify your program to take this
constraint into consideration when choosing Secret Santas..
*/	
public class SecertSantaPartThree {
	
    private List<FamilyMember> fMembers;
    private FamilyRepositoryImp familyRepositoryImp =  new FamilyRepositoryImp();
    public SecertSantaPartThree(List<FamilyMember> fMembers) {
        this.fMembers = fMembers;
    }
    
    /**
	 * In this method we are trying to rotate family list data on some random number and filtering members in a condition that is  
	 * family member can only have the same Secret Santa  once every 3 years and 
	 * filtering immediate family members.
	 * */
	public Map<FamilyMember,FamilyMember> getSantaMap() throws Exception {
		int sizeOffamily = fMembers.size();
		Map<FamilyMember, FamilyMember> santaMap = new HashMap<>(sizeOffamily);
		// generate number that will use to shift the data list excluding 0 and last index value
		int rotateindex = new Random().nextInt(sizeOffamily-1);
		for (int i = 0; i < sizeOffamily; i++) {
            int rotatedIndex = (i + rotateindex + 1) % sizeOffamily;
            FamilyMember fmember = fMembers.get(i);
            FamilyMember member= getMember(rotatedIndex,fmember);
            santaMap.put(fmember, member);
        }
		return santaMap;
	}
	
	/**
	 * In this method: we are searching santa for each family member.
	 * @param rotatedIndex : starting index from where are looking for santa
	 * @param fMember : family member for which we are searching santa.
	 * */
	private FamilyMember getMember(int rotatedIndex,FamilyMember fMember ) throws Exception {
		int sizeOffamily = fMembers.size();
		int nextMember = 0;
		while( nextMember < sizeOffamily) {
			Integer nextSelection = (rotatedIndex + nextMember) % sizeOffamily;
			FamilyMember newMember = fMembers.get(nextSelection);
			// member can't be santa for itself.
			if( newMember.equals(fMember)) {
				nextMember ++;
				continue;
			}
			// filtering members in a condition that is  family member can only have the same Secret Santa  once every 3 years
			if(fMember.getSantaHistory().isEmpty() || !fMember.getSantaHistory().contains(newMember)) {
				 // filtering immediate family members.
				if(familyRepositoryImp.isImmediateFamilyMember(fMember, newMember)) {
					nextMember ++;
					continue;
				}
				return newMember;
			}else {
				nextMember ++;
				continue;
			}
		}
		throw new Exception("Couldn't find a santa for member " + fMember);
	}
}
