grammar KafkaSql;

selectStatement : SELECT topicStatement
    | SELECT offsetStatement
    | SELECT partitionsStatement
    | SELECT consumersStatement
    | SELECT consumerOffsetStatement
    | SELECT querySpecification
    ;

topicStatement : TOPICS ;

offsetStatement : OFFSETS '(' ID ('.' NUMBER (',' SPACE* NUMBER)*)? ')';

partitionsStatement : PARTITIONS '(' ID ')';

consumersStatement : CONSUMERS '(' ID ')';

consumerOffsetStatement : CONSUMER_OFFSET '(' ID ')';

querySpecification : (STAR | value (',' value)*) FROM ID whereClause ? ;

value : (byteFunction | jsonFunction | strFunction );

whereClause: WHERE (equationClause | inCluase | betweenCluase);

inCluase : (PARTITION | TIMESTAMP | OFFSET) IN '(' (NUMBER (',' SPACE* NUMBER)* | CHARS  (',' SPACE*  CHARS )*) ')' ;
betweenCluase: (PARTITION | TIMESTAMP | OFFSET)BETWEEN '(' NUMBER ',' NUMBER ')';

equationClause : partitionsEquslCluase
    | timestampEquslCluase
    | valueEqualClause
    ;

partitionsEquslCluase: PARTITION EQUAL NUMBER;
timestampEquslCluase: TIMESTAMP EQUAL NUMBER;
valueEqualClause: value EQUAL (CHARS | NUMBER);

byteFunction: BYTE '(' ID ')';
jsonFunction: JSON '(' ID ')';
strFunction: STR '(' ID ')';

numberList: NUMBER (',' SPACE* NUMBER)*;
charsList: CHARS  (',' SPACE*  CHARS )*;


WS:                     [ \t\n\r]+ -> skip ;

SELECT:                 'SELECT';
FROM:                   'FROM';
IN:                     'IN';
WHERE:                  'WHERE';
BETWEEN:                'BETWEEN';

PARTITION:              'PARTITION';
TIMESTAMP:              'TIMESTAMP';
OFFSET:                 'OFFSET';

TOPICS:                 'TOPICS';
OFFSETS:                'OFFSETS';
PARTITIONS:             'PARTITIONS';
CONSUMERS:              'CONSUMERS';
CONSUMER_OFFSET:        'CONSUMER_OFFSET';
//
BYTE:                   'BYTE';
JSON:                   'JSON';
STR:                    'STR';
STAR:                   '*';
EQUAL:                  '=';
SEMICOLON:              ';';



ID:                     ID_LITERAL;
SPACE:                  ' ';
NUMBER:                 [0-9]+;
CHARS:                  '\'' [a-zA-Z0-9]+ '\'';
fragment ID_LITERAL:    [A-Z_$0-9-]*?[A-Z_$-]+?[A-Z_$0-9-]*;
