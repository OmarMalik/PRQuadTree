/*
 *
 */
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class nameComp.
 *
 * @author Omar
 * @version 1
 */
public class NameComp
    implements Comparator<City>
{

    // ----------------------------------------------------------
    @Override
    public int compare(City o1, City o2)
    {
        return o1.name().compareTo(o2.name());
    }

}
