import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
;public class Proces
{
/*
* pid = process id
* totaltime = total time for process completion
* PET = process end time
* AT = arrival time of process in cpu
* CT = completion time of process time in cpu
* BT = burst time of process
* IOEXEC = IO execution time required by process
* IOSTART = IO arrival time of a process
* IOEND = IO completion time of a process
* IOExtra = extra time required by a process for IO
* Note: All times are in millisecond
*/
double pid,IOpercentage,totaltime,PET,AT,CT;
double BT,IOEXEC,IOSTART,IOEND,IOExtra;
static int c=0;
public Proces(int pid){
this.pid=pid;
totaltime = ThreadLocalRandom.current().nextInt(3000,8000);
Random r = new Random();
int check = r.nextInt(100); //assigning bound percentage randomly
if(check%2==0 && c<ProcessCreator.perOfIoBoundProcesses){
BT=(float)((0.2)*totaltime);
IOEXEC=totaltime-BT;
IOpercentage=80;
c++;
}
else{
BT=(float)((0.8)*totaltime);
IOEXEC=totaltime-BT;
IOpercentage=20;
}
}
}
