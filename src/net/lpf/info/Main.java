/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lpf.info;

import java.util.ArrayList;
import net.lpf.info.base.AbstractKernel;
import net.lpf.info.base.LabController;
import net.lpf.info.base.LabView;
import net.lpf.info.method.BigramKernel;
import net.lpf.info.method.SquareKernel;
import net.lpf.info.method.SwapKernel;

/**
 *
 * @author anyk3y
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<AbstractKernel> algs = new ArrayList<>();
        algs.add(new SwapKernel());
        algs.add(new BigramKernel());
        algs.add(new SquareKernel());
        new LabController(new LabView(), algs);
    }
    
}
