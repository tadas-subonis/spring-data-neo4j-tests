package org.springframework.data.springdataneo4jtests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tadas Subonis <tadas.subonis@mysnafe.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/applicationContext-testing-commons.xml"})
@Transactional
public class RelationSavingTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private Neo4jTemplate template;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addLike method, of class LikenessFacade.
     */
    @Test
    public void testSaving() {
        Person first = new Person("first");
        Person second = new Person("second");

        Like like = new Like(second, first);
        Like like2 = new Like(first, second);


        first.addLike(like);
        second.addLike(like2);

        assertEquals(1, first.getLikes().size());
        assertEquals(1, second.getLikes().size());

        personRepository.save(first);
        personRepository.save(second);

        Long firstId = first.getId();
        Long secondId = second.getId();

        Person findFirst = personRepository.findOne(firstId);
        Person findSecond = personRepository.findOne(secondId);

        assertEquals(1, findFirst.getLikes().size());
        assertEquals(1, findSecond.getLikes().size());

    }

    @Test
    public void testSavingSecond() {
        Person first = new Person("first");
        Person second = new Person("second");


        Like like = new Like(second, first);
        Like like2 = new Like(first, second);


        first.addLike(like);
        second.addLike(like2);

        assertEquals(1, first.getLikes().size());
        assertEquals(1, second.getLikes().size());


        GraphRepository<Like> likesRepository = template.
                repositoryFor(Like.class);

        template.save(first);
        template.save(second);

        likesRepository.save(first.getLikes());
        likesRepository.save(second.getLikes());

        Long firstId = first.getId();
        Long secondId = second.getId();

        Person findFirst = personRepository.findOne(firstId);
        Person findSecond = personRepository.findOne(secondId);

        assertEquals(1, findFirst.getLikes().size());
        assertEquals(1, findSecond.getLikes().size());

    }
}