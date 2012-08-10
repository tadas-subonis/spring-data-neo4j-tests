package org.springframework.data.springdataneo4jtests;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 *
 * @author Tadas Subonis <tadas.subonis@mysnafe.com>
 */
@RelationshipEntity(type = "LIKE")
public class Like {

    @GraphId
    Long id;
    @StartNode
    @Fetch
    private Person personFrom;
    @EndNode
    @Fetch
    private Person personTo;
    @Fetch
    @GraphProperty
    private Double currentRating = 0.0;

    public Like() {
    }

    public Like(Person personFrom, Person personTo) {
        this.personFrom = personFrom;
        this.personTo = personTo;
    }

    public Long getId() {
        return id;
    }

    public Person getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(Person personFrom) {
        this.personFrom = personFrom;
    }

    public Person getPersonTo() {
        return personTo;
    }

    public void setPersonTo(Person personTo) {
        this.personTo = personTo;
    }

    public Double getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(Double currentRating) {
        this.currentRating = currentRating;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.personFrom != null ? this.personFrom.hashCode() : 0);
        hash = 79 * hash + (this.personTo != null ? this.personTo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Like other = (Like) obj;
        if (this.personFrom != other.personFrom && (this.personFrom == null || !this.personFrom.equals(other.personFrom))) {
            return false;
        }
        if (this.personTo != other.personTo && (this.personTo == null || !this.personTo.equals(other.personTo))) {
            return false;
        }
        return true;
    }
}
