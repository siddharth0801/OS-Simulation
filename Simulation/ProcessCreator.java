import java.util.*;
public class ProcessCreator {
static int perOfIoBoundProcesses=40;
static int rate=20;
static int proid=0; //process id
static int approxNextTime = 5 + (int) ((60000/rate) * 2 * Math.random());
static int nextProcessTime = approxNextTime + 10 - approxNextTime%10;
// A queue for inserting the created processes
static Queue<Proces> que = new LinkedList<>();
// Creates processes at a given rate for five minutes
public static void run() {
if(Controller.clock<=300000 && proid<=100) {
if(Controller.clock == nextProcessTime) {
Proces p = new Proces(proid); //(int) (9999*Math.random())
approxNextTime = 5 + (int) ((600/rate) * 2 * Math.random());
nextProcessTime+= approxNextTime +10-(approxNextTime)%10;
que.add(p);
proid++;
}
}
}
// Checks if process is availabe in the above queue
public static boolean isProcessAvailable()
{
if(que.isEmpty() == true)
{
return false;
}
else
{
return true;
}
}
}