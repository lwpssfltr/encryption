/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lpf.info.method;

import net.lpf.info.extra.lab2.BigramTable;
import net.lpf.info.base.AbstractKernel;

/**
 *
 * @author anyk3y
 */
public class BigramKernel extends AbstractKernel {
    public BigramKernel(){
        super("bigram", true);
    }
    private final BigramTable tab = new BigramTable();
    
    @Override
    public String recoverOpenText(String encryption, String pass) {
        String decryption = "";
        String[] tab0 = tab.generatePassTab(pass);
        String stage1 = tab.binaryPrepare(encryption);
        int ax, ay, bx, by;
        try{
            for (int l = 0; l < stage1.length() - 1; l += 2) {
                ax = getCharX(stage1.charAt(l), tab0);
                ay = getCharY(stage1.charAt(l), tab0);
                bx = getCharX(stage1.charAt(l+1), tab0);
                by = getCharY(stage1.charAt(l+1), tab0);
                if (ax != bx && ay != by) {
                    decryption += getCharByPoint(bx, ay, tab0);
                    decryption += getCharByPoint(ax, by, tab0);
                }
                else if (ay == by) {
                    decryption += getCharByPoint((ax == 0 ? tab0[ay].length() - 1 : --ax), ay, tab0);
                    decryption += getCharByPoint((bx == 0 ? tab0[ay].length() - 1 : --bx), ay, tab0);
                }
                else if (ax == bx) {
                    decryption += getCharByPoint(ax, (ay == 0 ? tab0.length - 1 : --ay), tab0);
                    decryption += getCharByPoint(ax, (by == 0 ? tab0.length - 1 : --by), tab0);
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
        String[] tab0 = tab.generatePassTab(pass);
        String stage1 = tab.binaryPrepare(openText);
        int ax, ay, bx, by;
        try {
            for (int l = 0; l < stage1.length() - 1; l += 2) {
                ax = getCharX(stage1.charAt(l), tab0);
                ay = getCharY(stage1.charAt(l), tab0);
                bx = getCharX(stage1.charAt(l+1), tab0);
                by = getCharY(stage1.charAt(l+1), tab0);
                if (ax != bx && ay != by) {
                    encryption += getCharByPoint(bx, ay, tab0);
                    encryption += getCharByPoint(ax, by, tab0);
                }
                else if (ay == by) {
                    encryption += getCharByPoint((ax >= tab0[ay].length() - 1 ? 0 : ++ax), ay, tab0);
                    encryption += getCharByPoint((bx >= tab0[ay].length() - 1 ? 0 : ++bx), ay, tab0);
                }
                else if (ax == bx) {
                    encryption += getCharByPoint(ax, (ay >= tab0.length - 1 ? 0 : ++ay), tab0);
                    encryption += getCharByPoint(ax, (by >= tab0.length - 1 ? 0 : ++by), tab0);
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