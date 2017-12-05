package algorithmeResolution;


public class Sudoku {
	/*Note générale: les Sudoku est composé de 9 supers cases qui contienent 9 cases 
	  Chaque case contien un nombre de 1 à 9*vtest git /
	
	
	/*Les propiétés*/
	protected CaseDeSodoku[] S1;

	
	/*Les méthodes*/
	
	/*Mise à jour des valeurs dans elementDe sudoku*/
	public void miseAJour()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 3; j++) 
			{
				for (int k = 0; k < 3; k++) 
				{
					this.S1[i].C[j][k].updateValues();	
				}	
			}	
		}
	}
	
	
	
	/*Gestion des cases*/
	/*Retire les valeurs dans element de sudoku qui sont present dans la caseDeSudoku*/
	public void reductionParCase()
	{
		ObjetDeComparaison o1= new ObjetDeComparaison();
		for (int i = 0; i < 9; i++) {
		o1=this.S1[i].getTableauDesValeurARetirerParCase();
		this.S1[i].affinageDesCases(o1);
		}
	}

	
	/*Gestion des lignes*/
	public void reductionParLignes()
	{
		ObjetDeComparaison o1=new ObjetDeComparaison();
		for (int i = 0; i < 8; i=i+3) 
		{
			for (int j = 0; j < 3; j++) 
			{
				o1= this.S1[i].getTableauDesValeurARetirerParLigne(j);
				this.S1[i].affinageParLignes(j,o1);
			}		
		}
	}

	
	/*Gestion des colones*/
	public void reductionParColone()
	{
		ObjetDeComparaison o1 = new ObjetDeComparaison();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3 ; j++) 
			{
				o1=this.S1[i].getTableauDeValeurARetirerParColone(j);
				this.S1[i].affinageParColonne(j,o1);
			}
			
			
		}
		
	}
	
	
	/*Constructeur de base du sudoku*/
	public Sudoku() 
	{
		this.S1 = new CaseDeSodoku[9];
		this.remplisageDuTableau();
	}
 
	
	/*Un methode qui va remplir les 9 cases du tableau de l'objet Sudoku, avec des cases nulls*/
	public void remplisageDuTableau()
	{
		/*Je crée les 9 super case contenant de mon tablau */
		for (int i = 0; i <=8; i++) 
		{
			this.S1[i]= new CaseDeSodoku(null, null, null, null); 
		}
		
		/*Je définis quelle case pointe vers quelle autre case*/
		/*Case 0*/
		this.S1[0].CaseDeDroite=this.S1[1];
		this.S1[0].CaseDuBas=this.S1[3];
		/*Case 1*/
		this.S1[1].CaseDeGauche=this.S1[0];
		this.S1[1].CaseDeDroite=this.S1[2];
		this.S1[1].CaseDuBas=this.S1[4];
		/*Case 2*/
		this.S1[2].CaseDeGauche=this.S1[1];
		this.S1[2].CaseDuBas=this.S1[5];
		/*Case 3*/
		this.S1[3].CaseDuHaut=this.S1[0];
		this.S1[3].CaseDeDroite=this.S1[4];
		this.S1[3].CaseDuBas=this.S1[6];
		/*Case 4*/
		this.S1[4].CaseDuHaut=this.S1[1];
		this.S1[4].CaseDeGauche=this.S1[3];
		this.S1[4].CaseDeDroite=this.S1[5];
		this.S1[4].CaseDuBas=this.S1[7];
		/*Case 5*/
		this.S1[5].CaseDuHaut=this.S1[2];
		this.S1[5].CaseDeGauche=this.S1[4];
		this.S1[5].CaseDuBas=this.S1[8];
		/*Case 6*/
		this.S1[6].CaseDuHaut=this.S1[3];
		this.S1[6].CaseDeDroite=this.S1[7];
		/*Case 7*/
		this.S1[7].CaseDuHaut=this.S1[4];
		this.S1[7].CaseDeGauche=this.S1[6];
		this.S1[7].CaseDeDroite=this.S1[8];
		/*Case 8*/
		this.S1[8].CaseDuHaut=this.S1[5];
		this.S1[8].CaseDeGauche=this.S1[7];
		
	}

	
	public void setValues(int valeur, int numDeCase, int ligne, int colone)
	{
	
		if (this.verifierValeur(valeur)==true)
		{
		this.S1[numDeCase].C[ligne][colone].valeurDeLaCase=valeur;
		}
	}
	
	/*C'est une methode qui verifie que le nombre envoyé est commpris entre 1 et 9*/
	public boolean verifierValeur(int a)
	{
		if (a>=1 || a<=9)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/*//Ici j'insert tout les valeurs dans les cases du sudoku
	public void inisialisation()
	{
		//Insertion dans la grille de la super case 0
		this.setValues(5,0,0,0);
		this.setValues(3,0,0,1);
		this.setValues(6,0,1,0);
		this.setValues(9,0,2,1);
		this.setValues(8,0,2,2);
		
		//Insertion dans la grille de la super case 1
		this.setValues(7,1,0,1);
		this.setValues(1,1,1,0);
		this.setValues(9,1,1,1);
		this.setValues(5,1,1,2);
		
		//Insertion dans la grille de la super case 2
		this.setValues(6,2,2,1);
		
		//Insertion dans la grille de la super case 3
		this.setValues(8, 3, 0, 0);
		this.setValues(4, 3, 1, 0);
		this.setValues(7, 3, 2, 0);
		
		//Insertion dans la grille de la super case 4
		this.setValues(6, 4, 0, 1);
		this.setValues(8, 4, 1, 0);
		this.setValues(3, 4, 1, 2);
		this.setValues(2, 4, 2, 1);
		
		//Insertion dans la grille de la super case 5*
		this.setValues(3, 5, 0, 2);
		this.setValues(1, 5, 1, 2);
		this.setValues(6, 5, 2, 2);
		
		//Insertion dans la grille de la super case 6
		this.setValues(6, 6, 0, 1);
		
		//Insertion dans la super case 7
		this.setValues(4, 7, 1, 0);
		this.setValues(1, 7, 1, 1);
		this.setValues(9, 7, 1, 2);
		this.setValues(8, 7, 2, 1);
		
		//Insertion dans la super case 8
		this.setValues(2, 8, 0, 0);
		this.setValues(8, 8, 0, 1);
		this.setValues(5, 8, 1, 2);
		this.setValues(7, 8, 2, 1);
		this.setValues(9, 8, 2, 2);
		
	}*/
	
	/*Methode pour afficher tout la grille de sudoku*/
	public void affichage()
	{
		/*Cette boucle permet de se place sur les case 0,3 et 6
		 * Ce soint les case les plus a gauche du sudoku */
		
		for (int i = 0; i < 8; i=i+3) 
		{
				for (int j = 0; j <=2; j++) 
				{
					this.S1[i].afficherLigneDeLaCase(j);	
				} 
				System.out.print("\n");
		}	
	}
	
	public void remplirCaseIndice(int valeur, int tab, int numCase)
	{
		int[] a= new int[2];
		a=getCaseByIndice(numCase);
		this.setValues(valeur,tab,a[0],a[1]);
	}
	
	
	//Recupere l'indice d'un JBUTON dans un tableau et donne sa position en matrice
	public int[] getCaseByIndice(int a)
	{
		int[] indice= new int[2];
		switch (a)
		{
		case 0 : 
			indice[0]=0; 
			indice[1]=0;
			break; 
		case 1 : 
			indice[0]=0; 
			indice[1]=1;
			break; 
		case 2 : 
			indice[0]=0; 
			indice[1]=2;
			break; 
		case 3 : 
			indice[0]=1; 
			indice[1]=0;
			break; 
		case 4 : 
			indice[0]=1; 
			indice[1]=1;
			break; 
		case 5 : 
			indice[0]=1; 
			indice[1]=2;
			break; 
		case 6 : 
			indice[0]=2; 
			indice[1]=0;
			break; 
		case 7 : 
			indice[0]=2; 
			indice[1]=1;
			break; 
		case 8 : 
			indice[0]=2; 
			indice[1]=2;
			break; 
		}
		
		return indice; 		
	}
	
}
