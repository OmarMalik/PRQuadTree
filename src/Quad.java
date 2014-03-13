/*
 *
 */
import java.util.*;
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

/**
 * The Class Quad.
 *
 * @author Omar
 * @version 1
 */
public class Quad
{

    /** The q. */
    static QuadTree<PCity> q;


    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args)
    {
        q = new QuadTree<PCity>();

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
        println(s2.substring(0, s2.length() - 1));
        switch (s[0])
        {
            case "insert":
                if (Integer.parseInt(s[3]) > 1023
                    || Integer.parseInt(s[4]) > 1023
                    || Integer.parseInt(s[3]) < 0 || Integer.parseInt(s[4]) < 0)
                {
                    println("Out of bounds");
                }
                else
                {
                    boolean isInserted =
                        q.insert(new PCity(
                            s[1],
                            Integer.parseInt(s[2]),
                            Integer.parseInt(s[3]),
                            Integer.parseInt(s[4])));
                    if (!isInserted)
                    {
                        println("Duplicate");
                    }
                }
                break;
            case "find":
                PCity temp = null;
                if (s[1].equals("location"))
                {
                    temp =
                        q.find(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
                }
                if (temp == null)
                {
                    println("Not found");
                }
                else
                {
                    println(temp.toString());
                }
                break;
            case "rfind":
                q.rfind(
                    Integer.parseInt(s[1]),
                    Integer.parseInt(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]));
                break;
            case "delete":
                if (Integer.parseInt(s[2]) > 1023
                    || Integer.parseInt(s[3]) > 1023
                    || Integer.parseInt(s[2]) < 0 || Integer.parseInt(s[3]) < 0)
                {
                    println("Not found");
                }
                else
                {

                    if (s[1].equals("location"))
                    {
                        boolean isRemoved =
                            q.remove(
                                Integer.parseInt(s[2]),
                                Integer.parseInt(s[3]));
                        if (!isRemoved)
                        {
                            println("Not found");
                        }
                    }
                }
                break;
            case "tree":
                if (s[1].equals("location"))
                {
                    q.tree();
                }
                break;
            case "makenull":
                q.makenull();
                break;
            default:
                break;
        }
    }


    /**
     * Prints the.
     *
     * @param s
     *            the s
     */
    public static void print(String s)
    {
        System.out.print(s);
    }


    /**
     * Println.
     *
     * @param s
     *            the s
     */
    public static void println(String s)
    {
        System.out.println(s);
    }
}
