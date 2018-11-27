
package com.wangdxh;
import org.antlr.v4.runtime.*;



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
    public static void main( String[] args )
    {
        String pairtest = singlepair.convertString("(a(((a)))b((ab)))((z))");
        System.out.println(pairtest);


        System.out.println(App.dosingleargs("^xy.a(a(a(a(a(a(a(a(a(a(a(a(a(a(ab))))))))))))))AABb\n"));
        System.out.println("hello");

    }


}
