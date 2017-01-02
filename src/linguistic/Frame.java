/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguistic;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.util.CoreMap;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author user
 */
public class Frame extends javax.swing.JFrame {

    public File file;
    private Map<String, WordInfo> wordsDictionaryMap = new TreeMap<>();
    private String fileout = "";
    private final String[] columnNames = new String[2];
    private DefaultTableModel model;
    public JTable currentTable;
    private int k = 0;
    public boolean isOpenDictionary = false;
    public StanfordCoreNLP pipeline;
    
    /**
     * Creates new form Frame
     */
    public Frame() throws IOException, ClassNotFoundException {
        
        initComponents();
        
        currentTable = new JTable();
        model = new DefaultTableModel();
        currentTable.setVisible(false);
        showTextjTextArea.setVisible(false);
        
        columnNames[0] = "Word";
        columnNames[1] = "Frequency";
        
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");
        pipeline = new StanfordCoreNLP(props);
      
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                closeOperation();
            }
        });
    }

    
    JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    JTextArea showTextjTextArea = new javax.swing.JTextArea();
    JScrollPane tableScrollPane = new javax.swing.JScrollPane();
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        infoMenuItem = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        tagInfoMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu4.setText("Dictionary");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem6.setText("Create dictionary");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem5.setText("Open dictionary");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Text");

        jMenuItem7.setText("Open text");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("Annotate text");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem9.setText("Add to dictionary");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Options");

        infoMenuItem.setText("Get info about word");
        infoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(infoMenuItem);

        jMenuItem4.setText("Groups");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        jMenu2.add(quitMenuItem);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Statistics");

        jMenuItem2.setText("Tag - amount");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Word, tag - amount");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        tagInfoMenu.setText("Information");

        jMenuItem1.setText("Tag information");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        tagInfoMenu.add(jMenuItem1);

        jMenuBar1.add(tagInfoMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static boolean isLetter(char c) {   
        if ( (c >= 97) && (c <= 122) ){
            return true;
        } // a - z
        if ( (c >= 65) && (c <= 90) ) {
            return true;
        } // A - Z
        return false;
      }

    public static char toLower(char c) {
      if ( (c >= 65) && (c <= 90) ){
          return (char)((char)c+32);
      } // A-Z to a-z
      return c;
    }
    
    public StringBuffer readFileInBuff(File file){        
        String msg;
        StringBuffer stringbuff = new StringBuffer("");
    
        try {
            BufferedReader buffreader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String line;
            while ( (line = buffreader.readLine()) != null) {
              stringbuff.append(line);
            }
            buffreader.close();
        } catch (FileNotFoundException ex) {
            msg = "Problem accessing file " + file.getAbsolutePath();
            JOptionPane.showMessageDialog(null,
                    msg,
                    "FileNotFoundException",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            msg = "Input/output error";
            JOptionPane.showMessageDialog(null,
                    msg,
                    "IOException",
                    JOptionPane.PLAIN_MESSAGE);
        }
        return stringbuff;
    }
    
    public void writeFile(String file, Map<String, WordInfo> map) throws ClassNotFoundException{
        String msg;
        try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Map.Entry<String, WordInfo> entry: map.entrySet()) {
          bw.write(entry.getKey() + ":" + entry.getValue().getForms() + "," + entry.getValue().getFrequency() + "," + 
                  entry.getValue().getTag() + ";");
          bw.newLine();
        }
        bw.close();
        msg = "The text is sorted and found the frequency of words, the result is placed in the file: " + fileout;
            JOptionPane.showMessageDialog(null,
                    msg,
                    "",
                    JOptionPane.PLAIN_MESSAGE);
        
      } catch (IOException ex) {
        msg = "Input/output error";
            JOptionPane.showMessageDialog(null,
                    msg,
                    "IOException",
                    JOptionPane.PLAIN_MESSAGE);
      }
    }
    
    public void writeTable(JTable table, Map<String, WordInfo> map) throws IOException, ClassNotFoundException{
        int i = 0;
        for (Map.Entry<String, WordInfo> entry: map.entrySet()) {
          table.setValueAt(entry.getKey(), i, 0);
          table.setValueAt(entry.getValue().getFrequency(), i, 1);
          i++;
        }
    }
       
    public Map<String, Integer> readTable(JTable table){
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < table.getRowCount(); i++){
            map.put(table.getValueAt(i, 0).toString(), (Integer) table.getValueAt(i, 1));
        }
        return map;
    }
    
    public String getTagger(String word){
        String tag = "";
        Annotation document = null; 
        document = new Annotation(word);
        pipeline.annotate(document); 
        List<CoreMap> sentences = 
        document.get(CoreAnnotations.SentencesAnnotation.class); 
        for (CoreMap sentence : sentences) { 
            for (CoreLabel word1 : sentence.get(CoreAnnotations.TokensAnnotation.class)) { 
                    tag = word1.tag();
            }
        }
        return tag;
    }
    
    
    public String getBasicForm(String word){
        
      Annotation document = new Annotation(word);
      pipeline.annotate(document);
      
      List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
      String lemma = "";
      
      for(CoreMap sentence: sentences){
          for(CoreLabel part: sentence.get(CoreAnnotations.TokensAnnotation.class)){
              lemma = part.get(CoreAnnotations.LemmaAnnotation.class);
          }
      }
      if(word.equals("etc.") || word.equals("pp.")){
          lemma = word;
      }
      return lemma;
    }
    
    Map<String, Integer> wordTagAmountMap = new TreeMap<>();
    public void createMap(String text, Map<String, WordInfo> map) throws IOException, ClassNotFoundException{
        
        String tag = "";
        Annotation document = null; 
        document = new Annotation(text);
        pipeline.annotate(document); 
        List<CoreMap> sentences = 
        document.get(CoreAnnotations.SentencesAnnotation.class); 
        for (CoreMap sentence : sentences) { 
            for (CoreLabel word1 : sentence.get(CoreAnnotations.TokensAnnotation.class)) { 
                    tag = word1.tag();
                    textTag += word1.originalText() + "_" + tag + " ";
                    String word = word1.originalText().toLowerCase();
                    char c = word.charAt(0);
                    if(!tag.equals("CD") && !tag.equals("CC") && !tag.equals("NNS")
                             && !tag.equals("NNP") && !tag.equals(".")
                            && !tag.equals(":") && !tag.equals(";") && !tag.equals(",")
                            && isLetter(c))
                    {
                        if (map.containsKey(word)) {
                            int fr = map.get(word).getFrequency() + 1;
                            if(map.get(word).getTag().contains("/" + tag + "/"))
                            {
                                wordTagAmountMap.put(word + " - " + tag, wordTagAmountMap.get(word + " - " + tag) + 1);
                                map.put(word, new WordInfo(fr, map.get(word).getTag(), getBasicForm(word)));
                            }
                            else
                            {
                                wordTagAmountMap.put(word + " - " + tag, 1);
                                map.put(word, new WordInfo(fr, map.get(word).getTag() + tag + "/", getBasicForm(word)));
                            }
                        }
                        else {
                           wordTagAmountMap.put(word + " - " + tag, 1);
                           map.put(word, new WordInfo(1, "/" + tag + "/", getBasicForm(word)));
                        }
                    }
                    
                    
            }
        }
        
        
        /*StringBuffer word = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
          char c = text.charAt(i);
          if ( isLetter(c) ) {
            word.append(toLower(c));
          }
          else {
              if ( word.length() != 0 ) {
                if(c == 150 || c == 151 || c == 45){
                    if(c > 0 && (text.charAt(i - 1) == 150 || text.charAt(i - 1) == 151 ||
                            text.charAt(i - 1) == 45 || isLetter(text.charAt(i + 1)) == false) ){
                        continue;
                    }
                    word.append(c);
                }
                else{
                    String tag = getTagger(word.toString());
                        /*if(wordsDictionaryMap.get(word).getTag().contains("/" + tag + "/"))
                        {
                            wordTagAmountMap.put(word + " - " + tag, wordTagAmountMap.get(word + " - " + tag) + 1);
                            wordsDictionaryMap.put(word, new WordInfo(fr, wordsDictionaryMap.get(word).getTag(), getBasicForm(word)));
                        }
                        else
                        {
                            wordTagAmountMap.put(word + " - " + tag, 1);
                            wordsDictionaryMap.put(word, new WordInfo(fr, wordsDictionaryMap.get(word).getTag() + tag + "/", getBasicForm(word)));
                        }*/
        
                    /*if (wordsDictionaryMap.containsKey(word.toString())) {
                        int fr = wordsDictionaryMap.get(word.toString()).getFrequency() + 1;
                        if(wordsDictionaryMap.get(word.toString()).getTag().contains("/" + tag + "/"))
                        {
                            wordTagAmountMap.put(word.toString() + " - " + tag, wordTagAmountMap.get(word.toString() + " - " + tag) + 1);
                            wordsDictionaryMap.put(word.toString(), new WordInfo(fr, wordsDictionaryMap.get(word.toString()).getTag(), getBasicForm(word.toString())));
                        }
                        else
                        {
                            wordTagAmountMap.put(word + " - " + tag, 1);
                            wordsDictionaryMap.put(word.toString(), new WordInfo(fr, wordsDictionaryMap.get(word.toString()).getTag() + tag + "/", getBasicForm(word.toString())));
                        }
        
                       
                       //wordsMap.put(word.toString(), new WordInfo(fr, getTagger(word.toString()), getBasicForm(word.toString())));
                    }
                    else {
                       wordTagAmountMap.put(word + " - " + tag, 1);
                       wordsDictionaryMap.put(word.toString(), new WordInfo(1, "/" + getTagger(word.toString() + "/"), getBasicForm(word.toString())));
                    }
                  
                  word.delete(0, word.length());
                }
              }
          }     
        }*/
    }

    public void closeOperation(){
        int response = JOptionPane.showConfirmDialog(Frame.this, "Really Quit?");
        if (response == JOptionPane.YES_OPTION) {
            if(isOpenDictionary == true){
                int responseSave = JOptionPane.showConfirmDialog(Frame.this, "Would you like to save changes?");
                if (responseSave == JOptionPane.YES_OPTION) {
                    saveDictionary();
                }
            }
            System.exit(0);
        }
    }
      
    public void setNewValue(int row) throws IOException, ClassNotFoundException{
        String value = (String)JOptionPane.showInputDialog(
                        this,
                        "Input new value:",
                        "",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        (String) currentTable.getValueAt(row, 0));
        if(value != null){
            if(value.equals((String) currentTable.getValueAt(row, 0))){
                return;
            }
            if(wordsDictionaryMap.containsKey(value)){
                int count = wordsDictionaryMap.get(value).getFrequency() + (Integer) currentTable.getValueAt(row, 1);
                wordsDictionaryMap.put(value, new WordInfo(count, wordsDictionaryMap.get(value).getTag(), wordsDictionaryMap.get(value).getForms()));
                wordsDictionaryMap.remove(currentTable.getValueAt(row, 0));
                for(int i = 0; i < currentTable.getRowCount(); i++){
                    if(currentTable.getValueAt(i, 0).equals(value)){
                        currentTable.setValueAt(count, i, 1);
                        model.removeRow(row);
                        currentTable.setModel(model);
                        break;
                    }
                }
            }
            else{
                String tag = getTagger(value);
                wordsDictionaryMap.put(value, new WordInfo((Integer) currentTable.getValueAt(row, 1), 
                        tag, getBasicForm(value)));
                wordsDictionaryMap.remove(currentTable.getValueAt(row, 0));
                currentTable.setValueAt(value, row, 0);
            }    
        }
    }
    
    public void deleteValue(int row){
        int response = JOptionPane.showConfirmDialog(Frame.this, 
                "Would you like to delete word:" + currentTable.getValueAt(row, 0) + "?");
        if (response == JOptionPane.YES_OPTION) {
            wordsDictionaryMap.remove(currentTable.getValueAt(row, 0));
            model.removeRow(row);
            currentTable.setModel(model);
            JOptionPane.showMessageDialog(null,
                        "Word removed from the dictionary.",
                        "",
                        JOptionPane.PLAIN_MESSAGE);
        }   
    }
    
    int rowMousePressed = 0;
    
    MouseAdapter mouseAdapter = new MouseAdapter(){
        @Override
        public void mousePressed(java.awt.event.MouseEvent evt) {
            int row = currentTable.rowAtPoint(evt.getPoint());
            rowMousePressed = row;
            int col = currentTable.columnAtPoint(evt.getPoint());
            currentTable.setColumnSelectionInterval(col, col);
            currentTable.setRowSelectionInterval(row, row);
            
            if (row >= 0 && col >= 0) {
                                
                if(evt.getClickCount() == 2){
                    try {
                        setNewValue(row);
                    } catch (IOException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(evt.getButton() == MouseEvent.BUTTON3){
                    deleteValue(row);
                }
            }
        }
    };
    
    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        closeOperation();
    }//GEN-LAST:event_quitActionPerformed

    public void saveDictionary(){
        try{
            while(fileout.equals("") == true){
                fileout = JOptionPane.showInputDialog("Output file:");
                fileout += "(dict)";
            }
            if(wordsDictionaryMap.isEmpty() == false){
                
                writeFile(fileout, wordsDictionaryMap);
                String msg = "Dictionary save in file: " + fileout;
                JOptionPane.showMessageDialog(null,
                    msg,
                    "",
                    JOptionPane.PLAIN_MESSAGE);
            }
            fileout = "";
        }
        catch(Exception e){}
    }
        
    private void infoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMenuItemActionPerformed
        String word = currentTable.getValueAt(rowMousePressed, 0).toString();
        
        WordInfo wordInfo = null;
        
        WordInfoJDialog wordInfoJFrame =
                new WordInfoJDialog(null, word, wordsDictionaryMap.get(word));
        wordInfoJFrame.pack();
        wordInfoJFrame.setVisible(true);
        
        try {
            wordInfo = new WordInfo(wordsDictionaryMap.get(word).getFrequency(),
                    wordInfoJFrame.getTag(), wordInfoJFrame.getForm());
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        wordsDictionaryMap.put(word, wordInfo);
    }//GEN-LAST:event_infoMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TagInfoJFrame tagInfoJFrame = new TagInfoJFrame();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tagInfoJFrame.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    String text = "";
    String textTag = "";
    
    Map<String, Integer> tagAmount = new TreeMap<>();
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        tagAmount = new TreeMap<>();
        for(WordInfo wordInfo: wordsTextMap.values()){
            String tags = wordInfo.getTag();
            for(int i = 0; i < tags.length()- 1; i++){
                String tag = "";
                if(tags.charAt(i) == '/'){
                    i++;
                    while(tags.charAt(i) != '/'){
                        tag += tags.charAt(i);
                        i++;
                    }
                    if(tagAmount.containsKey(tag)){
                        tagAmount.put(tag, tagAmount.get(tag) + 1);
                    }
                    else{
                        tagAmount.put(tag, 1);
                    }
                    i--;
                }
            }
        }
        
        TagAmountJFrame tagInfoJFrame = new TagAmountJFrame(tagAmount);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tagInfoJFrame.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        tagAmount = new TreeMap<>();
        WordTagAmountJFrame tagInfoJFrame = new WordTagAmountJFrame(wordTagAmountMap);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tagInfoJFrame.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    Map<String, Integer> tagsAmount = new TreeMap<>();
    
    Map<String, String> wordGroups = new TreeMap<>();
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        wordGroups = new TreeMap<>();
        for(String word: wordsTextMap.keySet()){
            String form = wordsTextMap.get(word).getForms();
             if(wordGroups.containsKey(form)){
                 if(!wordGroups.get(form).contains(word)){
                    wordGroups.put(form, wordGroups.get(form) + ", " + word);
                 }
             }
             else{
                 wordGroups.put(form, word);
             }
        }
        
        WordGroupsJFrame tagInfoJFrame = new WordGroupsJFrame(wordGroups);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tagInfoJFrame.setVisible(true);
            }
        });
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(isOpenDictionary){
            int responseSave = JOptionPane.showConfirmDialog(Frame.this, "Would you like to save changes in dictionary?");
                if (responseSave == JOptionPane.YES_OPTION) {
                    saveDictionary();
                }
        }  
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Select the file on which the dictionary will be created");
            String msg;              
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = fileopen.getSelectedFile();
                msg = "Open file: " + file.getName();
                JOptionPane.showMessageDialog(null,
                        msg,
                        "",
                        JOptionPane.PLAIN_MESSAGE);
                isOpenDictionary = true;
            }
            else{
                return;
            }
        
        
        try {
            text = readFileInBuff(file).toString();
            wordsDictionaryMap.clear();
            createMap(text, wordsDictionaryMap);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableScrollPane.setViewportView(currentTable);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        
        model = new DefaultTableModel(columnNames, wordsDictionaryMap.size()){
          @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        
        currentTable = new JTable(model);
        RowSorter<TableModel> sorter = new TableRowSorter<>(model);
        
        currentTable.setRowSorter(sorter);
        
        currentTable.setEnabled(false);
        
        tableScrollPane.setViewportView(currentTable);
        
        try {
            writeTable(currentTable, wordsDictionaryMap);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        currentTable.addMouseListener(mouseAdapter);
        
        showTextjTextArea.setVisible(false);
        tableScrollPane.setVisible(true);
        currentTable.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    public File fileText;
    
    public String textString;
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Select the file on which the dictionary will be created");
        String msg;              
        if (ret == JFileChooser.APPROVE_OPTION) {
            fileText = fileopen.getSelectedFile();
            msg = "Open file: " + fileText.getName();
            JOptionPane.showMessageDialog(null,
                    msg,
                    "",
                    JOptionPane.PLAIN_MESSAGE);
            isOpenDictionary = true;
        }
        else{
            return;
        }
        
        showTextjTextArea.setColumns(20);
        showTextjTextArea.setRows(5);
        jScrollPane1.setViewportView(showTextjTextArea);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        textString = "";
        textString = readFileInBuff(fileText).toString();
        showTextjTextArea.setText(textString);
        showTextjTextArea.setLineWrap(true);
        showTextjTextArea.setBackground(Color.white);
        
        
        tableScrollPane.setVisible(false);
        jScrollPane1.setVisible(true);
        showTextjTextArea.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private Map<String, WordInfo> wordsTextMap = new TreeMap<>();
    
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(fileDict == null){
            String msg = "Any dictionary is not open!";
            JOptionPane.showMessageDialog(null,
                    msg,
                    "",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        try {
            wordsTextMap = new TreeMap<>();
            createMap(textString, wordsTextMap);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableScrollPane.setViewportView(currentTable);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        
        model = new DefaultTableModel(columnNames, wordsTextMap.size()){
          @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        
        currentTable = new JTable(model);
        RowSorter<TableModel> sorter = new TableRowSorter<>(model);
        
        currentTable.setRowSorter(sorter);
        
        currentTable.setEnabled(false);
        
        tableScrollPane.setViewportView(currentTable);
        
        try {
            writeTable(currentTable, wordsTextMap);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        currentTable.addMouseListener(mouseAdapter);
        
        showTextjTextArea.setVisible(false);
        jScrollPane1.setVisible(false);
        currentTable.setVisible(true);
        tableScrollPane.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        
        if(!wordsTextMap.isEmpty() && isOpenDictionary){
            wordsDictionaryMap.putAll(wordsTextMap);
            String msg = "Words added to the dictionary.";
            JOptionPane.showMessageDialog(null,
                    msg,
                    "",
                    JOptionPane.PLAIN_MESSAGE);
        }
        else{
            String msg = "There are no words to add or dictionary was not selected.";
            JOptionPane.showMessageDialog(null,
                    msg,
                    "",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    File fileDict;
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        if(isOpenDictionary){
            int responseSave = JOptionPane.showConfirmDialog(Frame.this, "Would you like to save changes in dictionary?");
                if (responseSave == JOptionPane.YES_OPTION) {
                    saveDictionary();
                }
        }  
        
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Select dictionary");
        String msg;              
        if (ret == JFileChooser.APPROVE_OPTION) {
            fileDict = fileopen.getSelectedFile();
            msg = "Open file: " + fileDict.getName();
            JOptionPane.showMessageDialog(null,
                    msg,
                    "",
                    JOptionPane.PLAIN_MESSAGE);
            
            if(!fileDict.getName().contains("(dict)")){
                msg = "It's not a dictionary: " + fileDict.getName();
                JOptionPane.showMessageDialog(null,
                        msg,
                        "",
                        JOptionPane.PLAIN_MESSAGE);
                fileDict = null;
                return;
            }
            fileout = fileDict.getName();
            isOpenDictionary = true;
        }
        else{
            return;
        }
        
        text = readFileInBuff(fileDict).toString();
            wordsDictionaryMap.clear();
        try {
            createMap(text, wordsDictionaryMap);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableScrollPane.setViewportView(currentTable);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        
        model = new DefaultTableModel(columnNames, wordsDictionaryMap.size()){
          @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        
        currentTable = new JTable(model);
        RowSorter<TableModel> sorter = new TableRowSorter<>(model);
        
        currentTable.setRowSorter(sorter);
        
        currentTable.setEnabled(false);
        
        tableScrollPane.setViewportView(currentTable);
        
        try {
            writeTable(currentTable, wordsDictionaryMap);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        currentTable.addMouseListener(mouseAdapter);
        
        showTextjTextArea.setVisible(false);
        tableScrollPane.setVisible(true);
        currentTable.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed

    }//GEN-LAST:event_jMenu4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem infoMenuItem;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JMenu tagInfoMenu;
    // End of variables declaration//GEN-END:variables
}