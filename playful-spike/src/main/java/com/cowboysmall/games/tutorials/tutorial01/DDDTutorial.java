package com.cowboysmall.games.tutorials.tutorial01;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class DDDTutorial extends JFrame{
	static JFrame F = new DDDTutorial();
	
	public DDDTutorial()
	{
		setUndecorated(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		
	}
}
