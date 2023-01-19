import java.io.*;

public class CatTest {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String buf;
            String all = "";
            while ((buf = br.readLine()) != null) {
                // System.out.println(buf);
                all += buf;
            }
            System.out.println(all);
            br.close();
            fr.close();
        }
        catch(IOException e) {
            System.out.println("ファイル読み込みエラー");
            System.exit(1);
        }
    }
}