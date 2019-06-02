grammar KafkaSql;

selectStatement : SELECT offsetStatement
    | SELECT partitionsStatement
    | SELECT consumersStatement
    | SELECT consumerOffsetStatement
//    | SELECT querySpecification
    ;

offsetStatement : OFFSETS '(' ID ('.' NUMBER)? ')';

partitionsStatement : PARTITIONS '(' ID ')';

consumersStatement : CONSUMERS '(' ID ')';

consumerOffsetStatement : CONSUMER_OFFSET '(' ID ')';

//querySpecification : (STAR | value (',' value)*) FROM ID whereClause ? ;
////
//value : (byteFunction | jsonFunction | strFunction | ID);
//
//whereClause: WHERE (equationClause | inCluase | betweenCluase);
//
//equationClause : partitionsEquslCluase
//    | timestampEquslCluase
//    | valueEqualClause
//    ;
//
//partitionsEquslCluase: PARTITION EQUAL NUMBER;
//timestampEquslCluase: TIMESTAMP EQUAL NUMBER;
//valueEqualClause: (byteFunction | jsonFunction | strFunction ) EQUAL (CHARS | NUMBER);
//
//byteFunction: BYTE '(' ID ')';
//jsonFunction: JSON '(' ID ')';
//strFunction: STAR '(' ID ')';
//
//inCluase : ID IN '(' (NUMBER | '\'' CHARS '\'')  (',' (NUMBER | '\'' CHARS '\'')* ) ')' ;
//
inCluase : ID IN '(' (NUMBER_LIST | CHARS_LIST) ')' ;

numberList: NUMBER_LIST;
charsList: CHARS_LIST;

//betweenCluase: ID BETWEEN '(' NUMBER ',' NUMBER ')';


NUMBER_LIST:            NUMBER (',' SPACE* NUMBER)*;
CHARS_LIST:             '\'' CHARS '\'' (',' SPACE* '\'' CHARS '\'')*;

WS:                     [ \t\n\r]+ -> skip ;

SELECT:                 'SELECT';
//FROM:                   'FROM';
IN:                     'IN';
//WHERE:                  'WHERE';
//BETWEEN:                'BETWEEN';
//
//PARTITION:              'PARTITION';
//TIMESTAMP:              'TIMESTAMP';
//
OFFSETS:                'OFFSETS';
PARTITIONS:             'PARTITIONS';
CONSUMERS:              'CONSUMERS';
CONSUMER_OFFSET:        'CONSUMER_OFFSET';
//
//BYTE:                   'BYTE';
//JSON:                   'JSON';
//STR:                    'STR';
//STAR:                   '*';
//EQUAL:                  '=';
//SEMICOLON:              ';';

ID:                     ID_LITERAL;
NUMBER:                 [0-9]+;
CHARS:                  [a-zA-Z0-9]+;
SPACE:                  ' ';

fragment ID_LITERAL:    [A-Z_$0-9]*?[A-Z_$]+?[A-Z_$0-9]*;
