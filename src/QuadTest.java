/*
 *
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class QuadTest.
 *
 * @author Omar
 * @version 1
 */
public class QuadTest
    extends student.TestCase
{

    /**
     * Test main.
     *
     * @author Omar
     * @version 1
     */
    public void testMain()
    {
        try
        {
            String input = "";
            Scanner s1 = new Scanner(new FileInputStream("myQuadTest.txt"));
            while (s1.hasNextLine())
            {
                input = input + s1.nextLine();
                input = input + "\n";
            }
            setSystemIn(input);
            Quad.main(null);
            String output = "";
            Scanner sc2 =
                new Scanner(new FileInputStream("myQuadTestOutput.txt"));
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
