public class HelloWorldTask implements Runnable{

    //10 attributes
    @Override
    public void run() {
        depend();
        //I am using the attributes here
        System.out.println("Hello World from the task");
    }

    void depend(){
        System.out.println("dependent method");
    }
}

//HelloWorldTask is a child of Runnable, I am able to pass it's object in the Runnable param