package com.synerzip.helper;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import com.synerzip.model.StudentModel;
import com.synerzip.service.StudentService;
import com.synerzip.service.impl.StudentServiceImpl;
import com.synerzip.ui.MyFrame;

public class StudentListener implements ActionListener, WindowListener {

	private MyFrame myFrame;
	private StudentModel studentModel;
	public static StudentService studentService = new StudentServiceImpl();

	public StudentListener(MyFrame myFrame) {
		// TODO Auto-generated constructor stub
		this.myFrame = myFrame;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		myFrame.dispose();

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Button button = (Button) actionEvent.getSource();

		String buttonLabel = button.getLabel();
		// TODO Auto-generated method stub
		studentModel = new StudentModel();

		
		if (buttonLabel.equals("Save")) {
			try {

				studentModel.setRollno(Integer.parseInt(myFrame.rollNoTxt.getText()));
				studentModel.setName(myFrame.nameTxt.getText());
				studentModel.setAddress(myFrame.addresstxt.getText());
				studentModel.setMarks(Float.parseFloat(myFrame.marksTxt.getText()));
				studentModel.setAge(myFrame.age.getSelectedItem());
				studentModel.setGender(myFrame.gender.getSelectedCheckbox().getLabel());

				studentService.save(studentModel);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (buttonLabel.equals("Update")) {
			try {
				studentModel.setRollno(Integer.parseInt(myFrame.rollNoTxt.getText()));
				studentModel.setName(myFrame.nameTxt.getText());
				studentModel.setAddress(myFrame.addresstxt.getText());
				studentModel.setMarks(Float.parseFloat(myFrame.marksTxt.getText()));
				studentModel.setAge(myFrame.age.getSelectedItem());
				studentModel.setGender(myFrame.gender.getSelectedCheckbox().getLabel());

				studentService.update(studentModel);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (buttonLabel.equals("Delete")) {
			try {
				studentService.delete(Integer.parseInt(myFrame.rollNoTxt.getText()));
				studentService.resulset();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (buttonLabel.equals("Search")) {
			try {
				studentModel = studentService.search(Integer.parseInt(myFrame.rollNoTxt.getText()));
				studentService.resulset();

				myFrame.rollNoTxt.setText(String.valueOf(studentModel.getRollno()));
				myFrame.nameTxt.setText(studentModel.getName());
				myFrame.addresstxt.setText(studentModel.getAddress());
				myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
				myFrame.age.select(studentModel.getAge());
				if (studentModel.getGender().equals("Male")) {
					myFrame.male.setState(true);
				} else {
					myFrame.female.setState(true);
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (buttonLabel.equals("First")) {
			try {
				studentModel = studentService.first();

				myFrame.rollNoTxt.setText(String.valueOf(studentModel.getRollno()));
				myFrame.nameTxt.setText(studentModel.getName());
				myFrame.addresstxt.setText(studentModel.getAddress());
				myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
				myFrame.age.select(studentModel.getAge());
				if (studentModel.getGender().equals("Male")) {
					myFrame.male.setState(true);
				} else {
					myFrame.female.setState(true);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (buttonLabel.equals("Previous")) {
			try {
				studentModel = studentService.prev();

				myFrame.rollNoTxt.setText(String.valueOf(studentModel.getRollno()));
				myFrame.nameTxt.setText(studentModel.getName());
				myFrame.addresstxt.setText(studentModel.getAddress());
				myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
				myFrame.age.select(studentModel.getAge());
				if (studentModel.getGender().equals("Male")) {
					myFrame.male.setState(true);
				} else {
					myFrame.female.setState(true);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (buttonLabel.equals("Next")) {
			try {
				studentModel = studentService.next();

				myFrame.rollNoTxt.setText(String.valueOf(studentModel.getRollno()));
				myFrame.nameTxt.setText(studentModel.getName());
				myFrame.addresstxt.setText(studentModel.getAddress());
				myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
				myFrame.age.select(studentModel.getAge());
				if (studentModel.getGender().equals("Male")) {
					myFrame.male.setState(true);
				} else {
					myFrame.female.setState(true);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (buttonLabel.equals("Last")) {
			try {
				studentModel = studentService.last();

				myFrame.rollNoTxt.setText(String.valueOf(studentModel.getRollno()));
				myFrame.nameTxt.setText(studentModel.getName());
				myFrame.addresstxt.setText(studentModel.getAddress());
				myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
				myFrame.age.select(studentModel.getAge());
				if (studentModel.getGender().equals("Male")) {
					myFrame.male.setState(true);
				} else {
					myFrame.female.setState(true);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
