import java.util.*;
public class Controller {
// A universal clock
public static int clock=0;
// A vector for saving the fully completed processes
static Vector<Proces> compProcess = new Vector<>();
public static void main(String[] args) {
// starting the clock for several minutes
//since, we don't know when the last process will end
while(clock<=1000000000) {
ProcessCreator.run();
// If process is available then sending them to cpu or IO
if(ProcessCreator.isProcessAvailable()) {
Proces temp=ProcessCreator.que.poll();
if(temp.IOpercentage==80) {
temp.IOSTART=clock;
IOManager.listOFCurrentIOProcess.add(temp);
}
else {
temp.AT=clock;
CPUManager.que.add(temp);
}
}
// to run the following for one clock cycle
CPUManager.run();
IOManager.run();
/* if io part of process is completed and it's cpu part is left then add it to
for cpu simulation otherwise add it to the completed processess vector */
while(!IOManager.listOFCompletedIOProcess.isEmpty()) {
Proces temp = IOManager.listOFCompletedIOProcess.firstElement();
if(temp.IOpercentage==80) {
temp.AT=temp.IOEND;
CPUManager.que.add(temp);
IOManager.listOFCompletedIOProcess.remove(0);
}
else {
temp.PET=temp.IOEND;
compProcess.add(temp);
IOManager.listOFCompletedIOProcess.remove(0);
}
}
// Similarly checking for cpu manager
while(!CPUManager.compQue.isEmpty()) {
Proces temp = CPUManager.compQue.firstElement();
if(temp.IOpercentage==80) {
temp.PET=temp.CT;
compProcess.add(temp);
CPUManager.compQue.remove(0);
}
else {
temp.IOSTART=temp.CT;
IOManager.listOFCurrentIOProcess.add(temp);
CPUManager.compQue.remove(0);
}
}
clock=clock+10;
}
// sorting the completed process list according to pid
Collections.sort(compProcess, new ProcessComparator());
// printing the output
for(int i=0;i<compProcess.size();i++) {
Proces pr = compProcess.get(i);
System.out.printf(" pid = %13f",pr.pid);
System.out.printf(" AT = %13f",pr.AT);
System.out.printf(" IOSTART = %13f",pr.IOSTART);
System.out.printf(" IOEND = %13f",pr.IOEND);
System.out.printf(" IOpercentage = %13f",pr.IOpercentage);
System.out.printf(" CT = %13f",pr.CT);
System.out.printf(" CpuTT = %13f",(pr.CT-pr.AT));
System.out.printf(" IoTT = %13f",(pr.IOEND-pr.IOSTART));
System.out.println();
}
}
}