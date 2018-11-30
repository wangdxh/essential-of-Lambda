
package com.wangdxh;
import javafx.util.Pair;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.io.*;
import java.util.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static String dosingleargs(String input)
    {
        CharStream stream = new ANTLRInputStream(input);
        TokenSource lexer = new lambdaLexer(stream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        lambdaParser parser = new lambdaParser(tokenStream);

        singlearg visitor = new singlearg();
        return visitor.visit(parser.program());
    }

    public static String doonereduce(String input)
    {
        CharStream stream = new ANTLRInputStream(input);
        TokenSource lexer = new lambdaLexer(stream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        lambdaParser parser = new lambdaParser(tokenStream);

        onereduce visitor = new onereduce(App.getctxtofvlist(input));
        return visitor.visit(parser.program());
    }
    public static String doonereducenewprocess(String input)
    {
        String jarPath = System.getProperty("java.class.path");
        //System.out.println(jarPath);
        ProcessBuilder b = new ProcessBuilder("java", "-jar", jarPath, "doonereduce", "\"" + input + "\"");
        try
        {
            String encoding = "UTF-8";
            Process p = b.start();
            int ret = p.waitFor();
            InputStream stream = p.getErrorStream();
            int nlen = stream.available();
            byte[] filecontent = new byte[nlen];
            stream.read(filecontent);
            return new String(filecontent, encoding);

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return onereduce.OVER;
    }

    public static void doreduce(String input)
    {
        List<Pair<String, List<String>>> retmap = new ArrayList<>();
        List<Pair<String, String>> definelist = new ArrayList<>();

        for (String item :input.split("\n")){
            String strreduce = item;

            if(item.indexOf("=") != -1){
                // subitem
                String[] def = item.split("=");
                String left = def[0].trim(), right = def[1].trim();
                definelist.add(new Pair<>(left, App.strsubstitufromdefinelist(right, definelist)));
                continue;
            }
            else{
                strreduce = App.strsubstitufromdefinelist(item, definelist);
            }
            if (strreduce.trim().length() == 0){
                continue;
            }
            System.out.println(strreduce);
            strreduce = strreduce.trim();
            strreduce = dosingleargs(strreduce);

            List<String> retlist = new ArrayList<>();
            for (int i = 0; i < 300; i++){
                String strafterpaire = singlepair.convertString(strreduce);
                retlist.add(strafterpaire);

                if (strafterpaire.length() <=1){
                    break;
                }

                System.out.println("do one reduce:" + strafterpaire);
                //strreduce = doonereduce(strafterpaire);
                strreduce = doonereducenewprocess(strafterpaire);

                if (strreduce.indexOf(onereduce.OVER) != -1){
                    break;
                }
            }
            retmap.add(new Pair<>(item, retlist));
        }
        for(Pair<String, List<String>> pairret : retmap){
            System.out.println("expresson reduce:"+ pairret.getKey());
            for(String i : pairret.getValue()){
                System.out.println(i);
            }
        }
    }

    public static Map<String, String> getctxtofvlist(String input)
    {
        CharStream stream = new ANTLRInputStream(input);
        TokenSource lexer = new lambdaLexer(stream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        lambdaParser parser = new lambdaParser(tokenStream);

        ctxtofvlist visitor = new ctxtofvlist();
         visitor.visit(parser.program());
        return visitor.ctxtofreedict;
    }

    public static void main( String[] args )
    {
        if (args.length >= 2 ){
            if (args[0].equals("doonereduce")){
                // err output do not change
                System.err.print(App.doonereduce(getstrfromarg(args[1])));
                return;
            }
            else if (args[0].equals("subst")){
                App.dosubst(getstrfromarg(args[1]));
                return;
            }
            else if (args[0].equals("fullformat")){
                App.docommand(fullformat.class, getstrfromarg(args[1]));
                return;
            }
            else if (args[0].equals("freevariables")){
                App.docommand(freevariables.class, getstrfromarg(args[1]));
                return;
            }

        }
        if (args.length == 1){
            // 如果是文件读取数据进行reduce，如果不是直接reduce
            App.doreduce(getstrfromarg(args[0]));
        }
    }


    public  static String getstrfromarg(String arg){
        File file = new File(arg);
        if (file.exists()){
            String encoding = "UTF-8";
            Long filelength = file.length();
            byte[] filecontent = new byte[filelength.intValue()];
            FileInputStream in = null;
            try
            {
                in = new FileInputStream(file);
                try {
                    in.read(filecontent);
                    return new String(filecontent, encoding);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "sble";
                } finally {
                    in.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return arg;
            }

        }

        return arg;
    }

    private static String strsubstitufromdefinelist(String strleft, List<Pair<String, String>> definelist)
    {
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < strleft.length(); i++)
        {
            String strchar = String.valueOf(strleft.charAt(i));
            boolean find = false;
            for(int definx = definelist.size()-1; definx >= 0; definx--){
                if (strchar.indexOf(definelist.get(definx).getKey()) != -1){
                    build.append(definelist.get(definx).getValue());
                    find = true;
                    break;
                }
            }
            if (find == false){
                build.append(strchar);
            }
        }
        return build.toString();
    }

    public static void docommand(Class<?> T, String input)
    {
        Class a = fullformat.class;
        CharStream stream = new ANTLRInputStream(input);
        TokenSource lexer = new lambdaLexer(stream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        lambdaParser parser = new lambdaParser(tokenStream);

        //fullformat visitor = new fullformat();

        lambdaBaseVisitor visitor = null;
        try
        {
            visitor = (lambdaBaseVisitor)T.newInstance();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        visitor.visit(parser.program());
        return;
    }
    public static void dosubst(String input)
    {
        List<Pair<String, List<String>>> retmap = new ArrayList<>();
        List<Pair<String, String>> definelist = new ArrayList<>();

        for (String item :input.split("\n"))
        {
            item = item.trim();
            if (item.indexOf("[") != -1 && item.indexOf("]") != -1 && item.indexOf("/") != -1)
            {
                String[] i = item.split("\\[|\\]|/");

                StringBuilder build = new StringBuilder();
                build.append("(^");
                build.append(i[2]);
                build.append(".");
                build.append(i[3]);
                build.append(")");
                build.append(i[1]);
                String strreduce = build.toString();
                System.out.println(item);
                System.out.println("to:" + App.doonereduce(strreduce) + "\n");

            }
        }
    }

}