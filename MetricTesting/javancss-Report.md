# Calculating Design Quality Metrics with
[JavaNCSS](http://www.kclee.de/clemens/java/javancss/#usage)

## Overview
Curious about the size of your own projects - or do you want to keep
track of your work-progress. According to the creators of JavaNCSS, that's exactly
what JavaNCSS is for! Also, it is entirely written in Java!


## JavaNCSS Calculated Design Quality Metrics
JavaNCSS, or Non Commenting Source Statements for Java, is a tool that provides the
user with many features and metrics. These features and metrics consist
of, but are not limited to, Non Commenting Source Statements (NCSS),
cyclomatic complexity number, packages, classes, functions and inner
classes are counted and the number of formal Javadoc comments per class and method.

Unlike JDepend which does its analysis of the program as a whole, JavaNCSS studies
the source code of each class, looking for the number of lines, if its global.
JavaNCSS is specific in the code, and the functions of the each class.

## Meaning of the Calculated Metrics
Aforementioned is that one of the metrics calculated by JavaNCSS is the
number of non commenting source statements which refer to the number of
lines used in statements and declarations as defined by JavaNCSS.
Second, cyclomatic complexity of a system refers to the independent of the physical size of the
component. The Cyclomatic complexity mainly depends on the decision
structure present in the component, according to Umesh TiwariEra and Santosh Kumar
in [Cyclomatic complexity metric for component based
software](http://dl.acm.org/citation.cfm?id=2557853). Cyclomatic
complexity in a more general meaning is the number of linearly independent paths
within the system. For instance, if the source code contained no control flow
statements (conditionals or decision points), such as IF statements, the
complexity would be 1, since there is only a single path through the
code. If the code had one single-condition IF statement, there would be
two paths through the code: one where the IF statement evaluates to TRUE
and another one where it evaluates to FALSE, so complexity will be 2 for
single IF statement with single condition.
