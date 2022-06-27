class StudentApp {
    public static void main(String[] args) 
    {
        Student jotaro = new Student(4, "情報", "じょうたろう", "下宿");
        Student josuke = new Student(3, "情報", "じょうすけ", "学寮");
        Student kikaitaro = new Student(3, "機械", "きかいたろう", "学寮");
        
        jotaro.shokai();
        
        josuke.shokai();

        //josuke.hantei(jotaro);
        //Student.hantei(josuke, jotaro);
        
        // kikaitaro.shokai();
        
        // kikaitaro.hantei(josuke);
        // Student.hantei(kikaitaro, josuke);
        // Student.shokai(jotaro);
        // Student.shokai(josuke);
        jotaro.shinkyu();
        jotaro.shokai();

        Student.shinkyu(josuke);
        Student.shokai(josuke);

        System.exit(0);
    }
}