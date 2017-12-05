package algorithmeResolution;

public class ObjetDeComparaison 
{
	int[] TabDeValeurASuprimer;
	int NbrDeValeur;
	
	
	
	public ObjetDeComparaison() {
		super();
		TabDeValeurASuprimer = new int[9];
		NbrDeValeur = 0;
	}
	
	public void addValeur(int a)
	{
		this.TabDeValeurASuprimer[NbrDeValeur]=a;
		NbrDeValeur++;	
	}
	 public void display()
	 {
		 for (int i = 0; i < 9; i++)
		 {
			 System.out.print(this.TabDeValeurASuprimer[i]+" ");
			
		}
		System.out.print("\n");
	 }
	
	
	
	

}
