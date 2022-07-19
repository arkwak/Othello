package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.model.Game;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * This class is the hystoric of the game
 *
 * @author Laurent
 */
public class InfoTab extends TableView {

    private TableColumn<Integer, MoveView> id;
    private TableColumn<String, MoveView> name;
    private TableColumn<String, MoveView> action;
    private TableColumn<String, MoveView> position;
    private TableColumn<Integer, MoveView> prises;

    /**
     * Contructor of infoTab, set all the tableView
     */
    public InfoTab() {

        /*--------------------Style--------------------*/
        this.setPrefSize(500, 600);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        /*--------------------ajout de chaque colonne et de ce qu'ils vont contenir--------------------*/
        this.id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        this.name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("nomJoueur"));

        this.action = new TableColumn("Action");
        action.setCellValueFactory(new PropertyValueFactory<>("action"));

        this.position = new TableColumn("Position");
        position.setCellValueFactory(new PropertyValueFactory<>("position"));

        this.prises = new TableColumn("Prises");
        prises.setCellValueFactory(new PropertyValueFactory<>("prise"));

        /*--------------------ajout aux enfants--------------------*/
        this.getColumns().setAll(id, name, action, position, prises);

    }

    //prend le dernier element de la liste et le met dans moveView
    /**
     * Set the last move played
     *
     * @param game the game
     */
    public void update(Game game) {
        /*-----------------prend le dernier element de la liste de move et le met dans moveView(pour afficher a l endroit adéquat)-----------------------*/

        int i = game.getMove().size() - 1;

        MoveView moveView = new MoveView(i, game.getMove().get(i));
        this.getItems().add(moveView);

    }

}
