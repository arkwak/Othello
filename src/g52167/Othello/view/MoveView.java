package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.model.Move;

/**
 * This Class manage every move done (used principaly for the historic
 *
 * @author Laurent
 */
public class MoveView {

    private int id;
    private String nomJoueur;
    private String action;
    private String position;
    private int prise;

    /**
     * Contrustor of MoveView
     *
     * @param id the id of the round
     * @param move the move done
     */
    public MoveView(int id, Move move) {

        /*--------------------initialise les données de chaque colonne du TableView--------------------*/
        this.id = id;
        this.nomJoueur = move.getNomPlayer();
        this.action = move.getAction();
        if (move.getPosition() == null) {
            position = "-";
        } else {
            position = move.getPosition().toString();
        }
        this.prise = move.getQteDisc();

    }

    /**
     * getter of the id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * getter of nomJoueur
     *
     * @return NomJoueur
     */
    public String getNomJoueur() {
        return nomJoueur;
    }

    /**
     * getter of action
     *
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * getter of position
     *
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * getter of prise
     *
     * @return prise
     */
    public int getPrise() {
        return prise;
    }

}
