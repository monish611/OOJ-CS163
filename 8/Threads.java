class newThread implements Runnable{
Thread t;
newThread(){
t = new Thread(this,"NThread");
System.out.println("CT: "+t);
t.start();
}
public void run(){
try{
for(int i=0;i<5;i++){
System.out.println("CSE");
Thread.sleep(100);
}
}
catch(InterruptedException ie){
System.out.println("Child thread interrupted");

}
System.out.println("Child thread quitting");
}
}
class ThreadsMain3{
public static void main(String args[]){
new newThread();
System.out.println("Back in main");
try{
for(int i=0;i<5;i++){
System.out.println("BMS COLLEGE OF

ENGINEERING");
Thread.sleep(100);
}
}
catch(InterruptedException ie){
System.out.println("Main Thread Interrupted");
}
System.out.println("Main thread quitting");
}
}
