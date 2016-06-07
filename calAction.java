/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.AbstractButton;
import java.util.*;

/**
 *
 * @author 
 */
public class calAction extends KeyAdapter implements ActionListener,ItemListener
{                            //key adapter keylistener ar jonno
    calDesign desg;
    calAction(){}
    calAction(calDesign mp){desg=mp;}
    int end=0;
    String mm="";
    int val=1;
    double num1=0;
    int oper=0;
    public void keyTyped(KeyEvent keyevent) //for key listener
    {
            char c = keyevent.getKeyChar();
            desg.tef.setCaretPosition(desg.tef.getSelectionEnd());
            //if(end==0) {desg.tef.setText("hobena mane");}
            
            if(c >= '1' && c <= '9') 
            { 
                    keyevent.consume();
                    mm=desg.tef.getText();
                    if(mm.length()>=20&&end==1) {}
                    else if(end==0)
                    {
                        mm="";
                        mm+=c;end=1;
                    }
                    else
                    {
                        if(mm.equals("0") && c=='0'){}
                        else if(mm.equals("0")) mm="";
                        mm+=c;
                    }
                    desg.tef.setText(mm);
            } 
            else if(c=='0')
            {
                keyevent.consume();
                if(mm.length()>=20&&end==1) {}             
                else if(end==1) 
                {
                        mm=desg.tef.getText();
                        if(mm.equals("0")) {}
                        else mm=desg.tef.getText()+"0";
                }
                else mm="0";
                desg.tef.setText(mm);
            }
            else if((int)c==8) //for backspace
            {
                keyevent.consume();
                mm=desg.tef.getText();
                if(mm.length()==0) {desg.tef.setText("0");end=0;}
                //System.out.println("fsd");
            }
            else if(c=='.')
            {
                keyevent.consume();
                
                mm=desg.tef.getText();
                if(mm.length()>=20&&end==1) {}
                else if(mm.indexOf(".")!=-1) {}
                else {mm+=".";end=1;}
                desg.tef.setText(mm);
            }
            else 
            {
                    keyevent.consume();
            }
    }
    public void actionPerformed(ActionEvent e) // action listener
    {
		String s = e.getActionCommand();
                AbstractButton ab = (AbstractButton) e.getSource();
                //System.out.println("Selected: " + " " + s);
                //desg.tef.setText("hocche");
                
/*********Functions--------------------------------------------------------------*/           
                if(s.equals("AC"))
                {
                    end=0;
                    mm="0";
                    desg.tef.setText(mm);
                    val=1;
                    num1=0;
                    oper=0;
                }
                else if(s.equals("←"))
                {
                    mm=desg.tef.getText();
                    if(mm.length()==1 && mm.equals("0")){end=0;}
                    else if(mm.length()==1 && !mm.equals("0")) {desg.tef.setText("0");end=0;}
                    else
                    {
                        mm=mm.substring(0,mm.length()-1);
                        desg.tef.setText(mm);
                    }
                }
                else if(s.equals("CE"))
                {
                    desg.tef.setText("0");
                    end=0;
                }
                
/************DIGITS-------------------------------------------------------------*/                
                if(s.equals("0"))
                {
                    if(end==1) 
                    {
                        mm=desg.tef.getText();
                        if(mm.length()>=20&&end==1) {}
                        else if(mm.equals("0")) {end=0;}
                        else if(mm.length()==0) {mm=desg.tef.getText()+"0";end=0;}
                        else mm=desg.tef.getText()+"0";
                    }
                    else mm="0";
                    desg.tef.setText(mm);
                }
                else if(s.equals("1"))
                {
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1) mm=desg.tef.getText()+"1";
                    else {mm="1";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("2"))
                {
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1) mm=desg.tef.getText()+"2";
                    else {mm="2";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("3"))
                {
                    if(mm.length()>=20&&end==1) {}                    
                    else if(end==1) mm=desg.tef.getText()+"3";
                    else {mm="3";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("4"))
                {
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1) mm=desg.tef.getText()+"4";
                    else {mm="4";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("5"))
                {
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1) mm=desg.tef.getText()+"5";
                    else {mm="5";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("6"))
                {
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1) mm=desg.tef.getText()+"6";
                    else {mm="6";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("7"))
                {
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1) mm=desg.tef.getText()+"7";
                    else {mm="7";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("8"))
                {
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1) mm=desg.tef.getText()+"8";
                    else {mm="8";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("9"))
                {
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1) mm=desg.tef.getText()+"9";
                    else {mm="9";end=1;}
                    desg.tef.setText(mm);
                }
                else if(s.equals("."))
                {
                    mm=desg.tef.getText();
                    if(mm.length()>=20&&end==1) {}
                    else if(end==1)
                    {
                        if(mm.indexOf(".")!=-1){}
                        else {mm+=".";end=1;}
                    }
                    else if(end==0)
                    {
                        mm="0.";end=1;
                    }
                    desg.tef.setText(mm);
                }
/************* Operators--------------------------------------------------------*/                
                
                if(s.equals("+"))
                {
                    mm=desg.tef.getText();
                    if(mm.indexOf("Er")!=-1){}
                    else if(oper!=1&&oper!=0) oper=1;
                    else if(val==2) 
                    {
                        double ans=num1+Double.parseDouble(mm);
                        long ans1=(long)ans;
                        if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                        else desg.tef.setText(String.valueOf(ans1));
                        val=2;
                        num1=ans;
                        oper=1;
                    }
                    else
                    {
                        num1=Double.parseDouble(mm);
                        val=2;
                        end=0;
                        oper=1;
                    }
                    end=0;
                }
                else if(s.equals("-"))
                {
                    mm=desg.tef.getText();
                    if(mm.indexOf("Er")!=-1){}
                    else if(oper!=2&&oper!=0) oper=2;
                    else if(val==2) 
                    {
                        double ans=num1-Double.parseDouble(mm);
                        long ans1=(long)ans;
                        if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                        else desg.tef.setText(String.valueOf(ans1));
                        val=2;
                        num1=ans;
                        oper=2;
                    }
                    else
                    {
                        num1=Double.parseDouble(mm);
                        val=2;
                        end=0;
                        oper=2;
                    }
                    end=0;
                }
                else if(s.equals("/"))
                {
                    mm=desg.tef.getText();
                    if(mm.indexOf("Er")!=-1){}
                    else if(oper!=3&&oper!=0) oper=3;
                    else if(val==2) 
                    {
                        if(Double.parseDouble(mm)==0) 
                        { 
                            desg.tef.setText(String.valueOf("Math Error")); 
                            end=0;
                            val=1;
                            oper=0;
                        }
                        else
                        {
                            double ans=num1/Double.parseDouble(mm);
                            long ans1=(long)ans;
                            if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                            else desg.tef.setText(String.valueOf(ans1));
                            val=2;
                            num1=ans;
                            end=0;
                            oper=3;
                        }
                    }
                    else if(val==1)
                    {
                        num1=Double.parseDouble(mm);
                        val=2;
                        oper=3;
                    }
                    end=0;
                }
                else if(s.equals("*"))
                {
                    mm=desg.tef.getText();
                    
                    if(mm.indexOf("Er")!=-1){}
                    else if(oper!=4&&oper!=0) oper=4;
                    else if(val==2) 
                    {
                        double ans=num1*Double.parseDouble(mm);
                        long ans1=(long)ans;
                        if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                        else desg.tef.setText(String.valueOf(ans1));
                        val=2;
                        num1=ans;
                        oper=4;
                    }
                    else
                    {
                        num1=Double.parseDouble(mm);
                        val=2;
                        end=0;
                        oper=4;
                    }
                    end=0;
                }
                else if(s.equals("="))
                {
                    mm=desg.tef.getText();
                    if(oper==0) desg.tef.setText(mm);
                    else if(oper==1) 
                    {
                        double ans=num1+Double.parseDouble(mm);
                        long ans1=(long)ans;
                        if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                        else desg.tef.setText(String.valueOf(ans1));
                        num1=ans;
                        val=1;
                        end=0;
                        oper=0;
                    }
                    else if(oper==2) 
                    {
                        double ans=num1-Double.parseDouble(mm);
                        long ans1=(long)ans;
                        if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                        else desg.tef.setText(String.valueOf(ans1));
                        num1=ans;
                        val=1;
                        end=0;
                        oper=0;
                    }
                    else if(oper==3) 
                    {
                        if(Double.parseDouble(mm)==0) 
                        { 
                            desg.tef.setText(String.valueOf("Math Error")); 
                            end=0;
                            val=1;
                            oper=0;
                        }
                        else 
                        {
                            double ans=num1/Double.parseDouble(mm);
                            long ans1=(long)ans;
                            if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                            else desg.tef.setText(String.valueOf(ans1));
                            num1=ans;
                            val=1;
                            end=0;
                            oper=0;
                        }
                    }
                    else if(oper==4) 
                    {
                        double ans=num1*Double.parseDouble(mm);
                        long ans1=(long)ans;
                        if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                        else desg.tef.setText(String.valueOf(ans1));
                        num1=ans;
                        val=1;
                        end=0;
                        oper=0;
                    }
                }
                
/*-----Special operators---------------------------------------------------------*/
                if(s.equals("x²"))
                {
                    mm=desg.tef.getText();
                    if(mm.indexOf("Er")!=-1){}
                    else if(val==2)
                    {
                        double ans=num1*num1;
                        long ans1=(long)ans;
                        if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                        else desg.tef.setText(String.valueOf(ans1));
                        num1=0;
                        val=1;
                        end=0;
                        oper=0;
                    }
                    else
                    {
                        mm=desg.tef.getText();
                        num1=Double.parseDouble(mm);
                        double ans=num1*num1;
                        long ans1=(long)ans;
                        if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                        else desg.tef.setText(String.valueOf(ans1));
                        num1=0;
                        val=1;
                        end=0;
                        oper=0;
                    }
                }
                else if(s.equals("1/x"))
                {
                    mm=desg.tef.getText();
                    if(mm.indexOf("Er")!=-1){}
                    else if(val==2)
                    {
                        double ans=0;
                        if(num1==0) desg.tef.setText(String.valueOf("Math Error")); 
                        else
                        {
                            ans=1/num1;
                            long ans1=(long)ans;
                            if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                            else desg.tef.setText(String.valueOf(ans1));
                        }
                        num1=0;
                        val=1;
                        end=0;
                        oper=0;
                    }
                    else
                    {
                        mm=desg.tef.getText();
                        num1=Double.parseDouble(mm);
                        double ans=0;
                        if(num1==0) desg.tef.setText(String.valueOf("Math Error")); 
                        else
                        {
                            ans=1/num1;
                            long ans1=(long)ans;
                            if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                            else desg.tef.setText(String.valueOf(ans1));
                        }
                        num1=0;
                        val=1;
                        end=0;
                        oper=0;
                    }
                }
                else if(s.equals("√"))
                {
                    mm=desg.tef.getText();
                    if(mm.indexOf("Er")!=-1){}
                    else if(val==2)
                    {
                        if(num1<0) desg.tef.setText(String.valueOf("Math Error"));
                        else
                        {
                            double ans=Math.sqrt(num1);
                            long ans1=(long)ans;
                            if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                            else desg.tef.setText(String.valueOf(ans1));
                        }
                    }
                    else
                    {
                        mm=desg.tef.getText();
                        num1=Double.parseDouble(mm);
                        if(num1<0) desg.tef.setText(String.valueOf("Math Error"));
                        else
                        {
                            double ans=Math.sqrt(num1);
                            long ans1=(long)ans;
                            if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                            else desg.tef.setText(String.valueOf(ans1));
                        }
                    }
                    num1=0;
                    val=1;
                    end=0;
                    oper=0;
                }
                else if(s.equals("n!"))
                {
                    mm=desg.tef.getText();
                    if(mm.indexOf("Er")!=-1){}
                    else if(val==2)
                    {
                        if(num1<0) desg.tef.setText(String.valueOf("Input Error"));
                        else if(num1>100)desg.tef.setText(String.valueOf("Large Number Error"));
                        else
                        {
                            double ans=1;
                            for(int i=1;i<=num1;i++)
                            {
                                ans*=i;
                            }
                            long ans1=(long)ans;
                            if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                            else desg.tef.setText(String.valueOf(ans1));
                        }
                    }
                    else
                    {
                        mm=desg.tef.getText();
                        num1=Double.parseDouble(mm);
                        if(num1<0) desg.tef.setText(String.valueOf("Input Error"));
                        else if(num1>100)desg.tef.setText(String.valueOf("Large Number Error"));
                        else
                        {
                            double ans=1;
                            for(int i=1;i<=num1;i++)
                            {
                                ans*=i;
                            }
                            long ans1=(long)ans;
                            if(ans>ans1) desg.tef.setText(String.valueOf(ans));
                            else desg.tef.setText(String.valueOf(ans1));
                        }
                    }
                    num1=0;
                    val=1;
                    end=0;
                    oper=0;
                }
                

/* Upper textfield---------------------------------------------------------------*/                
                //System.out.println(oper+" "+num1+" "+end+" "+mm+" "+val);
                String opps="",nmb="";
                if(oper==0)opps="NONE";
                else if(oper==1)opps="+";
                else if(oper==2)opps="-";
                else if(oper==3)opps="/";
                else if(oper==4)opps="*";
                if(val==1) nmb="NUM1";
                else nmb="NUM2";
                String ssst=opps+"       |      "+nmb;
                desg.otef.setText(ssst);
                desg.tef.requestFocus(); //nirdisto jaygay focus kora
    }
    
    public void itemStateChanged(ItemEvent itemEvent)  //item listener
    {
        AbstractButton aButton = (AbstractButton)itemEvent.getSource();
        int state = itemEvent.getStateChange();
        String label = aButton.getText();
        if (state == ItemEvent.SELECTED) 
        {
            if(label.equals("O"))
            {
                desg.bop.setVisible(true);
            }
            else if(label.equals("D"))
            {
                desg.bdig.setVisible(true);
            }
            else desg.bfun.setVisible(true);
        }
        else
        {
            if(label.equals("O"))
            {
                desg.bop.setVisible(false);
            }
            else if(label.equals("D"))
            {
                desg.bdig.setVisible(false);
            }
            else desg.bfun.setVisible(false);
        }
        
        desg.tef.requestFocus(); 
    }
    
}
