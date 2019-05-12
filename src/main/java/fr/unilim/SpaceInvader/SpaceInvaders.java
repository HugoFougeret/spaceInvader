package fr.unilim.SpaceInvader;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

	    private static final char MARQUE_FIN_LIGNE = '\n';
		private static final char MARQUE_VIDE = '.';
		private static final char MARQUE_VAISSEAU = 'V';
		private int longueur;
	    private int hauteur;
	    private Vaisseau vaisseau;
	  

	    public SpaceInvaders(int longueur, int hauteur) {
		   this.longueur = longueur;
		   this.hauteur = hauteur;
	   }
	    public void positionnerUnNouveauVaisseau(int x, int y) {
			
			if (  !estDanEspaceJeu(x, y) )
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");
		
			vaisseau = new Vaisseau(x, y); 
		}
		private boolean estDanEspaceJeu(int x, int y) {
			return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
		}
	    
	    
	    
	    @Override
		public String toString() {
			return recupererEspaceJeuDansChaineASCII();
		}
	    
		String recupererEspaceJeuDansChaineASCII() {
			StringBuilder espaceDeJeu = new StringBuilder();
			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < longueur; x++) {
					espaceDeJeu.append(recupererMarqueDeLaPosition(y, x));
				}
				espaceDeJeu.append(MARQUE_FIN_LIGNE);
			}
			return espaceDeJeu.toString();
		}
		private char recupererMarqueDeLaPosition(int y, int x) {
			char marque;
			if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
			      marque=MARQUE_VAISSEAU;
			else
			      marque=MARQUE_VIDE;
			return marque;
		}
		private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
			return aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
		}
		private boolean aUnVaisseau() {
			return vaisseau!=null;
		}
		 public void deplacerVaisseauVersLaDroite() {
			   {
			        if (vaisseau.abscisse()< (longueur-1)) vaisseau.seDeplacerVersLaDroite();
				}
		    }
		public void deplacerVaisseauVersLaGauche() {
			// TODO Auto-generated method stub
			
		}
   }

