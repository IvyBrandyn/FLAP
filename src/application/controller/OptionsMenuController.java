package application.controller;

import java.util.ArrayList;

import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

/**
 * OptionsMenuController.java
 * @author Zachary Ellis (ebl533)
 * @author Jackson Dumas (llt190)
 * @author Ivy Vasquez Sandoval (egi444)
 */
public class OptionsMenuController {
	/**
	 * OptionsMenuController member variables
	 */
	@FXML private Slider slider;
	@FXML private ChoiceBox<String> cp;
	
//	private String co;
	
	/**
	 * Sets the slider to the correct position per the volume level
	 */
	public void initialize() {
		cp.setItems(FXCollections.observableArrayList("White", "Black"));
		slider.setMin(0.0);
		slider.setMax(1.0);
		slider.setValue(Main.mp.getVolume());
	}
	
	/**
	 * Sets the volume for the music dynamically when the slider is used.
	 */
	public void change() {
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> volume,
					Number oldVolume, Number newVolume) {
				Main.mp.setVolume(Double.parseDouble(String.format("%.2f", newVolume)));
			}
		});
	}
	
	public void changing() {
//		cp.getSelectionModel().selectedIndexProperty()
//		.addListener( (ObservableValue<? extends String> observableValue, String oldVal, String newVal) 
//				-> 
//		);
	}
	
//	public void selectColor() {
//		if(cp.getValue().equals("White")) {
//			Main.PSEUDO_CLASS = PseudoClass.getPseudoClass("green");
//		}else if(cp.getValue().equals("Black")) {
//			Main.PSEUDO_CLASS = PseudoClass.getPseudoClass("white");
//		}
//	}
	
	/**
	 * @param event Back button pressed
	 */
	public void back(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(Main.optionParentMenuFXML));
			root.setId("background");
			Scene scene = new Scene(root, 800, 800);
			scene.getStylesheets().add(getClass().getResource(Main.optionParentMenuCSS).toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
