
import processing.core.PApplet;
import processing.core.PImage;

public class DragDropDemo extends PApplet {
    DraggingPic dragging;

    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        background(255);
        noStroke();
        dragging = new DraggingPic(50, 50, "image.png");
    }

    @Override
    public void draw() {
        background(255);
        dragging.draw();
        dragging.mouseDragged();
    }

    @Override
    public void mousePressed() {
        dragging.draggingpicMousePressed();
    }

    @Override
    public void mouseReleased() {
        dragging.draggingpicMouseReleased();
    }

    class DraggingPic {

        int x;  // position horizontale en pixel
        int y;  // position verticale en pixel
        PImage sample;

        // controls whether we are dragging (holding the mouse)
        boolean hold;

        // constructor
        DraggingPic(int posx, int posy, String imageNameAsString) {
            x=posx;
            y=posy;
            sample = loadImage(imageNameAsString);
            sample.resize(55, 0);
        }// constructor

        void draw() {
            image(sample, x, y);
        }

        void draggingpicMousePressed() {
            if (mouseX > x &&
                    mouseY > y &&
                    mouseX < x + sample.width &&
                    mouseY < y + sample.height) {
                hold = true;
            }
        }

        void draggingpicMouseReleased() {
            hold = false;
        }

        void mouseDragged()
        {
            if (hold) {
                x = mouseX;
                y = mouseY;
            }
        }//method
        //
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] {"drag & drop"}, new DragDropDemo());
    }
}