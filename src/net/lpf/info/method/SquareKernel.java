/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lpf.info.method;

import net.lpf.info.extra.lab3.SquaresTable;
import net.lpf.info.base.AbstractKernel;
/**
 *
 * @author anyk3y
 */
public class SquareKernel extends AbstractKernel {
    

    private final SquaresTable tab = new SquaresTable();
    
    public SquareKernel() {
        super("squares", false);
    }

    @Override
    public String recoverOpenText(String encryption, String pass) {
        String decryption = "";
        String[][] tab0 = tab.getSquares();
        String stage1 = tab.binaryPrepare(encryption);
        int ax, ay, bx, by;
        try {
            for (int l = 0; l < stage1.length() - 1; l += 2) {
                ay = getCharY(stage1.charAt(l), tab0[1]);
                by = getCharY(stage1.charAt(l+1), tab0[0]);
                ax = getCharX(stage1.charAt(l), tab0[1]);
                bx = getCharX(stage1.charAt(l+1), tab0[0]);
                if (ay == by){
                    decryption += getCharByPoint(ax, ay, tab0[0]);
                    decryption += getCharByPoint(bx, by, tab0[1]);
                }
                else {
                    decryption += getCharByPoint(bx, ay, tab0[0]);
                    decryption += getCharByPoint(ax, by, tab0[1]);
                }
            }
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage()); 
            return "Internal error"; 
        }
        return decryption;
    }
    @Override
    public String makeEncryptedText(String openText, String pass) {
        String encryption = "";
        String stage1 = tab.binaryPrepare(openText);
        String[][] tab0 = tab.getSquares(); 
        int ax, ay, bx, by;
        try {
            for (int l = 0; l < stage1.length() - 1; l += 2) {
                ax = getCharX(stage1.charAt(l), tab0[0]);
                ay = getCharY(stage1.charAt(l), tab0[0]);
                bx = getCharX(stage1.charAt(l+1), tab0[1]);
                by = getCharY(stage1.charAt(l+1), tab0[1]);
                if (ay == by){
                    encryption += getCharByPoint(ax, ay, tab0[1]);
                    encryption += getCharByPoint(bx, by, tab0[0]);
                }
                else {
                    encryption += getCharByPoint(bx, ay, tab0[1]);
                    encryption += getCharByPoint(ax, by, tab0[0]);
                }
            }
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage()); 
            return "Internal error"; 
        }
        return encryption;
    }
    private int getCharX(char c, String[] tab) throws Exception {
        for(String s : tab) {
            if (s.contains("" + c)) {
                return s.indexOf(c);
            }
        }
        throw new Exception("A character is missing from the tab: '" + c +"'");
    }
    private int getCharY(char c, String[] tab) throws Exception {
        for(int i = 0; i < tab.length; i ++) {
            if (tab[i].contains("" + c)) {
                return i;
            }
        }
        throw new Exception("A character is missing from the tab: '" + c +"'");
    }
    private char getCharByPoint(int x, int y, String[] tab) throws Exception {
        if (y < tab.length) {
            if (x < tab[y].length()) {
                return tab[y].charAt(x);
            }
        }
        throw new Exception("Invalid point: '" + x +", " + y + "'");
    }
}
