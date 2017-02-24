package com.synerzip.ui;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.synerzip.helper.StudentListener;

public class MyFrame extends Frame  {

  public TextField rollNoTxt;
  public TextField nameTxt;
  public TextField marksTxt;
  public Label rollNoLbl;
  public Label nameLbl;
  public Label marksLbl;
  public Label addressLbl;
  public Label ageLbl;
  public Label genderLbl;
  public TextArea addresstxt;
  public Choice age;
  public CheckboxGroup gender ;
  public Checkbox male;
  public Checkbox female;
  public Button save;
  public Button update;
  public Button delete;
  public Button search;
  public Button first;
  public Button prev;
  public Button next;
  public Button last;

  StudentListener buttonhandler;
  
  public MyFrame(String title) {
    this.setBounds(100, 100, 1200,1200);
    setVisible(true);
    setTitle(title);
    setLayout(null);
    
    
    rollNoLbl = new Label("Roll No");
    rollNoLbl.setBounds(100, 100, 100, 15);
    add(rollNoLbl);
    
    rollNoTxt = new TextField();
    rollNoTxt.setBounds(200, 100, 100, 20);
    add(rollNoTxt);
    
    nameLbl = new Label("Name");
    nameLbl.setBounds(100, 200, 100, 20);
    add(nameLbl);
    
    nameTxt = new TextField();
    nameTxt.setBounds(200, 200, 100, 20);
    add(nameTxt);

    addressLbl = new Label("Address");
    addressLbl.setBounds(100, 300, 100, 20);
    add(addressLbl);
    
    addresstxt = new TextArea();
    addresstxt.setBounds(200, 300, 200, 80);
    add(addresstxt);
    
    marksLbl = new Label("Marks");
    marksLbl.setBounds(100, 400, 100, 20);
    add(marksLbl);
    
    marksTxt = new TextField();
    marksTxt.setBounds(200, 400, 100, 20);
    add(marksTxt);
    
    ageLbl = new Label("Age");
    ageLbl.setBounds(100, 500, 100, 20);
    add(ageLbl);
    
    age = new Choice();
    age.add("5");
    age.add("6");
    age.add("7");
    age.add("8");
    age.add("9");
    age.add("10");
    age.add("11");
    age.add("12");
    age.add("13");
    age.add("14");
    
    age.setBounds(200, 500, 100, 20);
    add(age);
    
    genderLbl = new Label("Gender");
    genderLbl.setBounds(100, 600, 100, 20);
    add(genderLbl);
    gender = new CheckboxGroup();
    
    male =new Checkbox("Male",gender, true);
    male.setBounds(200, 600, 100, 20);
    add(male);
    
    female =new Checkbox("Female",gender, false);
    female.setBounds(300, 600, 100, 20);
    add(female);

    Button save = new Button("Save");
    save.setBounds(100, 700, 80, 30);
    save.addActionListener(new StudentListener(this));
    add(save);

    Button update = new Button("Update");
    update.setBounds(200, 700, 80, 30);
    update.addActionListener(new StudentListener(this));
    add(update);

    Button delete = new Button("Delete");
    delete.setBounds(300, 700, 80, 30);
    delete.addActionListener(new StudentListener(this));
    add(delete);

    Button search = new Button("Search");
    search.setBounds(400, 700, 80, 30);
    search.addActionListener(new StudentListener(this));
    add(search);

    Button first = new Button("First");
    first.setBounds(100, 800, 80, 30);
    first.addActionListener(new StudentListener(this));
    add(first);

    Button prev = new Button("Previous");
    prev.setBounds(200, 800, 80, 30);
    prev.addActionListener(new StudentListener(this));
    add(prev);

    Button next = new Button("Next");
    next.setBounds(300, 800, 80, 30);
    next.addActionListener(new StudentListener(this));
    add(next);

    Button last = new Button("Last");
    last.setBounds(400, 800, 80, 30);
    last.addActionListener(new StudentListener(this));
    add(last);
    
    buttonhandler = new StudentListener(this);
   addWindowListener(buttonhandler);
 
  }


 
}
