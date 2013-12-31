import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;

public class Analogclock extends Applet implements Runnable
{
    private static final double TWO_PI   = 2.0 * Math.PI;
    
    private Calendar nw = Calendar.getInstance();
    
    int width = 300,hight = 300;
    int xcent = width / 2, ycent = hight / 2;
    int minhand,maxhand;
    double rdns;
    int dxmin,dymin,dxmax,dymax;
    double radins,sine,cosine;
    double fminutes;
    Thread t = null;
    Boolean stopFlag;
  
    public void start()
    {
       t = new Thread(this);
       stopFlag = false;
       t.start();
    }
    
    public void run()
    {
       for( ; ; )
       {
          try {
                 updateTime();
                 repaint();
                 Thread.sleep(100);
                 if(stopFlag)
                    break;
               }
          catch(InterruptedException e) {}
       }
    }
    
    public void stop()
    {
        stopFlag = true;
        t = null;
    }
    
    private void updateTime() {
        nw.setTimeInMillis(System.currentTimeMillis());
    }
    
    public void paint(Graphics g)
    {
        int hours   = nw.get(Calendar.HOUR);
        int minutes = nw.get(Calendar.MINUTE);
        int seconds = nw.get(Calendar.SECOND);
        int millis  = nw.get(Calendar.MILLISECOND);
        
        minhand = width /8;
        maxhand = width /2;
        rdns = (seconds + ((double)millis/1000)) / 60.0;
        drw(g, rdns, 0, maxhand);
        
        minhand = 0;                    
        maxhand = width / 3;
        fminutes = (minutes + rdns) / 60.0;
        drw(g, fminutes, 0, maxhand);
        
        minhand = 0;                   
        maxhand = width / 4;
        drw(g, (hours + fminutes) / 12.0, 0, maxhand);
        g.drawOval(0, 0, width, hight);
        
        g.drawString("9", xcent-145, ycent -0);
        g.drawString("3", xcent+140, ycent -0);
        g.drawString("6", xcent , ycent+145);
        g.drawString("12", xcent , ycent-135);
        
     }
   
    public void drw(Graphics g, double prct, int minRadius, int maxRadius) 
    {
        radins = (0.5 - prct)*TWO_PI;
        sine   = Math.sin(radins);
        cosine = Math.cos(radins);
        dxmin = xcent + (int)(minRadius * sine);
        dymin = ycent + (int)(minRadius * cosine);
       
        dxmax = xcent + (int)(maxRadius * sine);
        dymax = ycent + (int)(maxRadius * cosine);
      
        g.drawLine(dxmin, dymin, dxmax, dymax);
    }
}