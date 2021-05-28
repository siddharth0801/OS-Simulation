import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class CPUManager {
// completed processes list for cpu part
public static Vector<Proces> compQue = new Vector<>();
// current processes list for cpu part
public static Queue<Proces> que = new LinkedList<>();
// Running this for every clock cycle in controller
public static void run(){
if(!que.isEmpty()){
if(Controller.clock%100==0 && Controller.clock!=0){
/* when burst time is less than or equal to 100 ms add
it to complete cpu list otherwise add again it to current cpu list.
This shows simulation is using round robin scheduling*/
if(que.peek().BT<=100){
Proces temp = que.peek();
temp.CT=Controller.clock;
compQue.add(temp);
}
else{
que.peek().BT -=100;
que.add(que.peek());
}
que.remove();
}
}
}
}
