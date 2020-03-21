package testdatamanipulation;

import java.io.*;
import java.util.Random;

public class CreateFile {
    FileWriter file;
    Random number,character;
    char a,c;
    String b="";
    BufferedWriter output;
    public String createData2(int num) throws IOException {
        number = new Random();
        int n = number.nextInt((1000-1)+1);
        character = new Random();
        File exists = new File("D:\\Idea\\tests\\IssueTracker\\src\\main\\java\\properties\\"+num+".txt");
        if(exists.exists()){
//            SubWord a = new SubWord();
//            a.getString(num);
            FileInputStream filereader = new FileInputStream("D:\\Idea\\tests\\IssueTracker\\src\\main\\java\\properties\\"+num+".txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(filereader));
            String sor="";
            System.out.println("itt");

            while((sor=bufferedReader.readLine())!=null){
                b+=sor;
                System.out.println(sor);
            }
            System.out.println(b);

        }
        else{

            file = new FileWriter("D:\\Idea\\tests\\IssueTracker\\src\\main\\java\\properties\\"+num+".txt");

            for(int i=0;i<num;i++){

                if(i%5==0){
                    c=(char)32;
                }
                else{
                    c = (char)(character.nextInt(26) + 'a');
                }

                b+= c;
            }
            System.out.println("b"+b);

            output = new BufferedWriter(file);
            output.write(b);
//        output.flush();
            output.close();
        }


        return b;
    }
    public String createData(int num) throws IOException {
        number = new Random();
        int n = number.nextInt((1000-1)+1);
        character = new Random();
        File exists = new File("D:\\Users\\nsusz\\source\\repos\\Idea\\Tests\\SeleniumIssueTracker_21032020\\src\\main\\java\\properties\\"+num+".txt");
            file = new FileWriter("D:\\Users\\nsusz\\source\\repos\\Idea\\Tests\\SeleniumIssueTracker_21032020\\src\\main\\java\\properties\\"+num+".txt");
            for(int i=0;i<num;i++){

                if(i%5==0){
                    c=(char)32;
                }
                else{
                    c = (char)(character.nextInt(26) + 'a');
                }

                b+= c;
            }
            System.out.println("b"+b);
            output = new BufferedWriter(file);
            output.write(b);
//        output.flush();
            output.close();
        return b;
    }

}
