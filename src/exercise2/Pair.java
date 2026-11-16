/**
 * Mutable 2-tuple type.
 * 
 * @author Nathan Sprague and Michael S. Kirkpatrick
 * @version V4, 8/2021
 */

package exercise2;

public class Pair<T,Q> {

  private T first;
  private Q second;

  /**
   * Create an Pair with the provided objects.
   * 
   * @param first The first object.
   * @param second The second object.
   */
  public Pair(T first, Q second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public Q getSecond() {
    return second;
  }

  public void setSecond(Q second) {
    this.second = second;
  }

  @Override
  public String toString() {
    return "<" + first.toString() + ", " + second.toString() + ">";
  }

}