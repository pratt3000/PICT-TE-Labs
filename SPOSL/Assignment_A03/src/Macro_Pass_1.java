package Assignment_A03.src;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Macro_Pass_1 {
    private static ArrayList<String[]>MDT;
    private static ArrayList<String[]>MNT;

    public static void Initialize(){
        MDT=new ArrayList<>();
        MNT=new ArrayList<>();
    }
    public static void Pass2(){
        FileReader File=null;
        PrintWriter out_pass1=null;
        PrintWriter mnt=null;
        PrintWriter mdt=null;
        try {
            File =new FileReader("Assignment_A03/src/input_Macro_pass1.txt");
            out_pass1=new PrintWriter(new FileWriter("Assignment_A03/src/output.txt",false));
            mnt=new PrintWriter(new FileWriter("Assignment_A03/src/mnt.txt",false));
            mdt=new PrintWriter(new FileWriter("Assignment_A03/src/mdt.txt",false));
        } catch (FileNotFoundException e) {
            System.err.println("FILE NOT FOUND");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader=new BufferedReader(File);
        boolean processing_macro_defination=false;
        boolean processing_name_decleration=false;
        ArrayList<String> ArgumentList =null;
        int mdtptr=0;
        int mntptr=0;
        String line;
        try {
            while((line=reader.readLine())!=null){
                String[] split_line=line.split("\\s+");
                if(split_line[0].equalsIgnoreCase("MACRO")){
                    processing_macro_defination=true;
                    processing_name_decleration=true;
                }else if(processing_macro_defination==true){
                    if(split_line[0].equalsIgnoreCase("MEND")){
                        mdt.printf("%d  %s\n",mdtptr,line);
                        processing_macro_defination=false;
                        mdtptr++;
                    }
                    if (processing_name_decleration==true){
                        mnt.printf("%d %s %s\n",mntptr,split_line[0],mdtptr);
                        mntptr++;
                        processing_name_decleration=false;
                        mdt.printf("%d  %s\n",mdtptr,line);
                        mdtptr++;
                        if(split_line.length>1){
                            ArgumentList=new ArrayList<>();
                            String[] args=split_line[1].split(",");
                            for(String x:args){
                                ArgumentList.add(x.split("=")[0]);
                            }
                        }
                    }
                    else if(processing_macro_defination==true&&processing_name_decleration==false){
                        if(split_line.length>1){
                            String args[]=split_line[1].split(",");
                            String newArgs="";
                            for(String x:args){
                                System.out.println(ArgumentList);
                                int index=ArgumentList.indexOf(x.split("=")[0]);
                                if(index==-1){
                                    newArgs=newArgs+x+",";
                                }
                                else
                                    newArgs=newArgs+"#"+(index+1)+",";
                            }
                            mdt.printf("%d  %s %s\n",mdtptr,split_line[0],newArgs.substring(0,newArgs.length()-1));
                        }
                        else{
                            mdt.printf("%d %s",mdtptr,line);
                        }
                        mdtptr++;
                    }

                }
                else
                {
                    out_pass1.println(line);
                }

            }
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        out_pass1.close();
        mdt.close();
        mnt.close();
    }
    public static void main(String args[]){
        Macro_Pass_1.Pass2();
    }
}
