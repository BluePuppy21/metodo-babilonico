package org.andreavzznnz.heronsmethod;

import java.awt.HeadlessException;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class HeronsMethod {

    public static void main(String[] args) {
        do{
            Double n= null;
            while(n==null){
                try{
                    n = Double.valueOf(javax.swing.JOptionPane.showInputDialog("Introduce the number to calculate its sqr root.") );
                }catch(HeadlessException | NumberFormatException ex){
                    javax.swing.JOptionPane.showMessageDialog(null,"Please indtoduce a valid number");
                }
            }
            alert("The final answer is: "+metodoBabilonico(n));
        }while(JOptionPane.showConfirmDialog(null,"Continue?", "Continue?", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
        System.exit(0);
    }
    
    public static double metodoBabilonico(double n){
    double[] x=new double[1];
    x[0]=n/10;
    
    int i=0;
    do {
      i++;
      double xi = (x[i-1] + (n/x[i-1])) /2;
      x= add(xi, x);
    } while(!areSame(x[i], x[i-1]));
    
    alert(Arrays.toString(x));
    return x[i];
    
  }
  
  
  public static double[] add(double val,double[] arr){
    double[] b = new double[arr.length+1];
    for(int i=0;i<arr.length;i++)
      b[i]=arr[i];
    b[arr.length]=val;
    return b;
  }
  
  
  public static boolean areSame(double a, double b){
    double delta = a-b;
    return (delta*delta)<=(.0001*.0001);
  }
  
  public static void alert(String message){
    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
