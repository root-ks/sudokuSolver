package interfaceGraphique;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class SudokuCase extends JPanel implements MouseListener
{
	private JButton cases[];
	private int indice;
	private static Box box;
	
	public SudokuCase(int ind)
	{
		this.indice=ind;
		
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
	
	public static void initBox(Point windPos)
	{
		SudokuCase.box = new Box(windPos);
		SudokuCase.box.ajouterMouseListenerToCase();
	}
	
	public int indiceButt(JButton butt)
	{
		for(int i=0;i<9;i++)
		{
			if((this.cases[i].getX()==butt.getX()) && (this.cases[i].getY()==butt.getY()))
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
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0){}
	@Override
	public void mouseExited(MouseEvent arg0){}
	@Override
	public void mousePressed(MouseEvent arg0){}
	@Override
	public void mouseReleased(MouseEvent arg0){}

	public static void boxClicked(MouseEvent e)
	{
		JButton bouton = (JButton) e.getSource();
		String strChoix = bouton.getText();
		
		//Passage du texte 
		int valeurButt;
		if(strChoix.compareTo("-")==0)
		{
			valeurButt = 0;
		}
		else
		{
			valeurButt = Integer.parseInt(strChoix);
		}
		Box box = (Box)bouton.getParent();
		SudokuCase sCase = (SudokuCase)box.getSourceAppel().getParent();
		int indiceSudokuCase = sCase.indice;
		int indiceButt = sCase.indiceButt(SudokuCase.box.getSourceAppel());
	
		System.out.println("Indice case : "+indiceSudokuCase);
		System.out.println("Indice button : "+indiceButt);
		
		((Sudoku)sCase.getParent()).getDonnées().remplirCaseIndice(valeurButt, indiceSudokuCase, indiceButt);
		SudokuCase.box.getSourceAppel().setText(strChoix);
		SudokuCase.box.afficher(false);
	}
}
