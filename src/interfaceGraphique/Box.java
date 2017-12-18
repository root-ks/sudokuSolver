package interfaceGraphique;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Box extends JPanel implements MouseListener
{
	private JButton box[];
	private JButton sourceAppel; 
	private JFrame fenetreBox;
	
	public Box (Point windPos)
	{
		this.fenetreBox = new JFrame();
		this.fenetreBox.setSize(200, 250);
		this.fenetreBox.setLocation(new Point(windPos.x+540,windPos.y+15));
		this.fenetreBox.setResizable(false);
		//this.fenetreBox.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.box = new JButton[10];
		
		for(int i=0;i<9;i++)
		{
			this.box[i] = new JButton(String.valueOf(i+1));
			this.box[i].setPreferredSize(new Dimension(50,50));
		}
		
		this.box[9] = new JButton("-");
		this.box[9].setPreferredSize(new Dimension(50,50));
		this.add(this.box[9]);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int y=0;
		gbc.gridy=0;
		for (int i=0;i<9;i++)
		{
			gbc.gridx=y;
			this.add(this.box[i],gbc);
			if(y==2)
			{
				y=0;
				gbc.gridy=gbc.gridy+1;
			}
			else
			{
				y++;
			}
		}
		
		gbc.gridy=3;
		gbc.gridx=1;
		this.add(this.box[9],gbc);
		
		this.fenetreBox.setContentPane(this);
		this.fenetreBox.setVisible(false);
	}
	
	public JButton getSourceAppel()
	{
		return this.sourceAppel;
	}
	
	public void setSourceAppel(JButton bouton)
	{
		this.sourceAppel=bouton;
	}
	
	public void ajouterMouseListenerToCase()
	{
		for(int i=0;i<10;i++)
		{
			this.box[i].addMouseListener(this);
		}
	}
	
	public void afficher(boolean bool)
	{
		this.fenetreBox.setVisible(bool);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		SudokuCase.boxClicked(e);
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
