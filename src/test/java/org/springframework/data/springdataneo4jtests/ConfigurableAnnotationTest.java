package org.springframework.data.springdataneo4jtests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Tadas Subonis <tadas.subonis@mysnafe.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/applicationContext-testing-commons.xml"})
public class ConfigurableAnnotationTest {

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
    public void testFailingConfigurable1() {
        Person person = new Person();
        assertEquals("some", person.getSomeComponent1().getSome());

        personRepository.save(person);
        Long id = person.getId();

        Person findOne = personRepository.findOne(id);

        assertNotNull(findOne.getSomeComponent1());
        assertEquals("some", findOne.getSomeComponent1().getSome());

    }

    @Test
    public void testFailingConfigurable2() {
        Person person = new Person();
        assertEquals("some", person.getSomeComponent2().getSome());

        personRepository.save(person);
        Long id = person.getId();

        Person findOne = personRepository.findOne(id);
        assertNotNull(findOne.getSomeComponent2());
        assertEquals("some", findOne.getSomeComponent2().getSome());

    }

    @Test
    public void testFailingConfigurable3() {
        Person person = new Person();
        assertEquals("some", person.getSomeComponent3().getSome());

        personRepository.save(person);
        Long id = person.getId();

        Person findOne = personRepository.findOne(id);

        assertNotNull(findOne.getSomeComponent3());
        assertEquals("some", findOne.getSomeComponent3().getSome());

    }

    @Test
    public void testFailingConfigurable4() {
        Person person = new Person();
        assertEquals("some", person.getSomeComponent4().getSome());

        personRepository.save(person);
        Long id = person.getId();

        Person findOne = personRepository.findOne(id);

        assertNotNull(findOne.getSomeComponent4());
        assertEquals("some", findOne.getSomeComponent4().getSome());

    }
}