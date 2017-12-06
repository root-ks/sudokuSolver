package algorithmeResolution;

public class CaseDeSodoku {

	protected ElementDeSudoku[][] C;
	protected CaseDeSodoku CaseDuHaut;
	protected CaseDeSodoku CaseDeGauche;
	protected CaseDeSodoku CaseDeDroite;
	protected CaseDeSodoku CaseDuBas;

	//Effacage des anciens test et try de push depuis Eclipse plusieurs fichier


	/*GESTION DES CASES */

	public ObjetDeComparaison getTableauDesValeurARetirerParCase()
	{
		ObjetDeComparaison o1 = new ObjetDeComparaison();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (this.C[i][j].valeurDeLaCase!= 0)
				{
					o1.addValeur(this.C[i][j].valeurDeLaCase);
				}
			}
		}
		return o1;
	}

	public void affinageDesCases(ObjetDeComparaison o1)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (this.C[i][j].valeurDeLaCase==0)
				{
					this.C[i][j].supprimerValeurDeValeurPotentielle(o1);
				}
			}
		}
	}


	/*GESTION DES LIGNES */
	public ObjetDeComparaison getTableauDesValeurARetirerParLigne(int a)
	{
		ObjetDeComparaison o1 = new ObjetDeComparaison();
		CaseDeSodoku temp=this;

		for (int i = 0; i < 3; i++)
		{
			if (temp.C[a][i].valeurDeLaCase!=0)
			{
				o1.addValeur(temp.C[a][i].valeurDeLaCase);
			}

			if (i==2)
			{
				i=-1;
				if (temp.CaseDeDroite!=null)
				{
					temp=temp.CaseDeDroite;
				}
				else
				{
					i=2;
				}
			}

		}

		return o1;
	}

	public void affinageParLignes(int a, ObjetDeComparaison o1)
	{
		CaseDeSodoku temp=this;

		for (int i = 0; i < 3; i++)
		{
			temp.C[a][i].supprimerValeurDeValeurPotentielle(o1);

			if (i==2)
			{
				i=-1;

			if(temp.CaseDeDroite!=null)
				{
				temp=temp.CaseDeDroite;
				}
			else
			{
				i=2;
			}
			}
		}
	}


	/*GESTION DE COLONE */

	public ObjetDeComparaison getTableauDeValeurARetirerParColone(int a)
	{
		ObjetDeComparaison o1 = new ObjetDeComparaison();
		CaseDeSodoku temp=this;
		for (int i = 0; i < 3; i++)
		{
			if (temp.C[i][a].valeurDeLaCase!=0)
			{
				o1.addValeur(temp.C[i][a].valeurDeLaCase);
			}

			if(i==2)
			{
				i=-1;

					if (temp.CaseDuBas!=null)
					{
						temp=temp.CaseDuBas;
					}
					else
					{
						i=2;
					}
			}
		}
		return o1;
	}


	public void affinageParColonne (int a, ObjetDeComparaison o1)
	{
		CaseDeSodoku temp=this;
		for (int i = 0; i < 3; i++)
		{
			temp.C[i][a].supprimerValeurDeValeurPotentielle(o1);

			if (i==2)
			{
				i=-1;

				if(temp.CaseDuBas!=null)
				{
					temp=temp.CaseDuBas;
				}
				else
				{
					i=2;
				}
			}


		}
	}



	/*Methode qui affiche tout le sudoku*/
	public void afficherLigneDeLaCase(int a)
	{
		CaseDeSodoku temp;
		temp=this;
		int i=0;
		int caseHorizontal=0;

		while (caseHorizontal<=2)
		{

			System.out.print(temp.C[a][i].getValues()+" ");
			i++;
			if (i>=3)
			{
				System.out.print("  ");
				if(temp.CaseDeDroite!=null)
					{
					temp=temp.CaseDeDroite;
					}
				else
				{
					System.out.print("\n");
				}

				i=0;
				caseHorizontal++;

			}
		}
	}

	/*Constructeur De l'objet CaseDeSudoku*/
	public CaseDeSodoku( CaseDeSodoku caseDuHaut, CaseDeSodoku caseDeGauche,
			CaseDeSodoku caseDeDroite, CaseDeSodoku caseDuBas)
	{
		this.C = new ElementDeSudoku[3][3];
		this.CaseDuHaut = caseDuHaut;
		this.CaseDeGauche = caseDeGauche;
		this.CaseDeDroite = caseDeDroite;
		this.CaseDuBas = caseDuBas;

		for (int i = 0; i <= 2; i++)
		{
			for (int j = 0; j <=2; j++)
			{
				this.C[i][j]=new ElementDeSudoku();
			}

		}
	}


}
