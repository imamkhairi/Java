class StudentApp {
    public static void main(String[] args) {
        Student jotaro = new Student();
        jotaro.setNamae("じょうたろう");
        jotaro.setGakunen(4);
        jotaro.setBunnya("情報");
        jotaro.setJukyo("下宿");
        jotaro.shokai();

        // Student josuke = new Student();
        // josuke.setGakunen(6);
        // josuke.setBunnya("化学");
        // josuke.setNamae("じょうすけ");
        // josuke.setJukyo("学寮");
        // josuke.shokai();
        //Student kikaitaro = new Student(3, "機械", "きかいたろう", "学寮");
        
        Item item = new Item();
        item.setName("pencil");
        item.setPrice(250);
        //System.out.println(item.getName() +" " + item.getPrice());

        jotaro.setItem(item);
        System.out.println(jotaro.getItem().getName() + " " + jotaro.getItem().getPrice()); 
        jotaro.shokai();
    }
}