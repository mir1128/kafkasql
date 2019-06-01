grammar KafkaSql;

selectStatement : SELECT offsetStatement        SEMICOLON
    | SELECT partitionsStatement                SEMICOLON
    | SELECT consumersStatement                 SEMICOLON
    | SELECT consumerOffsetStatement            SEMICOLON
    | SELECT querySpecification                 SEMICOLON
    ;

offsetStatement : OFFSETS '(' ID ')';

partitionsStatement : PARTITIONS '(' ID ')';


consumersStatement : CONSUMERS '(' ID ')';

consumerOffsetStatement : CONSUMER_OFFSET '(' ID ')';

querySpecification : (STAR | value (',' value)*) FROM ID whereClause;

value : (byteFunction | jsonFunction | strFunction | ID);

whereClause: WHERE (equationClause | inCluase | betweenCluase);

equationClause : partitionsEquslCluase
    | timestampEquslCluase
    | valueEqualClause
    ;

partitionsEquslCluase: PARTITION EQUAL NUMBER;
timestampEquslCluase: TIMESTAMP EQUAL NUMBER;
valueEqualClause: (byteFunction | jsonFunction | strFunction ) EQUAL (CHARS | NUMBER);

byteFunction: BYTE '(' ID ')';
jsonFunction: JSON '(' ID ')';
strFunction: STAR '(' ID ')';

inCluase : ID IN '(' (NUMBER | CHARS) ')' ;

betweenCluase: ID BETWEEN '(' NUMBER ',' NUMBER ')';

NUMBER:                 [0-9]+;
CHARS:                  [a-zA-Z0-9]+;

ID:                     [a-zA-Z_][a-zA-Z0-9]+;

SELECT:                 'SELECT';
FROM:                   'FROM';
IN:                     'IN';
WHERE:                  'WHERE';
BETWEEN:                'BETWEEN';

PARTITION:              'PARTITION';
TIMESTAMP:              'TIMESTAMP';

OFFSETS:                'OFFSETS';
PARTITIONS:             'PARTITIONS';
CONSUMERS:              'CONSUMERS';
CONSUMER_OFFSET:        'CONSUMER_OFFSET';

BYTE:                   'BYTE';
JSON:                   'JSON';
STR:                    'STR';
STAR:                   '*';
EQUAL:                  '=';
SEMICOLON:              ';';