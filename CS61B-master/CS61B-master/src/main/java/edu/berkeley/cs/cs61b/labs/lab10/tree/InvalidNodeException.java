package edu.berkeley.cs.cs61b.labs.lab10.tree;

/* InvalidNodeException.java */

//package tree;

/**
 *  Implements an Exception that signals an attempt to use an invalid ListNode.
 */

public class InvalidNodeException extends Exception {
  protected InvalidNodeException() {
    super();
  }

  protected InvalidNodeException(String s) {
    super(s);
  }
}