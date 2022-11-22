package net.lpf.info.base;

public abstract class AbstractKernel {
    private final String name;
    private final boolean passUsing;
    public AbstractKernel(String name, boolean passUsing){
        this.name = name;
        this.passUsing = passUsing;
    }
    public abstract String makeEncryptedText(String openText, String pass);
    public abstract String recoverOpenText(String encryption, String pass);
    public String getName(){
        return this.name;
    }
    public boolean usesPass(){
        return this.passUsing;
    }
}
 
