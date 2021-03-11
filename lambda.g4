grammar lambda;
program
    : stat+
    ;
stat
    : define NEWLINE?          # definestat
    | substitution NEWLINE?    # substat
    | expression NEWLINE?      # exprstat
    | NEWLINE                 # blankstat
    ;

define
    : VARIABLE '=' expression
    ;

substitution
    :  ('[' expression '/' VARIABLE ']')+ expression 
    ;

expression
    : '^' VARIABLE+ '.' scope  # funnoparenth
    | '(' '^' VARIABLE+ '.' scope ')' #funwithpareth
    | VARIABLE        # varexpr
    | '(' expression expression ')' # applywithpareth
    | expression  expression  # applynopareth
    ;

scope
    : expression
    ;


VARIABLE
    : [a-z] [0-9]* 
    | [A-Z]
    ;
NEWLINE
    : '\r'? '\n';
WS
   : [ \t] -> skip
   ;