// TODO: Auto-generated Javadoc
/**
 * The Class PCity.
 *
 * @author Omar
 * @version 1
 */
public class PCity
    extends Point
{

    /** The name. */
    String name;

    /** The population. */
    int    population;


    /**
     * Instantiates a new p city.
     *
     * @param name0
     *            the name0
     * @param pop
     *            the pop
     * @param x0
     *            the x0
     * @param y0
     *            the y0
     */
    public PCity(String name0, int pop, int x0, int y0)
    {
        super(x0, y0);
        name = name0;
        population = pop;
    }


    /**
     * to string method
     *
     * @return the string
     */
    public String toString()
    {
        return name + " " + population + " (" + x + ", " + y + ")";
    }
}
