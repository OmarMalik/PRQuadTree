/*
 *
 */
import java.util.ArrayList;

/**
 * The Class QuadTreeTest.
 *
 * @author Omar
 * @version 1
 */
public class QuadTreeTest
    extends student.TestCase
{

    /** The q. */
    QuadTree<PCity>  q;

    /** The cities. */
    ArrayList<PCity> cities;


    /**
     * Test setup.
     */
    public void setUp()
    {
        q = new QuadTree<PCity>();
        cities = new ArrayList<PCity>();

        cities.add(new PCity("a", 0, 100, 100));
        cities.add(new PCity("b", 1, 600, 600));
        cities.add(new PCity("c", 2, 100, 600));
        cities.add(new PCity("d", 3, 600, 100));
        cities.add(new PCity("e", 4, 50, 50));

        cities.add(new PCity("0,0", 5, 0, 0));
        cities.add(new PCity("0,1", 6, 0, 1));
        cities.add(new PCity("1,0", 7, 1, 0));
        cities.add(new PCity("1,1", 8, 1, 1));

        cities.add(new PCity("512", 9, 512, 512));
        cities.add(new PCity("512,800", 10, 512, 800));
        cities.add(new PCity("800,512", 11, 800, 512));
        cities.add(new PCity("1024", 12, 1024, 1024));

        cities.add(new PCity("610,110", 13, 610, 110));

    }


    /**
     * Test insert.
     */
    public void testInsert()
    {
        q.insert(cities.get(0));
        q.insert(cities.get(1));
        q.insert(cities.get(2));
        q.insert(cities.get(3));
        q.insert(cities.get(4));

        // origin:
        q.insert(cities.get(5));
        q.insert(cities.get(6));
        q.insert(cities.get(7));
        q.insert(cities.get(8));

        // more cases
        q.insert(cities.get(9));
        q.insert(cities.get(10));
        q.insert(cities.get(11));
        q.insert(cities.get(12));

        q.insert(cities.get(13));

        System.out.println("Tree with ALL cities: ");
        q.tree();
        assertEquals(q.find(100, 100).name, "a");

    }


    /**
     * Test find.
     */
    public void testFind()
    {
        PCity emptyTreeCity = q.find(100, 100);
        assertEquals(emptyTreeCity, null);

        q.insert(cities.get(0));
        q.insert(cities.get(1));
        q.insert(cities.get(2));
        q.insert(cities.get(3));
        q.insert(cities.get(4));

        PCity c1 = q.find(100, 600);
        assertEquals(c1.x, 100);
        assertEquals(c1.y, 600);

        PCity e1 = q.find(50, 50);
        assertEquals(e1.x, 50);
        assertEquals(e1.y, 50);

        PCity nullCity = q.find(1025, 500);
        assertEquals(nullCity, null);

    }


    /**
     * Test rfind.
     */
    public void testRfind()
    {
        q.insert(cities.get(0));
        q.insert(cities.get(1));
        q.insert(cities.get(2));
        q.insert(cities.get(3));
        q.insert(cities.get(4));

        // origin:
        q.insert(cities.get(5));
        q.insert(cities.get(6));
        q.insert(cities.get(7));
        q.insert(cities.get(8));

        // more cases
        q.insert(cities.get(9));
        q.insert(cities.get(10));
        q.insert(cities.get(11));
        q.insert(cities.get(12));

        q.insert(cities.get(13));

        System.out.println("RFIND 1: ");
        q.rfind(99, 99, 600, 600);

        System.out.println("RFIND 2:");
        q.rfind(300, 300, 600, 600);

        assertEquals(q.find(100, 100).name, "a");
    }


    /**
     * Test tree.
     */
    public void testTree()
    {

        q.insert(cities.get(0));
        q.insert(cities.get(1));
        q.insert(cities.get(2));
        q.insert(cities.get(3));
        q.insert(cities.get(4));

        q.tree();

        assertEquals(q.find(100, 100).name, "a");

    }


    /**
     * Test delete.
     */
    public void testDelete()
    {
        System.out.println("TEST DELTE*********************************");
        q.insert(cities.get(0));
        // q.find(100, 100);
        q.tree();

        System.out.println("DELTEING 100, 100");

        q.remove(100, 100);
        q.find(100, 100);
        System.out.println("Not found");
        q.tree();

        q.insert(cities.get(0));
        assertEquals(q.find(100, 100).name, "a");
    }


    /**
     * Test coverage
     */
    public void testCoverage()
    {
        q.insert(cities.get(0));
        assertEquals(q.find(100, 100).name, "a");

    }
}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
