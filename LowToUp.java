import java.io.*;
import java.util.Scanner;

public class LowToUp {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("请输入文件路径")
        String s =sc.nextLine();
        File file = new File(s);
        InputStreamReader in = null;
        BufferedReader br = null;
        StringBuilder content = null;
        try {
            in = new InputStreamReader(new FileInputStream(file),"UTF-8");
            br = new BufferedReader(in);
            content = new StringBuilder();
            while ((s=br.readLine())!=null){
                content = content.append(s+"\n");
            }
        } catch (IOException e) {
            System.out.println("文件读取失败");
        }finally {
            in.close();
            br.close();
        }

        System.out.println("将小写转换为大写")
        String res = content.toString().toUpperCase();
        System.out.println("请输入输出位置");
        String p = sc.nextLine();
        FileOutputStream outputStream = null;
        try {
            File nfile = new File(p);
            //创建文件
            nfile.createNewFile();
            outputStream = new FileOutputStream(nfile);
            outputStream.write(res.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}