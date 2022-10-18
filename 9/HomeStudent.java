public class HomeStudent extends Student {
    private String shudan;

    public HomeStudent(int gakunen, String bunnya, String namae, String shudan) {
        super(gakunen, bunnya, namae);
        this.shudan = shudan;
    }

    public String getShudan() {
        return this.shudan;
    }

    public void shokai() {
        //katanya beda trus pake this2 an doang
        super.shokai();
        System.out.println("私は" + this.shudan + "で学校に通っています。\n");
    }
}