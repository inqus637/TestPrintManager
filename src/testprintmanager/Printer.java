/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprintmanager;

/**
 *
 * @author Администратор
 */
public class Printer extends Thread {
    Printer(String name){
        super(name);
    }
    public void run(){
          
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(50000);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }    
}
