package org.springframework.data.springdataneo4jtests;

import java.util.HashSet;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

/**
 *
 * @author Tadas Subonis <tadas.subonis@mysnafe.com>
 */
@NodeEntity
@Configurable(dependencyCheck = true)
public class Person {

    @GraphId
    private Long id;
    private String name;
    @Autowired
    @Transient
    private SomeComponent someComponent1;
    @Transient
    @Autowired
    transient private SomeComponent someComponent2;
    @Autowired
    transient private SomeComponent someComponent3;
    @javax.persistence.Transient
    @Autowired
    private SomeComponent someComponent4;
    @RelatedToVia(type = "LIKE", direction = Direction.INCOMING)
    @Fetch
    private Set<Like> likes = new HashSet<Like>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public void addLike(Like like) {
        likes.add(like);
    }

    public SomeComponent getSomeComponent1() {
        return someComponent1;
    }

    public SomeComponent getSomeComponent2() {
        return someComponent2;
    }

    public SomeComponent getSomeComponent3() {
        return someComponent3;
    }

    public SomeComponent getSomeComponent4() {
        return someComponent4;
    }
}
