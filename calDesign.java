/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author 
 */
public class calDesign extends JFrame 
{
    JTextField tef,otef;
    Font ff,ff1;
    Box bop,bdig,bfun;
    calAction jaaction=new calAction(this);
    calDesign()
    {
        setTitle("Calculator");
        ff = new Font("monspaced", Font.PLAIN, 20);
        JPanel mainp = new JPanel(); //Main container
        mainp.setLayout(new BorderLayout(10,10)); 
        mainp.setMaximumSize(new Dimension(1000, 1000));
        
        JPanel mainp1 = new JPanel(); //Main panel
        mainp1.setLayout(new BorderLayout(10,10)); 
        mainp1.setMaximumSize(new Dimension(2000, 2000));
/******FUN event------------------------------------------------------------------*/
        JRadioButton oprts = new JRadioButton("O",true), digitss = new JRadioButton("D",true), functns  = new JRadioButton("F",true);
        oprts.addItemListener(jaaction);
        digitss.addItemListener(jaaction);
        functns.addItemListener(jaaction);
        JPanel funev=new JPanel();
        funev.setLayout(new GridBagLayout());
        
        Box funv=Box.createHorizontalBox();
        funv.add(new JLabel("Fun event: "));
        funv.add(oprts);
        funv.add(digitss);
        funv.add(functns);
        
        otef = new JTextField("NONE       |      NUM1",5);
        ff1 = new Font("monspaced", Font.PLAIN, 15);
        otef.setEnabled(false)  ;
        otef.setCaretColor(Color.white); //blinking cursor ar color
        otef.setFont(ff1);
        otef.setHorizontalAlignment(JTextField.RIGHT);
        funv.add(Box.createHorizontalStrut(85));
        funv.add(otef);
        
        addtogrid(funev,funv,0,0,1,1,GridBagConstraints.CENTER,0,GridBagConstraints.BOTH);
        
        
        mainp1.add(funev,BorderLayout.NORTH);
        
        
        
/* need to work with text field and area more  -----------------------------------*/
        tef = new JTextField("0",20);
        //tef.setEnabled(false)  ;
        tef.setCaretColor(Color.white); //blinking cursor ar color
        tef.setFont(ff);
        tef.setHorizontalAlignment(JTextField.RIGHT);
        mainp.add(tef,BorderLayout.PAGE_START);
        tef.addKeyListener(jaaction);
/*  operatorS ------------------------------------------------------------------- */
        
        String ops1[]={"n!","/","*","-","+"},ops[]={"√","x²","1/x","="};
        JPanel oprs=new JPanel();
        oprs.setLayout(new GridBagLayout());
        
        for(int i=0;i<5;i++)
        {
            JButton bb=new JButton(ops1[i]);
            bb.setFont(ff);
            bb.setPreferredSize(new Dimension(62,38));
            bb.addActionListener(jaaction);
            int jk=0;
            addtogrid(oprs,bb,0,i,1,1,GridBagConstraints.CENTER,jk,GridBagConstraints.BOTH);
        }
        for(int i=0;i<4;i++)
        {
            JButton bb=new JButton(ops[i]);
            bb.setFont(ff);
            bb.setPreferredSize(new Dimension(62,38));
            bb.addActionListener(jaaction);
            int jk,jk1=1;
            if(i==0)jk=0;
            else jk=0;
            if(i==3) jk1=2;
            addtogrid(oprs,bb,1,i,1,jk1,GridBagConstraints.CENTER,jk,GridBagConstraints.BOTH);
        }
        bop=Box.createVerticalBox();
        bop.add(oprs);
        bop.setBorder(BorderFactory.createTitledBorder("Operators"));
        mainp.add(bop,BorderLayout.EAST);

/*other functions and digits---------------------------------------------------------------*/
        
        JPanel centerp=new JPanel();
        centerp.setLayout(new GridBagLayout());
        
        //functions
        String fnc[]={"←","CE","AC"};
        JPanel func=new JPanel();
        func.setLayout(new GridBagLayout());
        
        for(int i=0;i<3;i++)
        {
            JButton bb=new JButton(fnc[i]);
            bb.setFont(ff);
            bb.setPreferredSize(new Dimension(62,38));
            bb.addActionListener(jaaction);
            addtogrid(func,bb,i,0,1,1,GridBagConstraints.CENTER,0,GridBagConstraints.BOTH);
        }
        
        bfun=Box.createHorizontalBox();
        bfun.add(func);
        bfun.setBorder(BorderFactory.createTitledBorder("Functions"));
        
        addtogrid(centerp,bfun,0,0,1,1,GridBagConstraints.NORTH,0,GridBagConstraints.NONE);
        
        //digits
        String dig="7894561230. ";
        
        JPanel digs=new JPanel();
        digs.setLayout(new GridBagLayout());
        
        int ii=0;
        again: for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
               //if(i==3&&j==0) continue again;
               
               String dg=dig.substring(ii,ii+1);
               int zer=1;
               if(dg.equals("0")) zer=2;
               else zer=1;
               
               //System.out.println("fjhg "+" "+j);    
               JButton bb=new JButton(dg);
               bb.setFont(ff);
               bb.setPreferredSize(new Dimension(62,38));
               bb.addActionListener(jaaction);
               addtogrid(digs,bb,j,i,zer,1,GridBagConstraints.CENTER,0,GridBagConstraints.BOTH);
               ii++;
            }
        }
        
        JButton bn=new JButton("0");
        bn.setFont(ff);
        bn.setPreferredSize(new Dimension(62,38));
        bn.addActionListener(jaaction);
        addtogrid(digs,bn,0,3,2,1,GridBagConstraints.CENTER,0,GridBagConstraints.BOTH);
        
        bn=new JButton(".");
        bn.setFont(ff);
        bn.setPreferredSize(new Dimension(62,38));
        bn.addActionListener(jaaction);
        addtogrid(digs,bn,2,3,1,1,GridBagConstraints.CENTER,0,GridBagConstraints.BOTH);
        
        bdig=Box.createVerticalBox();
        bdig.add(digs);
        bdig.setBorder(BorderFactory.createTitledBorder("Digits"));
        
        addtogrid(centerp,bdig,0,1,1,1,GridBagConstraints.SOUTH,0,GridBagConstraints.NONE);

        mainp.add(centerp,BorderLayout.CENTER);
        
        mainp1.add(mainp,BorderLayout.CENTER);
        
        mainp1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        setContentPane(mainp1);
        tef.requestFocus();
    }
    
    private void addtogrid(JPanel p,Component cc,int x,int y,int width,int height,int align,int now,int fil)
    {
        GridBagConstraints gc=new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(now, 0, 0, 0);//top,left,bottom,right
        gc.anchor = align;
        gc.fill = fil;
        p.add(cc, gc);
    }
}
