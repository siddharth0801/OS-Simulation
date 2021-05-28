import java.util.*;
public class IOManager{
static public int totalProcessIOManager;
static public int waste_time=0;
static Vector<Proces> listOFCurrentIOProcess=new Vector<Proces>();
static Vector<Proces> listOFCompletedIOProcess=new Vector<Proces>();
static public void calculateWastageTime()//to print waste time
{
System.out.println("The total time wasted while using multiple Processes is: "+waste_time);
}
static public void increaseAndUpdateAllProcessWithTime()
{
if(listOFCurrentIOProcess.size()<=0)
return;
for(int i=0;i<listOFCurrentIOProcess.size();i++)//for each process in io
{
double prev=listOFCurrentIOProcess.get(i).IOEXEC;
double x=(double)((double)5/100)*(double)prev;//5% extra time
// System.out.println("Value of 5 % of "+prev +" is "+x);
listOFCurrentIOProcess.get(i).IOExtra+=x;
listOFCurrentIOProcess.get(i).IOEXEC=prev+x;
waste_time+=x;//extra time added to waste time
}
}
static public void run(){
if(Controller.clock<=300000) {
if(listOFCurrentIOProcess.size()!=0){
if(Controller.clock%10==0 && Controller.clock!=0){
for(int i=0;i<listOFCurrentIOProcess.size();i++)
{
double prev=listOFCurrentIOProcess.get(i).IOEXEC;
if(prev<10){
listOFCurrentIOProcess.get(i).IOEXEC=0;
listOFCurrentIOProcess.get(i).IOEND=Controller.clock;
listOFCompletedIOProcess.add(listOFCurrentIOProcess.get(i));
listOFCurrentIOProcess.remove(i);
}
else
listOFCurrentIOProcess.get(i).IOEXEC-=10;
}
}
}
}
}
static public void addNewProcesLookingForIO(Proces p){
listOFCurrentIOProcess.add(p);
increaseAndUpdateAllProcessWithTime();
}
static public Vector<Proces> getCompletedProcesses(){
Vector<Proces> v=listOFCompletedIOProcess;
listOFCompletedIOProcess.clear();
return v;
}
}
