/*
 *
 */
import java.io.*;
import student.TestCase;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class bstTest.
 *
 * @author Omar
 * @version 1
 */
public class bstTest
    extends TestCase
{

    /**
     * Test main.
     */
    public void testMain()
    {
        try
        {
            String input = "";
            Scanner s1 = new Scanner(new FileInputStream("myTest.txt"));
            while (s1.hasNextLine())
            {
                input = input + s1.nextLine();
                input = input + "\n";
            }
            setSystemIn(input);
            bst.main(null);
            String output = "";
            Scanner sc2 = new Scanner(new FileInputStream("myTestOutput.txt"));
            while (sc2.hasNextLine())
            {
                output = output + sc2.nextLine();
                output = output + "\n";

            }
            assertEquals(output, systemOut().getHistory());

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
