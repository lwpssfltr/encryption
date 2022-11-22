/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lpf.info.method;

import net.lpf.info.extra.lab1.PassBlock;
import net.lpf.info.extra.lab1.CodeBlock;
import net.lpf.info.extra.lab1.CodeBlockComparator;
import net.lpf.info.extra.lab1.EncryptedCodeBlock;
import net.lpf.info.extra.lab1.EncryptedCodeBlockComparator;
import java.util.Arrays;
import net.lpf.info.base.AbstractKernel;

/**
 *
 * @author anyk3y
 */
public class SwapKernel extends AbstractKernel{
    public SwapKernel(){
        super("swap", true);
    }
    @Override
    public String recoverOpenText(String encryption, String pass) {
        int dim[] = getDimensions(encryption, pass);
        EncryptedCodeBlock [] tab1 = generateStage1(encryption, pass);
        String message = "";
        for (int i = 0, j = 0; i < dim[2] && j < dim[0];) {
            message += tab1[j].getCharAt(i);
            j ++;
            if (j >= dim[0]) {
                j = 0;
                i ++;
            }
        }
        return message;
    }
    private int[] getDimensions(String text, String pass) {
        int[] dim = new int[4];
        dim[0] = pass.length();
        dim[1] = text.length();
        dim[2] = dim[1] / dim[0];
        if (dim[1] % dim[0] > 0) dim[2] ++;
        dim[3] = dim[0] * dim[2];
        return dim;
    }
    private CodeBlock[] generateStage0(String openText, String pass) {
        int[] dim = getDimensions(openText, pass);
        char[][] stage0 = new char[dim[2]][dim[0]];
        for (int i = 0; i < dim[0]; i ++){
            for (int j = 0; j < dim[2]; j++){
                stage0[j][i] = ' ';
            }
        }
        for (int i = 0, j = 0, k = 0; i < dim[1]; i ++) {
            stage0[j][k] = openText.charAt(i);
            k ++;
            if (k >= dim[0]) {
                k = 0;
                j ++;
            }
        }
        CodeBlock[] tab0 = new CodeBlock[dim[0]];
        for (int i = 0; i < dim[0]; i ++) {
            char[] col = new char[dim[2]];
            for (int j = 0; j < dim[2]; j ++) {
                col[j] = stage0[j][i];
            }
            tab0[i] = new CodeBlock(pass.charAt(i), col);
        }
        Arrays.parallelSort(tab0, new CodeBlockComparator());
        return tab0;
    }
    @Override
    public String makeEncryptedText(String openText, String pass) {
        CodeBlock[] tab0 = generateStage0(openText, pass);
        int[] dim = getDimensions(openText, pass);
        String stage1 = new String();
        for (int k = 0; k < dim[0]; k ++) {
            for (int i = 0, j = 0; i < dim[3] && j < dim[2]; j ++) {
                stage1 += tab0[k].getColumn()[j];
                i ++;
                if (i >= dim[3]) { break; }
            }            
        }
        return stage1;
    }

    private EncryptedCodeBlock[] generateStage1(String encryption, String pass) {
        int dim[] = getDimensions(encryption, pass);
        PassBlock passBlock = new PassBlock(pass.toCharArray());
        passBlock.sortByChars();
        char[][] stage1 = new char[dim[0]][dim[2]];
        for (int i = 0, j = 0, k = 0; i < dim[1]; i ++) {
            stage1[j][k] = encryption.charAt(i);
            k ++;
            if (k >= dim[2]) {
                k = 0;
                j ++;
            }
        }
        EncryptedCodeBlock[] tab1 = new EncryptedCodeBlock[dim[0]];
        for (int i = 0; i < dim[0]; i ++) {
            char[] column = new char[dim[2]];
            for (int j = 0; j < dim[2]; j ++) {
                column[j] = stage1[i][j];
            }
            tab1[i] = new EncryptedCodeBlock(passBlock.getPassLetterAt(i), column);
        }
        Arrays.parallelSort(tab1, new EncryptedCodeBlockComparator());
        return tab1;
    }
}
