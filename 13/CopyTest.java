import java.io.*;

public class CopyTest {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(args[1]);
            BufferedWriter bw = new BufferedWriter(fw);
            String buf;
            while((buf = br.readLine()) != null) {
                // System.out.println(buf);
                bw.write(buf);
                bw.write("\n");
            }
            bw.close();
            fw.close();
            br.close();
            fr.close();
        }
        catch (IOException e) {
            System.out.println("ファイル読み込みエラー");
            System.exit(1);
        }
    }
}