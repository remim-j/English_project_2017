
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

public class InterfaceMemory{

	@FXML
    public String nomJ1;
	
	@FXML
    public String nomJ2;


    @FXML
    public int scoreJ1;
    
    @FXML
    public int scoreJ2;

    @FXML
    public int tour;

    @FXML
    public ListView<String> Playlist;

    @FXML
    private WebView webviewVideo;

    @FXML
    private Label labelTitre;


	ObservableList<String> items = FXCollections.observableArrayList ();
	ObservableList<String> itemsFav = FXCollections.observableArrayList ();
	ObservableList<String> itemsPlay = FXCollections.observableArrayList ();

	public void bouton(ActionEvent e){
		texteRecherche = TexteRecherche.getText();
		int n = items.size();
		for ( int i = 0; i < n; i++){
			items.remove(0);
		}
	    Resultats.setItems(items);
	}


    public void initialize(URL arg0, ResourceBundle arg1) {
	    Resultats.setItems(items);
	    Playlist.setItems(itemsPlay);
	    Favoris.setItems(itemsFav);
    }

    public void setMain() {
	}

    public void play(ActionEvent e){
    	int select;
    	select = Resultats.getSelectionModel().getSelectedIndex();
    	if ( select >=0 ){
        	labelTitre.setText(items.get(select));
    	}
    }

//////////////////////////////////////////////////////////////// Gestion des favoris ////////////////////////////////////////////////////////////

    public void playFav(ActionEvent e){
    	int select;
    	select = Favoris.getSelectionModel().getSelectedIndex();
    	if ( select >=0 ){
        	labelTitre.setText(itemsFav.get(select));
    	}
    }


    public void ajouterFav(ActionEvent m){
    	Favoris.setItems(itemsFav);
    }

    public void removeFav(ActionEvent m){
    	int select;
    	select = Favoris.getSelectionModel().getSelectedIndex();
    	if ( select >= 0 ){
    		itemsFav.remove(select);
    	}
    	Favoris.setItems(itemsFav);
    }

////////////////////////////////////////////////////// Gestion de la playlist ////////////////////////////////////////////////////////////

    public void playPlaylist(ActionEvent e){
    	int select;
    	select = Playlist.getSelectionModel().getSelectedIndex();
    	if (select >=0){
        	labelTitre.setText(itemsPlay.get(select));
    	}else{
        	labelTitre.setText(itemsPlay.get(0));
    	}
    }

    public void ajoutPlay(ActionEvent m){
    	Playlist.setItems(itemsPlay);
    }

    public void removePlay(ActionEvent m){
    	int select;
    	select = Playlist.getSelectionModel().getSelectedIndex();
    	if (select >= 0){
    		itemsPlay.remove(select);
    	}
    	Playlist.setItems(itemsPlay);
    }

    public void ajoutPlayFromFav(ActionEvent m){
    	int select;
    	select = Favoris.getSelectionModel().getSelectedIndex();
    	Playlist.setItems(itemsPlay);
    }

    public void suivPlay(ActionEvent m){
    	int select;
    	select = Playlist.getSelectionModel().getSelectedIndex();
    	if (select >=0 && select < itemsPlay.size()-1 && itemsPlay.size()-1 >= 0){ //If the selected vid is not the last vid
        	// Remove the selected video
        	itemsPlay.remove(0);
    		// Play the next video
        	labelTitre.setText(itemsPlay.get(0));
        	Playlist.setItems(itemsPlay);
    	} else if (select >= 0 && itemsPlay.size()-1 == 0 && select <= itemsPlay.size()-1){
        	itemsPlay.remove(0);
    		webviewVideo.getEngine().load(null);
    		labelTitre.setText("");
    	}
    	Playlist.setItems(itemsPlay);
    }

/////////////////////////////////////////////// Precedent et suivant /////////////////////////////////////////////////////////////////////

    public void suivant(ActionEvent m){
		int n = items.size();
		for ( int i = 0; i < n; i++){
			items.remove(0);
		}
	    Resultats.setItems(items);
    }

    public void precedent(ActionEvent m){
    	//System.out.println(recherche.getResultat().getVideo(0).getTitle());
    	int n = items.size();
    	for ( int i = 0; i < n; i++){
    		items.remove(0);
    	}
        Resultats.setItems(items);
    }

    ////////////////////////////////////////////////////////// Téléchargements //////////////////////////////////////////////////////////////////

    public void telechargerFav(ActionEvent m){
    	int select;
    	select = Favoris.getSelectionModel().getSelectedIndex();
    	if (select >=0){
        	labelTitre.setText(itemsFav.get(select));
    	}
    }

    public void telechargerRes(ActionEvent m){
    	int select;
    	select = Resultats.getSelectionModel().getSelectedIndex();
    	Playlist.setItems(itemsPlay);
    }

    public void telechargerPlay(ActionEvent m){
    	int select;
    	select = Playlist.getSelectionModel().getSelectedIndex();
    	Playlist.setItems(itemsPlay);
    }
}