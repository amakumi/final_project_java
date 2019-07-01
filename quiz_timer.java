/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author OWNER
 */

public class quiz_timer
{
    //JLabel timer1;
    Timer timer;
    
    int timeLeft = 20000;
    
    public void setTimer()
    {
       
        ActionListener countDown=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                timeLeft-=1000;
                //SimpleDateFormat df=new SimpleDateFormat("mm:ss");
                //timer1.setText(df.format(timeLeft));
                if(timeLeft<=0)
                {
                    timer.stop();
                }
            }
        };
        Timer t = new Timer(timeLeft, countDown);
        t.start();
    }
        public void start()
        {
            //Timer t = new Timer(timeLeft, countDown);
            //t.start();
        }
}   


