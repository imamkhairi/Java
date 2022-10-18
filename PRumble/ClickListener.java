import java.awt.event.*;

public class ClickListener extends MouseAdapter{
    GamePanel gp;
    ClickListener(GamePanel gp) {
        this.gp = gp;
    }

    public void mousePressed(MouseEvent e) {
        gp.prevPt = e.getPoint();
        int x = (int)gp.prevPt.getX();
        int y = (int)gp.prevPt.getY();
        for(int i = 0; i < gp.maxPetsNumber-1; i++){ // mungkin collision detectionnya masih bisa dipindah ke dalam class lain
            if(x >= gp.entity[i].getX() && x <= gp.entity[i].getX() + gp.entity[i].getWidth()){
                if(y >= gp.entity[i].getY() && y <= gp.entity[i].getY() + gp.entity[i].getHeight()){
                    gp.selectedPet = i;
                    System.out.println("pet" + gp.selectedPet);
                }
            }
        }
        for(int i = 0; i < gp.maxSelection; i++) {
            if(x >= gp.petSelection[i].getX() && x <= gp.petSelection[i].getX() + gp.petSelection[i].getWidth()){
                if(y >= gp.petSelection[i].getY() && y <= gp.petSelection[i].getY() + gp.petSelection[i].getHeight()){
                    gp.selectedSelection = i;
                    System.out.println("selection" + gp.selectedSelection);
                }
            }
            
        }
    }
    public void mouseReleased(MouseEvent e) {
        gp.selectedPet = -1;
        gp.selectedSelection = -1;
        System.out.println(gp.selectedPet);
    }
}
