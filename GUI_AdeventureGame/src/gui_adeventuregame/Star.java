/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_adeventuregame;

/**
 *
 * @author Bradley
 */
public class Star implements Runnable{
    int x;
    int y;
    int vx;
    int vy;
    int width = 960;
    int height = 540;
    int time;
    int starID;
    int scale = 3;

    public Star(int starID) {
        this.starID = starID;
        this.x = (int) (Math.random() * this.width -2);
        this.y = (int) (Math.random() * this.height-2);
        this.vx = (int) ((Math.random() * 2 -1) * this.scale);
        this.vy = (int) ((Math.random() * 2 -1) * this.scale);
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.err.println("Interruped Exception");
            }
            this.move();
        }
    }
    
    public void move() {
        if(x < 0 || x > this.width) {
            vx *= -1;
        }
        if(y < 0 || y > this.height) {
            vy *= -1;
        }
        
        ++this.time;
        this.time %= 80;
        
        if(this.time == 0) {
            this.vx = (int) ((Math.random() * 2 -1) * this.scale);
            this.vy = (int) ((Math.random() * 2 -1) * this.scale);
        }
             
        this.x += this.vx;
        this.y += this.vy;
    }
}
