public class MyMatrix {
    public static float[][] projection = {
        {1, 0 , 0},
        {0, 1, 0}
    };

    public static float[][] perspectiveProjection(float z) {
        float distance = (float)1.5;
        float a = 1 / (distance - z/200);
        
        float[][] projection = {
            {a, 0 , 0},
            {0, a, 0}
        };

        return projection;
    }

    public static void printMatrix(float[][] a){
        int rows = a.length;
        int cols = a[0].length;

        System.out.println(rows + " x " + cols);
        System.out.println("--------------------");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("\n");

    }

    public static float[][] matrixMul(float[][] a, float[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        float[][] result = new float[rowsA][colsB];

        if(colsA != rowsB) {
            System.out.println("Column A and Row B not same");
            return null;
        } else {
            for(int i = 0; i < rowsA; i++) { // a rows
                for(int j = 0; j < colsB; j++ ) { // b cols
                    float sum = 0;
                    for(int k = 0; k < colsA; k++) {
                        sum += a[i][k] * b[k][j];
                        result[i][j] = sum;
                    }
                }
            }
        }
        
        return result;
    }

    public static float[][] tPoint(My3DPoint pt) { //transpose only for 1 x n matrix
        int rows = pt.getLength();
        float[][] result = new float[rows][1];
        result[0][0] = pt.getX();
        result[1][0] = pt.getY();
        result[2][0] = pt.getZ();
        return result;
    }

    public static float[][] rotateZ(double angle, float[][] a) {
        float[][] transformMatrix = {
            {(float)Math.cos(angle), -(float)Math.sin(angle), 0},
            {(float)Math.sin(angle), (float)Math.cos(angle), 0},
            {0,0,1}
        };
        return MyMatrix.matrixMul(transformMatrix, a);
    }

    public static float[][] rotateX(double angle, float[][] a) {
        float[][] transformMatrix = {
            {1,0,0},
            {0, (float)Math.cos(angle) , -(float)Math.sin(angle)},
            {0, (float)Math.sin(angle), (float)Math.cos(angle)}
        };
        return MyMatrix.matrixMul(transformMatrix, a);
    }

    public static float[][] rotateY(double angle, float[][] a) {
        float[][] transformMatrix = {
            {(float)Math.cos(angle), 0 , (float)Math.sin(angle)},
            {0,1,0},
            {-(float)Math.sin(angle), 0, (float)Math.cos(angle)}
        };
        return MyMatrix.matrixMul(transformMatrix, a);
    }

    public static float[][] rotationTransform(double angleX, double angleY, double angleZ, float[][] a) {
        float[][] result = null;
        result = MyMatrix.rotateX(angleX, a);
        result = MyMatrix.rotateY(angleY, result);
        result = MyMatrix.rotateZ(angleZ, result);
        return result;
    }
}
