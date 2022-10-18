import java.awt.event.*;
import java.awt.Point;

public class DragListener extends MouseMotionAdapter{
    GamePanel gp;

    public DragListener(GamePanel gp) {
        this.gp = gp;
    }

    public void mouseDragged(MouseEvent e) {
        for(int i = 0; i < gp.maxPetsNumber -1; i ++){
            if(gp.selectedPet == i){
                Point currentPt = e.getPoint();
    
                gp.entity[i].getPoint().translate(
                    (int)(currentPt.getX() - gp.prevPt.getX()), 
                    (int)(currentPt.getY() - gp.prevPt.getY())
                );
    
                gp.prevPt = currentPt;
            }
        }
        for(int i = 0; i < gp.maxSelection; i++) {
            if(gp.selectedSelection == i) {
                Point currentPt = e.getPoint();
    
                gp.petSelection[i].getPoint().translate(
                    (int)(currentPt.getX() - gp.prevPt.getX()), 
                    (int)(currentPt.getY() - gp.prevPt.getY())
                );
    
                gp.prevPt = currentPt;
            }
            for(int j = 0; j < gp.maxPetsNumber; j++){ // mungkin collision detectionnya masih bisa dipindah ke dalam class lain
                if(gp.petSelection[i].getCollision(gp.setTeam[j]) == true) {
                    System.out.println("collide " + j);
                } 
            }
        }
        
    }
}
