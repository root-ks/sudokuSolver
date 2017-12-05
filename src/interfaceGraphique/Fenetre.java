package interfaceGraphique;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Fenetre extends JFrame
{
	JFrame fenetre; 
	
	public Fenetre ()
	{
		super("Sudoku Java"); 
		this.setSize(540, 570);
		this.setResizable(false);
		this.setLocationRelativeTo(null); //centre la fenetre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Sudoku sudoku = new Sudoku();
		
		this.setContentPane(sudoku);
		
		((Sudoku)this.getContentPane()).initBox();
		
		System.out.println(sudoku.getComponentCount() + " composant(s) dans le Container");
		
		this.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.out.println("Fermeture de la fenêtre");
				}
			}
		);
	}
}
