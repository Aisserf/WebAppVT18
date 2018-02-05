
package chl.hajo.library.core;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * The genre of the book
 * @author hajo
 */
public enum Genre {
    THRILLER, NOVEL, ROMANTIC_NOVEL, BIOGRAPHY; 
    

    private static final List<Genre> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static Genre randomLetter()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  } 
}