package algorithmeResolution;

public class ElementDeSudoku {
	
	protected int valeurDeLaCase;
	protected int [] valeurPotentielle;
	protected int nbrValeur;
	
	public void disp()
	{
		for (int i = 0; i < nbrValeur; i++) 
		{
			System.out.println(this.valeurPotentielle[i]);
			
		}
		
	}

	public void updateValues()
	{
		if (this.nbrValeur==1 && this.valeurDeLaCase==0)
		{
			this.valeurDeLaCase=this.valeurPotentielle[0];
		}
	}
	
	
	public void supprimerValeurDeValeurPotentielle(ObjetDeComparaison o1)
	{
		for (int i = 0; i < o1.NbrDeValeur ; i++) 
		{
			this.removeValues(o1.TabDeValeurASuprimer[i]);
		}
	}
	
	public void removeValues(int a) 
	{
		int b;
		for (int i = 0; i < this.nbrValeur; i++)
		{
			if (this.valeurPotentielle[i]==a)
			{
				b=this.valeurPotentielle[this.nbrValeur-1];
				this.valeurPotentielle[this.nbrValeur-1]=this.valeurPotentielle[i];
				this.valeurPotentielle[i]=b;
				this.nbrValeur--;
			}
				
		}
	}
	
	
	
	public int getValues()
	{
		
		return this.valeurDeLaCase; 
		
	}
	
	public ElementDeSudoku() 
	{
		this.valeurDeLaCase = 0;
		this.valeurPotentielle = new int[9];
		this.nbrValeur= 9; 
		for (int i = 0; i <9 ; i++) 
		{
			this.valeurPotentielle[i]=i+1;
		}
	}
	
	

}
