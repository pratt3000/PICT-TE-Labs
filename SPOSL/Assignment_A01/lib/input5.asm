 
    START 100
    MOVER   AREG,   A
LOOP    PRINT   B
    ADD BREG,   ='9'
    SUB BREG,   D
    COMP    CREG,   ='23'
    LTORG
A   DS  3
LABEL   EQU LOOP
    ORIGIN  500
L1  MULT    CREG,   ='7'
    SUB BREG,   ='93'
    LTORG
B   DC  '10'
    MOVEM   CREG,   ='7'
    PRINT   ='7'
D   DC  8
    END