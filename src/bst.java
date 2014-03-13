// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than the instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction

import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
// -------------------------------------------------------------------------
/**
 * Scans in commands and executes them.
 *
 * @author Omar
 * @version Feb 13, 2014
 */
public class bst
{

    /** popBst. */
    static BinarySearchTree<City> popBst;

    /** nameBst. */
    static BinarySearchTree<City> nameBst;


    /**
     * main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args)
    {
        nameBst = new BinarySearchTree<City>(new NameComp());
        popBst = new BinarySearchTree<City>(new PopComp());

        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            String s = in.nextLine();
            String[] tokens = s.split(" ");
            while (tokens[0].equals("#"))
            {
                s = in.nextLine();
                tokens = s.split(" ");
            }
            command(tokens);

        }
    }


    /**
     * Command.
     *
     * @param s
     *            the s
     */
    public static void command(String[] s)
    {
        String s2 = "";
        for (String toPrint : s)
        {
            s2 += toPrint + " ";
        }
        System.out.println(s2.substring(0, s2.length() - 1));
        switch (s[0])
        {
            case "find":
                City c = new City(null, 0, null);
                if (s[1].equals("name"))
                {
                    c.setName(s[2]);
                    ArrayList<City> foundCity = nameBst.find(c);
                    if (foundCity.isEmpty())
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        for (City c0 : foundCity)
                        {
                            System.out.println(c0.toString());
                        }
                    }
                }
                else
                {
                    c.setPopulation(Integer.parseInt(s[2]));
                    ArrayList<City> foundCity = popBst.find(c);
                    if (foundCity.isEmpty())
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        for (City c0 : foundCity)
                        {
                            System.out.println(c0.toString());
                        }
                    }
                }
                break;
            case "delete":
                if (s[1].equals("name"))
                {
                    ArrayList<City> deleteList =
                        nameBst.find(new City(s[2], 0, null));
                    if (deleteList.isEmpty())
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        for (City c0 : deleteList)
                        {
                            popBst.delete(c0);
                            nameBst.delete(c0);
                        }
                    }
                }
                else
                {
                    ArrayList<City> deleteList =
                        popBst
                            .find(new City(null, Integer.parseInt(s[2]), null));
                    if (deleteList.isEmpty())
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        for (City c0 : deleteList)
                        {
                            popBst.delete(c0);
                            nameBst.delete(c0);
                        }
                    }
                }
                break;
            case "insert":
                City toInsert0 = new City(s[1], Integer.parseInt(s[2]), s[3]);
                nameBst.insert(toInsert0);
                popBst.insert(toInsert0);
                break;
            case "tree":
                if (s[1].equals("name"))
                {
                    nameBst.tree();
                }
                else
                {
                    popBst.tree();
                }
                break;
            case "findKth":
                if (s[1].equals("name"))
                {
                    if (nameBst.findKth(Integer.parseInt(s[2])) == null)
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        System.out.println(nameBst.findKth(
                            Integer.parseInt(s[2])).toString());
                    }
                }
                else
                {
                    if (popBst.findKth(Integer.parseInt(s[2])) == null)
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        System.out.println(popBst.findKth(
                            Integer.parseInt(s[2])).toString());
                    }
                }
                break;
            case "findRange":
                if (s[1].equals("name"))
                {
                    ArrayList<City> found =
                        nameBst.findRange(new City(s[2], 0, null), new City(
                            s[3],
                            0,
                            null));
                    if (found.isEmpty())
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        for (City c0 : found)
                        {
                            System.out.println(c0.toString());
                        }
                    }
                }
                else
                {
                    int abc = Integer.parseInt(s[2]);
                    int def = Integer.parseInt(s[3]);
                    City abcc = new City(null, abc, null);
                    City defc = new City(null, def, null);
                    ArrayList<City> found = popBst.findRange(abcc, defc);
                    if (found.isEmpty())
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        for (City c0 : found)
                        {
                            System.out.println(c0.toString());
                        }
                    }
                }
                break;
            case "makenull":
                popBst.makenull();
                nameBst.makenull();
                break;
            case "sort":
                ArrayList<City> sortedList = new ArrayList<City>();
                if (s[1].equals("name"))
                {
                    sortedList = nameBst.sort();
                }
                else
                {
                    sortedList = popBst.sort();
                }
                if (sortedList.isEmpty())
                {
                    System.out.println("Database Empty");
                }
                else
                {
                    for (City c0 : sortedList)
                    {
                        System.out.println(c0.toString());
                    }
                }

                break;
            default:
                break;
        }
    }
}
