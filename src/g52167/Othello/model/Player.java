package g52167.Othello.model;

import java.util.Objects;

/**
 * This class implements Players in the Othello game. A player will be white or
 * white and has a list of pieces.
 *
 * @author Laurent
 */
public class Player {

    private PlayerColor color;
    private String name;
    private String name2;
    /**
     * Constructor for the class Player.java
     *
     * @param color the color of the player
     * @param name Name of the player
     * @param name2 other Name
     */
    public Player(PlayerColor color, String name,String name2) {
        if (color == null) {
            throw new NullPointerException("you have to choose a color");
        }
        this.color = color;
        this.name= name;
        this.name2= name2;
        
    }

    public void setColor(PlayerColor color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    /**
     * Getter of Color
     *
     * @return the color of the Player
     */
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
    

}
