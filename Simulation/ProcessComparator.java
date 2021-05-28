import java.util.Comparator;

// sorting the completed process on the basis of pids

public class ProcessComparator implements Comparator<Proces>{ 
public int compare(Proces p1, Proces p2) {
return ((int) (p1.pid - p2.pid));

}

}
