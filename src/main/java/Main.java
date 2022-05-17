/* Main
 *  Version information
 *  4/19/2022
 *  Copyright User
 */

import Game.Cell;
import Game.Creature;
import Game.STATE;
import processing.core.PApplet;
import processing.event.KeyEvent;
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
    final int ROWS = 4;
    final int COLS = 4;
    private Cell cells[][] = new Cell[ROWS][COLS];

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);

    }

    @Override
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(32);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = new Cell(SIZE, WIDTH / 2 + SIZE * j - (int) (SIZE * COLS / 2.0), HEIGHT / 2 + SIZE * i - (int) (SIZE * ROWS / 2.0));
            }

        }
        cells[(int)(Math.random() * ROWS)][(int)(Math.random() * COLS)].setValue(2);
        cells[(int)(Math.random() * ROWS)][(int)(Math.random() * COLS)].setValue(2);
    }

    @Override
    public void draw() {
        background(255);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (cells[i][j].getState() == STATE.O) {
                    fill(200, 0, 0);
                } else if (cells[i][j].getState() == STATE.X) {
                    fill(0, 200, 0);
                } else {
                    fill(100, 100, 100);
                }
                rect(cells[i][j].getX(), cells[i][j].getY(), SIZE, SIZE);
                fill(255);
                if (cells[i][j].getValue() != 0) {
                    text(cells[i][j].getValue() + "", cells[i][j].getX() + SIZE / 2, cells[i][j].getY() + SIZE / 3);
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == 37) { // LEFT KEY
            mergeLeft();
        }
        if (event.getKeyCode() == 38) { // UP KEY
            mergeUp();
        }
    }

    private void mergeUp() {
        for (int j = 0; j < ROWS; j++) {
            int p = 0;
            for (int i = 0; i < COLS; i++) {
                if (cells[i][j].getValue() != 0 && p != i) {
                    cells[p][j].setValue(cells[i][j].getValue());
                    cells[i][j].setValue(0);
                    p++;
                }
            }
        }

//        for (int j = 0; j < ROWS - 1; j++) {
//            for (int i = 0; i < COLS; i++) {
//                if (cells[i][j].getValue() == cells[i][j + 1].getValue()) {
//                    cells[i][j].setValue(cells[i][j].getValue() * 2);
//                    cells[i][j + 1].setValue(0);
//                }
//            }
//        }
    }

    private void mergeLeft() {
        for (int i = 0; i < ROWS; i++) {
            int p = 0;
            for (int j = 0; j < COLS; j++) {
                if (cells[i][j].getValue() != 0 && p != j) {
                    cells[i][p].setValue(cells[i][j].getValue());
                    cells[i][j].setValue(0);
                    p++;
                }
            }
        }

//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLS - 1; j++) {
//                if (cells[i][j].getValue() == cells[i][j + 1].getValue()) {
//                    cells[i][j].setValue(cells[i][j].getValue() * 2);
//                    cells[i][j + 1].setValue(0);
//                }
//            }
//        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (event.getX() > cells[i][j].getX() &&
                        event.getX() < cells[i][j].getX() + SIZE &&
                        event.getY() > cells[i][j].getY() &&
                        event.getY() < cells[i][j].getY() + SIZE) {
                    cells[i][j].changeState();
                }
            }

        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
