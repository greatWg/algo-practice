package com.Interview;

public class MatchingParanthesis {

}

// balance parens
// 1. "(()" -> "()"
// ?yy
// 2. ")(" -> ""
// 3. "(()()))(()" -> "(()())()"
// 4. "" -> ""

// String balanceParanthesis (String input)
// String output= String.Empty();
// int start =0;
// int end = 0;
// int i=0;
// int j=0;
//
// Node head;
// if (input.length == 0){
// output;
// }
//
// for (i=0 ; i<input.length; i++){
// // set up list
// if ( i==0)
// {head= new Node();} -// return output
//
// // setup
// Node current= new Node();
// head.next = current;
//
// if (input[i] == ")" &&
// current.prev == "(")
// current.value = "y";
// current.prev.value= "y";
// }
// }
//
//
// while (head.next !=null){
// Node current = head.next;
//
// if( !head.value=="?")
// output[j] = current.value;
//
// } head= current;
//
//
// }
//
// Node{
// node prev;
// node next;
// char value =?;
//
// Node (char c){
// this.char = c;}
// }
//
// start =0 while
// end=0