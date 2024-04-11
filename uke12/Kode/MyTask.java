class MyTask implements Runnable{

    int num;
    MyTask(int num){ this.num = num;}

    public void run(){
        for (int i = num; i >= 1; i--){
            System.out.println("Teller ned ... " + i);
        }
    }
}