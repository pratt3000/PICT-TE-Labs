package Assignment_A02.src;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class pass_2 {
    public static HashMap<Integer,String> SymbolTable;
    public static HashMap<Integer,String> LiteralTable;
    public static ArrayList<String[]> MachineCode;

    public static void initialize() throws IOException {
        SymbolTable=new HashMap<>();
        LiteralTable=new HashMap<>();
        MachineCode=new ArrayList<>();

        FileReader file=new FileReader("Assignment_A02/src/symbolTable.txt");
        BufferedReader reader=new BufferedReader(file);
        String line;
        int index=1;
        while((line=reader.readLine())!=null){
            String[] splitLine=line.split("\\s+");

            SymbolTable.put(index,splitLine[2]);
            index++;
        }

        index=1;
        file=new FileReader("Assignment_A02/src/literalTable.txt");
        reader=new BufferedReader(file);
        while((line=reader.readLine())!=null){
            String[] splitLine=line.split("\\s+");

            LiteralTable.put(index,splitLine[2]);
            index++;
        }
    }
    public static void execute() throws IOException {
        FileReader file=new FileReader("Assignment_A02/src/intermediateCode.txt");
        BufferedReader bufferedReader=new BufferedReader(file);
        String line;
        while((line=bufferedReader.readLine())!=null){
            String[] splitLine=line.split("\\s+");

            if(splitLine[2].contains("IS")){
                String [] entry=new String[3];
                entry[0]=splitLine[2].substring(4,5);
                entry[1]=splitLine[3].substring(1,3);

                if(splitLine[4].contains("L")){
                    int literalIndex =Integer.parseInt(splitLine[4].substring(3,splitLine[4].length()-1));
                    entry[2]=LiteralTable.get(literalIndex);
                }
                else if(splitLine[4].contains("S")){
                    int symbolIndex=Integer.parseInt(splitLine[4].substring(3,splitLine[4].length()-1));
                    entry[2]=SymbolTable.get(symbolIndex);
                }
                MachineCode.add(entry);
            }
            else if(splitLine[2].contains("DL,1")){
                String[] entry = new String[3];
                entry[0]="00";
                entry[1]="0";
                entry[2]="00"+splitLine[3].substring(3,splitLine[3].length()-1);
                MachineCode.add(entry);
            }
        }
    }

    public static void print(){
        System.out.printf("%15s %15s %15s\n","IS op-code","Register Code","Symbol Address");
        Iterator itr=MachineCode.iterator();
        while(itr.hasNext())
        {
            String[] entry= (String[]) itr.next();
            System.out.printf("%15s %15s %15s\n",entry[0],entry[1],entry[2]);
        }
    }
    public static void main(String[] args) throws IOException {
        pass_2.initialize();
        pass_2.execute();
        pass_2.print();
    }
}
