package fr.unilim.SpaceInvader;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

	    private static final char MARQUE_FIN_LIGNE = '\n';
		private static final char MARQUE_VIDE = '.';
		private static final char MARQUE_VAISSEAU = 'V';
		int longueur;
	    int hauteur;
		Vaisseau vaisseau;

	    public SpaceInvaders(int longueur, int hauteur) {
		   this.longueur = longueur;
		   this.hauteur = hauteur;
	   }
	    @Override
		public String toString() {
			return recupererEspaceJeuDansChaineASCII();
		}
		public String recupererEspaceJeuDansChaineASCII() {
			StringBuilder espaceDeJeu = new StringBuilder();
			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < longueur; x++) {
					if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
						espaceDeJeu.append(MARQUE_VAISSEAU);
					else
						espaceDeJeu.append(MARQUE_VIDE);
				}
				espaceDeJeu.append(MARQUE_FIN_LIGNE);
			}
			return espaceDeJeu.toString();
		}
		private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
			return vaisseau!=null && vaisseau.occupeLaPosition(x, y);
		}

		private boolean estDansEspaceJeu(int x, int y) {
			return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
		}
		public void deplacerVaisseauVersLaDroite() {
	        if (vaisseau.abscisee()< (longueur-1)) vaisseau.seDeplacerVersLaDroite();
		}
		
		public void deplacerVaisseauVersLaGauche() {
	        if (vaisseau.abscisee()> (0)) vaisseau.seDeplacerVersLaGauche();
		}
		public void positionnerUnNouveauVaisseau(int longueur, int hauteur, int x, int y) {
			if (!estDansEspaceJeu(x, y))
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

			vaisseau = new Vaisseau(longueur, hauteur);
			vaisseau.positionner(x, y);
		}
}