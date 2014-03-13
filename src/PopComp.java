/*
 *
 */
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class popComp.
 *
 * @author Omar
 * @version 1
 */
public class PopComp
    implements Comparator<City>
{

// ----------------------------------------------------------
    @Override
    public int compare(City o1, City o2)
    {
        int i = o1.population() - o2.population();
        if (i > 0)
        {
            return 1;
        }
        else if (i == 0)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

}
