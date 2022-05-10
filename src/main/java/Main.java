/* Main
 *  Version information
 *  4/19/2022
 *  Copyright User
 */

import Game.Cell;
import Game.Creature;
import Game.STATE;
import processing.core.PApplet;
import processing.event.MouseEvent;

// CELL BASED NON-ZERO PLAYER GAME
// TIC-TAC-TOE, CHESS, CHECKERS, 2048 etc.
// Using processing
// Classes
// Github with screenshots of your game
// Penalties for plagiarism - 50 pts removal
// Penalties for violating deadline - 1 pts each 1 hour

public class Main extends PApplet {
    final int WIDTH = 800;
    final int HEIGHT = 600;
    final int SIZE = 50;
    final int ROWS = 5;
    final int COLS = 5;
    private Cell cells[] = new Cell[ROWS * COLS];

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);

    }

    @Override
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(42);
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(SIZE, WIDTH / 2 + SIZE * (i % COLS) - (int) (SIZE * COLS / 2.0), HEIGHT / 2 + SIZE * (i / ROWS) - (int) (SIZE * ROWS / 2.0));
        }
    }

    @Override
    public void draw() {
        background(255);
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].getState() == STATE.O) {
                fill(200, 0, 0);
            } else if (cells[i].getState() == STATE.X) {
                fill(0, 200, 0);
            } else {
                fill(100, 100, 100);
            }
            rect(cells[i].getX(), cells[i].getY(), SIZE, SIZE);
            fill(255);
            text(cells[i].toString(), cells[i].getX() + SIZE / 2, cells[i].getY() + SIZE / 3);

        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        for (int i = 0; i < cells.length; i++) {
            if (event.getX() > cells[i].getX() &&
                    event.getX() < cells[i].getX() + SIZE &&
                    event.getY() > cells[i].getY() &&
                    event.getY() < cells[i].getY() + SIZE) {
                cells[i].changeState();
            }
        }
        for (int i = 0; i < cells.length; i++) {
            System.out.print(cells[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
