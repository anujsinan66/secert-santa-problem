package com.secertsanta.model;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;

public class FamilyMember {
	private final String id;

	private Queue<FamilyMember> santaHistory;
    
	public Queue<FamilyMember> getSantaHistory() {
		return santaHistory;
	}

	public void setSantaHistory(Queue<FamilyMember> santaHistory) {
		this.santaHistory = santaHistory;
	}

	public String getId() {
		return id;
	}

    public FamilyMember(String id ) {
        this.id = id;
        this.santaHistory = new CircularFifoQueue<FamilyMember>(3);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember member = (FamilyMember) o;
        return id.equals(member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "FamilyMember{" +
                "id='" + id + '\'' +
                ", SantaHistory=" + getSantaHistory() +
                '}';
    }
}
