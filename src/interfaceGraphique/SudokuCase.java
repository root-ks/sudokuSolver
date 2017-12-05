package interfaceGraphique;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class SudokuCase extends JPanel implements MouseListener
{
	private JButton cases[];
	private static Box box;
	
	public SudokuCase()
	{
		this.cases = new JButton[9];
		
		for(int i=0;i<9;i++)
		{
			this.cases[i] = new JButton("-");
			this.cases[i].addMouseListener(this);
			this.cases[i].setPreferredSize(new Dimension(50,50));
			
			this.add(this.cases[i]);
		}
		
		this.setLayout(new GridLayout(3,3));
	}
	
	public void resetCases()
	{
		for(int i=0;i<9;i++)
		{
			this.cases[i].setText("-");
		}
	}
	
	public void initBox()
	{
		SudokuCase.box = new Box(this.getTopLevelAncestor());
		SudokuCase.box.ajouterMouseListenerToCase(this);
	}
	
	public int indiceButt(JButton butt)
	{
		for(int i=0;i<9;i++)
		{
			if(butt==this.cases[i])
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
		String nomSourceParent = bouton.getParent().getClass().getName();

		System.out.println("Objet :"+nomSourceParent);
		
		if(nomSourceParent.contains("SudokuCase"))
		{	
			SudokuCase.box.setSourceAppel(bouton);
			SudokuCase.box.afficher(true);
		}
		else if(nomSourceParent.contains("Box"))
		{
			String strChoix = bouton.getText();
			
			//Passage du texte 
			int valeurButt = Integer.parseInt(strChoix);
			int indiceSudokuCase = ((Sudoku)this.getParent()).indiceCase(this);
			int indiceButt = this.indiceButt(bouton);
			
			((Sudoku)this.getParent()).getDonnées().remplirCaseIndice(valeurButt, indiceSudokuCase, indiceButt);
			SudokuCase.box.getSourceAppel().setText(strChoix);
			SudokuCase.box.afficher(false);
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
