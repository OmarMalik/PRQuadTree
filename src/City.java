/*
 *
 */
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class City.
 *
 * @author Omar
 * @version 1
 */
public class City
{

    /** The name. */
    private String name;

    /** The population. */
    private int    population;

    /** The payload. */
    private String payload;


    /**
     * Instantiates a new city.
     *
     * @param n
     *            the n
     * @param p
     *            the p
     * @param pl
     *            the pl
     */
    public City(String n, int p, String pl)
    {
        setName(n);
        setPopulation(p);
        setPayload(pl);
    }


    // getters and setters
    /**
     * Sets the payload.
     *
     * @param payload
     *            the new payload
     */
    public void setPayload(String payload)
    {
        this.payload = payload;
    }


    /**
     * Population.
     *
     * @return the int
     */
    public int population()
    {
        return population;
    }


    /**
     * Sets the population.
     *
     * @param population
     *            the new population
     */
    public void setPopulation(int population)
    {
        this.population = population;
    }


    /**
     * Name.
     *
     * @return the string
     */
    public String name()
    {
        return name;
    }


    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name)
    {
        this.name = name;
    }


    /**
     * ToString.
     *
     * @return String
     */
    public String toString()
    {
        return name + " " + population + " " + payload;
    }

}
