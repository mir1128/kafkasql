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

consumersStatement : CONSUMERS '(' (STAR | ID) ')';

consumerOffsetStatement : CONSUMER_OFFSET '(' ID ')';

querySpecification : (STAR | value (',' value)*) FROM ID whereClause ? ;

value : (byteFunction | strFunction );

whereClause: WHERE (equationClause | inCluase | betweenCluase);

inCluase : (PARTITION | TIMESTAMP | value) IN '(' (NUMBER (',' SPACE* NUMBER)* | CHARS  (',' SPACE*  CHARS )*) ')' ;
betweenCluase: (PARTITION | TIMESTAMP )BETWEEN '(' NUMBER ',' NUMBER ')';

equationClause : partitionsEquslCluase
    | timestampEquslCluase
    | valueEqualClause
    ;

partitionsEquslCluase: PARTITION EQUAL NUMBER;
timestampEquslCluase: TIMESTAMP EQUAL NUMBER;
valueEqualClause: value EQUAL (CHARS | NUMBER);

byteFunction: BYTE '(' ID ')';
strFunction: STR '(' ID ')';

numberList: NUMBER (',' SPACE* NUMBER)*;
charsList: CHARS  (',' SPACE*  CHARS )*;


WS:                     [ \t\n\r]+ -> skip ;

SELECT:                 [Ss][Ee][Ll][Ee][Cc][Tt];
FROM:                   [Ff][Rr][Oo][Mm];
IN:                     [Ii][Nn];
WHERE:                  [Ww][Hh][Ee][Rr][Ee];
BETWEEN:                [Bb][Ee][Tt][Ww][Ee][Ee][Nn];

PARTITION:              [Pp][Aa][Tt][Ii][Tt][Ii][Oo][Nn];
TIMESTAMP:              [Tt][Ii][Mm][Ee][Ss][Tt][Aa][Mm][Pp];
OFFSET:                 [Oo][Ff][Ff][Ss][Ee][Tt];

TOPICS:                 [Tt][Oo][Pp][Ii][Cc][Ss];
OFFSETS:                [Oo][Ff][Ff][Ss][Ee][Tt][Ss];
PARTITIONS:             [Pp][Aa][Tt][Ii][Tt][Ii][Oo][Nn][Ss];
CONSUMERS:              [Cc][Oo][Nn][Ss][Uu][Mm][Ee][Rr][Ss];
CONSUMER_OFFSET:        [Cc][Oo][Nn][Ss][Uu][Mm][Ee][Rr]'_'[Oo][Ff][Ff][Ss][Ee][Tt];
//
BYTE:                   [Bb][Yy][Tt][Ee];
STR:                    [Ss][Tt][Rr];
STAR:                   '*';
EQUAL:                  '=';
SEMICOLON:              ';';



ID:                     ID_LITERAL;
SPACE:                  ' ';
NUMBER:                 [0-9]+;
CHARS:                  '\'' [a-zA-Z0-9]+ '\'';
fragment ID_LITERAL:    [A-Z_$0-9-]*?[A-Z_$-]+?[A-Z_$0-9-]*;
