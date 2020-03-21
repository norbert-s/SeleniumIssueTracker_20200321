package testdatamanipulation;

import java.io.*;

public class SubWord {
    public String getString(int a) throws IOException {
        FileInputStream is = new FileInputStream("D:\\Users\\nsusz\\source\\repos\\Idea\\Tests\\IssueTracker\\src\\main\\java\\properties\\"+a+".txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str;
        String szo="";
        while ((str = br.readLine()) != null)   {
            szo += str;
        }
        return szo;
    }
}
