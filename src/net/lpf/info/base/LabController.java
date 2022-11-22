package net.lpf.info.base;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class LabController {

    private final LabView l;
    private final ArrayList <AbstractKernel> k;
    private AbstractKernel currentAlg;
    
    public LabController(LabView l, ArrayList <AbstractKernel> k) {
        this.l = l;
        this.k = k;
        initControlling();
    }

    private void initControlling() {
        k.forEach(alg -> l.getAlgSelection().addItem(alg.getName()));
        k.forEach(alg -> {
                if(alg.getName().equals((String)l.getAlgSelection().getSelectedItem())){
                    setAlg(alg);
                }
            });
        l.getAlgSelection().addActionListener(ae -> 
            k.forEach(alg -> {
                if(alg.getName().equals((String)l.getAlgSelection().getSelectedItem())){
                    setAlg(alg);
                    l.getPassEncode().setEnabled(alg.usesPass());
                    l.getPassDecode().setEnabled(alg.usesPass());
                }
            })
        );
        l.getEncodeButton().addActionListener(ae -> 
            l.getOutputEncode().setText(currentAlg.makeEncryptedText(l.getInputEncode().getText(), l.getPassEncode().getText()))
        );
        l.getDecodeButton().addActionListener((ActionEvent ev) ->
            l.getOutputDecode().setText(currentAlg.recoverOpenText(l.getInputDecode().getText(), l.getPassDecode().getText()))
        );
    }
    private void setAlg(AbstractKernel k){
        this.currentAlg = k;
    }
}
