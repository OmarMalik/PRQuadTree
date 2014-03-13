/*
 *
 */
import java.util.ArrayList;
import student.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class BinarySearchTreeTest.
 *
 * @author Omar
 * @version 1
 */
public class BinarySearchTreeTest
    extends TestCase
{

    /** The pop bst. */
    static BinarySearchTree<City> popBst;

    /** The name bst. */
    static BinarySearchTree<City> nameBst;

    /** The output. */
    static String                 output;

    /** The cities. */
    static ArrayList<City>        cities;


    /**
     * test setup.
     */
    public void setUp()
    {
        cities = new ArrayList<City>();
        cities.add(new City("a", 1, ""));
        cities.add(new City("b", 2, ""));
        cities.add(new City("c", 3, ""));
        cities.add(new City("d", 4, ""));

        output = "";
        popBst = new BinarySearchTree<City>(new PopComp());
        nameBst = new BinarySearchTree<City>(new NameComp());

        for (City c : cities)
        {
            popBst.insert(c);
            nameBst.insert(c);
        }

    }


    /**
     * Test find.
     */
    public void testFind()
    {
        String out = "a 1 \nb 2 \nc 3 \n";
        popBst.makenull();
        for (City c : cities)
        {
            popBst.insert(c);
        }

        ArrayList<City> found =
            popBst.findRange(new City(null, 1, null), new City(null, 3, null));
        for (City c0 : found)
        {
            System.out.println(c0.toString());
        }
        assertEquals(out, systemOut().getHistory());

    }


    /**
     * Test find kth.
     */
    public void testFindKth()
    {
        String out = "a 1 \nb 2 \nc 3 \n";
        popBst.makenull();
        for (City c : cities)
        {
            popBst.insert(c);
        }

        ArrayList<City> found =
            popBst.findRange(new City(null, 1, null), new City(null, 3, null));
        for (City c0 : found)
        {
            System.out.println(c0.toString());
        }
        assertEquals(out, systemOut().getHistory());
    }


    /**
     * Test find range.
     */
    public void testFindRange()
    {
        String out = "a 1 \nb 2 \nc 3 \n";
        popBst.makenull();
        for (City c : cities)
        {
            popBst.insert(c);
        }

        ArrayList<City> found =
            popBst.findRange(new City(null, 1, null), new City(null, 3, null));
        for (City c0 : found)
        {
            System.out.println(c0.toString());
        }
        assertEquals(out, systemOut().getHistory());

    }


    /**
     * Test insert.
     */
    public void testInsert()
    {
        String out = "a 1 \nb 2 \nc 3 \n";
        popBst.makenull();
        for (City c : cities)
        {
            popBst.insert(c);
        }

        ArrayList<City> found =
            popBst.findRange(new City(null, 1, null), new City(null, 3, null));
        for (City c0 : found)
        {
            System.out.println(c0.toString());
        }
        assertEquals(out, systemOut().getHistory());

    }


    /**
     * Test delete.
     */
    public void testDelete()
    {
        String out = "a 1 \nb 2 \nc 3 \n";
        popBst.makenull();
        for (City c : cities)
        {
            popBst.insert(c);
        }

        ArrayList<City> found =
            popBst.findRange(new City(null, 1, null), new City(null, 3, null));
        for (City c0 : found)
        {
            System.out.println(c0.toString());
        }
        assertEquals(out, systemOut().getHistory());
    }


    /**
     * Test sort.
     */
    public void testSort()
    {
        String out = "a 1 \nb 2 \nc 3 \n";
        popBst.makenull();
        for (City c : cities)
        {
            popBst.insert(c);
        }

        ArrayList<City> found =
            popBst.findRange(new City(null, 1, null), new City(null, 3, null));
        for (City c0 : found)
        {
            System.out.println(c0.toString());
        }
        assertEquals(out, systemOut().getHistory());

    }


    /**
     * Test makenull.
     */
    public void testMakenull()
    {
        String out = "a 1 \nb 2 \nc 3 \n";
        popBst.makenull();
        for (City c : cities)
        {
            popBst.insert(c);
        }

        ArrayList<City> found =
            popBst.findRange(new City(null, 1, null), new City(null, 3, null));
        for (City c0 : found)
        {
            System.out.println(c0.toString());
        }
        assertEquals(out, systemOut().getHistory());
    }


    /**
     * Test tree.
     */
    public void testTree()
    {
        String out = "a 1 \nb 2 \nc 3 \n";
        popBst.makenull();
        for (City c : cities)
        {
            popBst.insert(c);
        }

        ArrayList<City> found =
            popBst.findRange(new City(null, 1, null), new City(null, 3, null));
        for (City c0 : found)
        {
            System.out.println(c0.toString());
        }
        assertEquals(out, systemOut().getHistory());

    }

}
