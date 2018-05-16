/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2005_okt_e_i;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dávid
 */
public class _2005_okt_e_i {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
       String szo="asdfghjkléáéuztrew",szo2="errt", nyilt="", kulcs="";
       
//       Scanner be = new Scanner(System.in);
//       szo=be.nextLine();
//       szo2=be.nextLine();
        
        for (int i = 0; i < szo.length(); i++) {
            if('á'==szo.charAt(i)){
                nyilt+="a";
                System.out.println("á");
            }else
            if('é'==szo.charAt(i)){
                nyilt+="e";
                System.out.println("é");
            }else
            if('ű'==szo.charAt(i) || 'ú'==szo.charAt(i)){
                nyilt+="u";
            }else
            if('ó'==szo.charAt(i) || 'ő'==szo.charAt(i)){
                nyilt+="o";
            }else{
                 nyilt+=szo.charAt(i)+"";
            }
           
            
        }
        nyilt=nyilt.toUpperCase();
        int hossz_kulcs=szo2.length();
        for (int i = 0; i < szo.length(); i++) {
           // System.out.println(i%hossz_kulcs);
            char betu=szo2.charAt(i%hossz_kulcs);
            kulcs+=betu+"";
           // System.out.println(kulcs);
        }
        kulcs=kulcs.toUpperCase();
        System.out.println(nyilt);
        System.out.println(kulcs);
        RandomAccessFile raf=new RandomAccessFile("Vtabla.dat", "r");
        String sor=raf.readLine();
        char[] tomb=sor.toCharArray();
        int db=sor.length();
        char[][] t=new char[db][db];
        raf.seek(0);
        db=0;
        while((sor=raf.readLine())!=null){
            for (int i = 0; i < sor.length(); i++) {
                t[db][i]=sor.charAt(i);
            }
            db++;
        }
//        for (char[] cs : t) {
//            for (char c : cs) {
//                System.out.print(c);
//            }
//            System.out.println();
//        }
        raf.close();
        String kod="";
        for (int i = 0; i < nyilt.length(); i++) {
            int s=0,o=0;
            for (int j = 0; j < tomb.length; j++) {
                if(tomb[j]==nyilt.charAt(i)){
                    s=j;
                    
                }
                if(tomb[j]==kulcs.charAt(i)){
                    o=j;
                }
            }
            kod+=t[s][o]+"";
        }
        
        System.out.println(kod);
    }
    
}
