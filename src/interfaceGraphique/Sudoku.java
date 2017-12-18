package interfaceGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Sudoku extends JPanel implements MouseListener
{	
	private SudokuCase[] caseZone; 
	private JButton reset; 
	private JButton solve;
	
	private algorithmeResolution.Sudoku données; 
	
	public Sudoku()
	{
		this.setSize(540, 570);
		
		this.caseZone = new SudokuCase[9];
		
		for(int i=0; i<9; i++)
		{
			this.caseZone[i]=new SudokuCase(i);
			this.add(this.caseZone[i]);
		}
		
		this.reset = new JButton("Reset");
		this.solve = new JButton("Résoudre");
		
		this.reset.addMouseListener(this);
		this.solve.addMouseListener(this);

		this.reset.setPreferredSize(new Dimension(100,50));
		this.solve.setPreferredSize(new Dimension(100,50));

		this.add(this.solve);
		this.add(this.reset);
		
		this.données = new algorithmeResolution.Sudoku();
	}

	public algorithmeResolution.Sudoku getDonnées()
	{
		return this.données;
	}
	
	public void initBox(Point fenetreXY)
	{
		SudokuCase.initBox(fenetreXY);
	}
	
	public void remplirCasesResolues()
	{
		JButton bouton;
		int val;
		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				bouton = this.caseZone[i].getButt(j);
				if(bouton.getText().compareTo("-")==0)
				{
					//val = this.données.getCase
					bouton.setForeground(Color.RED);
					
				}
				else
				{
					
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		JButton bouton = (JButton) e.getSource();
		String str = bouton.getText();
		
		if(str.compareTo("Reset")==0)
		{
			System.out.println("Grille remise à zéro");
			for(int i=0;i<9;i++)
			{
				this.caseZone[i].resetCases();
			}
		}
		else if(str.compareTo("Résoudre")==0)
		{
			//Code de PICKLORIK
			this.données.resoudreSudoku();
			this.données.affichage();
			
			this.remplirCasesResolues();
		}
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0){}
	@Override
	public void mouseExited(MouseEvent arg0){}
	@Override
	public void mousePressed(MouseEvent arg0){}
	@Override
	public void mouseReleased(MouseEvent arg0){}
}
