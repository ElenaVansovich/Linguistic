/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguistic;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author user
 */
public class WordInfo {
    private String tag;
    private int frequency;
    //единственное число, множественное, 3 формы(если глагол)
    private String form;

    
    public WordInfo() throws IOException, ClassNotFoundException{
        tag = "";
        frequency = 0;
    }
    
    public WordInfo(int frequency, String tag, String form) throws IOException, ClassNotFoundException{
        this.tag = tag;
        this.frequency = frequency;
        this.form = form;
    }
    
    public String getForms() {
        return form;
    }

    public void setForms(String form) {
        this.form = form;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getTag() {
        return tag;
    }

    public int getFrequency() {
        return frequency;
    }
}
