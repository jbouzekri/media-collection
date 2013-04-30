/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.tools;

import org.apache.commons.lang.WordUtils;

/**
 *
 * @author jobou
 */
public class StringTools {

  public static String camelize(String string) {
    return WordUtils.capitalizeFully(string.replace("_", " ")).replace(" ", "");
  }

}
