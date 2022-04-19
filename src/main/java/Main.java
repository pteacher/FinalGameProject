/* Main
 *  Version information
 *  4/19/2022
 *  Copyright User
 */

import Game.Creature;
import processing.core.PApplet;

public class Main extends PApplet {
    final int WIDTH = 800;
    final int HEIGHT = 600;
    private Creature creature;

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        creature = new Creature(0, 0, 42, 100);
        creature.teleport(200, 100);
    }

    @Override
    public void draw() {
        background(200);
        creature.moveTo(1000, 300);
        int x = creature.getX();
        int y = creature.getY();
        int size = creature.getSize();
        ellipse(x, y, size, size);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
