 essential-Lambda-Calculus 是 《Lambda-Calculus and Combinators : An Introduction》的摘要版本，提供了lambda部分的内容摘要
 以及例题解答，并实现一个解释器对lambda的语法进行解释执行。
 
文章地址在 ：https://www.jianshu.com/p/fdc12c303e48


some lambda interpreters using antlr4  
λ replaced by ^  

tools:  
python2.7   
antlr4-python2-runtime (4.7.1)  

python install antlr4 runtime:  
pip install antlr4-python2-runtime  

(no need)use antrl4 generate lexer and parser form lambda.g4:  
java -jar ./antlr-4.7.1-complete.jar -visitor lambda.g4 -Dlanguage=Python2  

重要：antlr4 默认最大嵌套有限制，超过之后解析时会出错   
a(a(a(a(a(a(a(a(a(a(a(a(ab))))))))))))   
   
run example:  

cd addparenths   
python ./addparenths ./test.txt   

addparenths 功能是补齐括号  
source: (^xyz.xz(yz))uvw  
to: ((((^x.(^y.(^z.((xz)(yz)))))u)v)w)  


