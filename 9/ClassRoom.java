public class ClassRoom {
    private int sizeMax;
    private Student[] studentArray;
    private int sizeActual;

    public ClassRoom() {
        this.sizeMax = 5;
        this.studentArray = new Student[this.sizeMax];
        this.sizeActual = 0;
    }

    public void add(Student newStudent) {
        if(sizeActual < sizeMax) {
            this.studentArray[sizeActual] = newStudent;
            sizeActual++;
        } else {
            System.out.println("Student number limit is exceeded.");
            System.out.println(newStudent.getNamae() + " is not inserted. \n");
        }
    }

    public int size() {
        return this.sizeActual;
    }

    public Student get(int index) {
        return this.studentArray[index];
    }

    public void shokai() {
        for(int i = 0; i < this.size(); i++) {
            this.studentArray[i].shokai();
        }
    }
}