/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.exception;

/**
 *
 * @author jobou
 */
public class MediaImageNotFoundException extends Exception {

      //Parameterless Constructor
      public MediaImageNotFoundException() {}

      //Constructor that accepts a message
      public MediaImageNotFoundException(String message)
      {
         super(message);
      }
 }