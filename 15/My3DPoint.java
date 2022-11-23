public class My3DPoint {
    private float x;
    private float y;
    private float z;

    public My3DPoint(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
    
    public float getZ() {
        return this.z;
    }

    public int getLength() {
        return 3;
    }

    private void setX(float x) {
        this.x = x;
    }

    private void setY(float y) {
        this.y = y;
    }
    
    private void setZ(float z) {
        this.z = z;
    }

    public My3DPoint changeToPoint(float[][] a) {
        My3DPoint result = new My3DPoint(0, 0, 0);
        result.setX(a[0][0]);
        result.setY(a[1][0]);
        if(a.length > 2) {
            result.setZ(a[2][0]);
        } else {
            result.setZ(0);
        }
        return result;
    }

    public void printPoint() {
        System.out.println(this.getX() + ", " + this.getY() + ", " + this.getZ());
    }

    public void mult(int multiplier) {
        this.setX(this.x * multiplier);
        this.setY(this.y * multiplier);
        this.setZ(this.z * multiplier);
    }
}
