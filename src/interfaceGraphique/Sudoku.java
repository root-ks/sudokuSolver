package interfaceGraphique;

import java.awt.Dimension;
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
		this.caseZone = new SudokuCase[9];
		
		for(int i=0; i<9; i++)
		{
			this.caseZone[i]=new SudokuCase();
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
	
	public void initBox()
	{
		for(int i=0; i<9; i++)
		{
			this.caseZone[i].initBox();
		}
	}
	
	public int indiceCase(SudokuCase sc)
	{
		for(int i=0;i<9;i++)
		{
			if(sc==this.caseZone[i])
			{
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		JButton bouton = (JButton) e.getSource();
		String str = bouton.getText();
		
		if(str.compareTo("Reset")==0)
		{
			for(int i=0;i<9;i++)
			{
				this.caseZone[i].resetCases();
			}
		}
		else if(str.compareTo("Résoudre")==0)
		{
			//Code de PICKLORIK
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
