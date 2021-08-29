package com.secertsanta.repository;

import java.util.List;

import com.secertsanta.model.Relation;

public interface FamilyRepository<T> {
	    void addImmediateMember(T source, T destination, Relation relation);
	    boolean isImmediateFamilyMember(T source, T destination);
}
