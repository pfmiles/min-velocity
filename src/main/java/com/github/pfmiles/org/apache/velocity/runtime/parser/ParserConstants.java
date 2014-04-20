/* Generated By:JJTree&JavaCC: Do not edit this line. ParserConstants.java */
package com.github.pfmiles.org.apache.velocity.runtime.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int INDEX_LBRACKET = 1;
  /** RegularExpression Id. */
  int INDEX_RBRACKET = 2;
  /** RegularExpression Id. */
  int LBRACKET = 3;
  /** RegularExpression Id. */
  int RBRACKET = 4;
  /** RegularExpression Id. */
  int COMMA = 5;
  /** RegularExpression Id. */
  int DOUBLEDOT = 6;
  /** RegularExpression Id. */
  int COLON = 7;
  /** RegularExpression Id. */
  int LEFT_CURLEY = 8;
  /** RegularExpression Id. */
  int RIGHT_CURLEY = 9;
  /** RegularExpression Id. */
  int LPAREN = 10;
  /** RegularExpression Id. */
  int RPAREN = 11;
  /** RegularExpression Id. */
  int REFMOD2_RPAREN = 12;
  /** RegularExpression Id. */
  int ESCAPE_DIRECTIVE = 13;
  /** RegularExpression Id. */
  int SET_DIRECTIVE = 14;
  /** RegularExpression Id. */
  int DOLLAR = 15;
  /** RegularExpression Id. */
  int DOLLARBANG = 16;
  /** RegularExpression Id. */
  int HASH = 20;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT_START = 21;
  /** RegularExpression Id. */
  int DOUBLE_ESCAPE = 22;
  /** RegularExpression Id. */
  int ESCAPE = 23;
  /** RegularExpression Id. */
  int TEXT = 24;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 25;
  /** RegularExpression Id. */
  int FORMAL_COMMENT = 26;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 27;
  /** RegularExpression Id. */
  int TEXTBLOCK = 28;
  /** RegularExpression Id. */
  int WHITESPACE = 31;
  /** RegularExpression Id. */
  int STRING_LITERAL = 32;
  /** RegularExpression Id. */
  int TRUE = 33;
  /** RegularExpression Id. */
  int FALSE = 34;
  /** RegularExpression Id. */
  int NEWLINE = 35;
  /** RegularExpression Id. */
  int MINUS = 36;
  /** RegularExpression Id. */
  int PLUS = 37;
  /** RegularExpression Id. */
  int MULTIPLY = 38;
  /** RegularExpression Id. */
  int DIVIDE = 39;
  /** RegularExpression Id. */
  int MODULUS = 40;
  /** RegularExpression Id. */
  int LOGICAL_AND = 41;
  /** RegularExpression Id. */
  int LOGICAL_OR = 42;
  /** RegularExpression Id. */
  int LOGICAL_LT = 43;
  /** RegularExpression Id. */
  int LOGICAL_LE = 44;
  /** RegularExpression Id. */
  int LOGICAL_GT = 45;
  /** RegularExpression Id. */
  int LOGICAL_GE = 46;
  /** RegularExpression Id. */
  int LOGICAL_EQUALS = 47;
  /** RegularExpression Id. */
  int LOGICAL_NOT_EQUALS = 48;
  /** RegularExpression Id. */
  int LOGICAL_NOT = 49;
  /** RegularExpression Id. */
  int EQUALS = 50;
  /** RegularExpression Id. */
  int END = 51;
  /** RegularExpression Id. */
  int IF_DIRECTIVE = 52;
  /** RegularExpression Id. */
  int ELSEIF_DIRECTIVE = 53;
  /** RegularExpression Id. */
  int ELSE_DIRECTIVE = 54;
  /** RegularExpression Id. */
  int DIGIT = 55;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 56;
  /** RegularExpression Id. */
  int FLOATING_POINT_LITERAL = 57;
  /** RegularExpression Id. */
  int EXPONENT = 58;
  /** RegularExpression Id. */
  int LETTER = 59;
  /** RegularExpression Id. */
  int DIRECTIVE_CHAR = 60;
  /** RegularExpression Id. */
  int WORD = 61;
  /** RegularExpression Id. */
  int BRACKETED_WORD = 62;
  /** RegularExpression Id. */
  int ALPHA_CHAR = 63;
  /** RegularExpression Id. */
  int ALPHANUM_CHAR = 64;
  /** RegularExpression Id. */
  int IDENTIFIER_CHAR = 65;
  /** RegularExpression Id. */
  int IDENTIFIER = 66;
  /** RegularExpression Id. */
  int DOT = 67;
  /** RegularExpression Id. */
  int LCURLY = 68;
  /** RegularExpression Id. */
  int RCURLY = 69;
  /** RegularExpression Id. */
  int REFERENCE_TERMINATOR = 70;
  /** RegularExpression Id. */
  int DIRECTIVE_TERMINATOR = 71;
  /** RegularExpression Id. */
  int EMPTY_INDEX = 72;

  /** Lexical state. */
  int REFERENCE = 0;
  /** Lexical state. */
  int REFMODIFIER = 1;
  /** Lexical state. */
  int REFINDEX = 2;
  /** Lexical state. */
  int DIRECTIVE = 3;
  /** Lexical state. */
  int REFMOD2 = 4;
  /** Lexical state. */
  int DEFAULT = 5;
  /** Lexical state. */
  int REFMOD = 6;
  /** Lexical state. */
  int IN_TEXTBLOCK = 7;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMENT = 8;
  /** Lexical state. */
  int IN_FORMAL_COMMENT = 9;
  /** Lexical state. */
  int IN_SINGLE_LINE_COMMENT = 10;
  /** Lexical state. */
  int PRE_DIRECTIVE = 11;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"[\"",
    "\"]\"",
    "\"[\"",
    "\"]\"",
    "\",\"",
    "\"..\"",
    "\":\"",
    "\"{\"",
    "\"}\"",
    "\"(\"",
    "<RPAREN>",
    "\")\"",
    "<ESCAPE_DIRECTIVE>",
    "<SET_DIRECTIVE>",
    "<DOLLAR>",
    "<DOLLARBANG>",
    "\"#[[\"",
    "<token of kind 18>",
    "\"#*\"",
    "\"#\"",
    "\"##\"",
    "\"\\\\\\\\\"",
    "\"\\\\\"",
    "<TEXT>",
    "<SINGLE_LINE_COMMENT>",
    "\"*#\"",
    "\"*#\"",
    "\"]]#\"",
    "<token of kind 29>",
    "<token of kind 30>",
    "<WHITESPACE>",
    "<STRING_LITERAL>",
    "\"true\"",
    "\"false\"",
    "<NEWLINE>",
    "\"-\"",
    "\"+\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "<LOGICAL_AND>",
    "<LOGICAL_OR>",
    "<LOGICAL_LT>",
    "<LOGICAL_LE>",
    "<LOGICAL_GT>",
    "<LOGICAL_GE>",
    "<LOGICAL_EQUALS>",
    "<LOGICAL_NOT_EQUALS>",
    "<LOGICAL_NOT>",
    "\"=\"",
    "<END>",
    "<IF_DIRECTIVE>",
    "<ELSEIF_DIRECTIVE>",
    "<ELSE_DIRECTIVE>",
    "<DIGIT>",
    "<INTEGER_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<EXPONENT>",
    "<LETTER>",
    "<DIRECTIVE_CHAR>",
    "<WORD>",
    "<BRACKETED_WORD>",
    "<ALPHA_CHAR>",
    "<ALPHANUM_CHAR>",
    "<IDENTIFIER_CHAR>",
    "<IDENTIFIER>",
    "<DOT>",
    "\"{\"",
    "\"}\"",
    "<REFERENCE_TERMINATOR>",
    "<DIRECTIVE_TERMINATOR>",
    "<EMPTY_INDEX>",
  };

}