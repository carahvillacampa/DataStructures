#!/bin/sh

if [ $# -lt 1 ]; then
    echo "Usage: $0 ClassName"
    exit
fi

if [ -e /c ]; then
    SEP=";"
else
    SEP=":"
fi

printandrun () {
    echo "$@"
    "$@" || exit $?
}

compilemaybe () {
    if [ \! -e "$1".java ]; then
        echo "Error: $1.java not found."
        exit
    fi
    if [ \! -e "$1".class -o "$1".java -nt "$1".class ]; then
        printandrun javac -Xlint:all,-unchecked -cp .${SEP}./algs4.jar "$1".java
    fi
}
for class in NakedTree ProgrammingAssignment1 TwoThreeTree; do
    compilemaybe $class
done
compilemaybe "$1"
printandrun java -ea -cp .${SEP}./algs4.jar "$@"
