package it.polimi.ingsw.view;

import it.polimi.ingsw.clientmodel.PlayerView;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;

import java.util.List;

/**
 * A GuiClickableObject that draws a pawn
 */
public class GuiClickableObjectPawn extends GuiClickableObject {
    private PlayerView pl;
    private static final String WHITE_HEX = "#ffffff";

    public GuiClickableObjectPawn(PlayerView pl, double size, boolean viewer){
        super(size, size);
        this.pl = pl;
        img = GuiImagesMap.getImage( "playerPawn/" + pl.getCharacter().toString() + ".png" );

        this.getGraphicsContext2D().drawImage( img, 0, 0, size, size);

        if(viewer)
            this.setEffect(makeGlow("#123aff"));
        else
            this.setEffect(makeGlow(WHITE_HEX));
    }

    /**
     * Determine if the card represented by this GuiClickableObject is inside the list
     * @param list of possible matches
     * @return true if in the list
     */
    public boolean inList(List<PlayerView> list){
        for(PlayerView p:list)
            if(p.getCharacter() == this.pl.getCharacter())
                return true;

        return false;
    }

    public PlayerView getPlayer() {
        return pl;
    }

    /**
     * Resets the styles to the basic ones
     */
    @Override
    public void resetEventsStyle(){
        setOnMouseEntered(e -> setEffect(makeGlow("#d1d331")));
        setOnMouseExited(e-> setEffect(makeGlow(WHITE_HEX)) );
        setEffect(makeGlow(WHITE_HEX));
    }

    /**
     * Sets the styles to clickable ones
     */
    @Override
    public void setEventsChoosable(){
        setEffect(makeGlow("#36ff0e"));
        setOnMouseEntered(e -> setEffect(makeGlow("#e2ff24")) );//different green
        setOnMouseExited(e-> setEffect(makeGlow("#36ff0e")) );
    }

    private DropShadow makeGlow(String color) {
        return new DropShadow(BlurType.GAUSSIAN, javafx.scene.paint.Color.web(color), 10, 0.7, 0, 0);
    }
}
