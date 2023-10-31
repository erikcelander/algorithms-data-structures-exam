package hemtentamen;

public class PickNumberGame {
  public static void main(String[] args) {
    int[] list = { 4, 1, 3, 2 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list, 0, list.length - 1, true));
  }

  /**
   * recursively calculates the optimal move in the number picking game
   *
   * @param numbers - array of numbers to pick from
   * @param first - first index in the array
   * @param last - last index in the array
   * @param isMyTurn - boolean to indicate whose turn it is
   * @return - the value of the optimal move
   */
  private static int calculateOptimalFirstMove(int[] list, int first, int last, boolean isMyTurn) {
    // base case: no numbers left to pick
    if (first > last) {
      return 0;
    }

    if (isMyTurn) {
      // calculate the score differences if the first or last number is picked for my turn
      int scoreDifferenceIfFirstPicked = list[first] - calculateOptimalFirstMove(list, first + 1, last, false);
      int scoreDifferenceIfLastPicked = list[last] - calculateOptimalFirstMove(list, first, last - 1, false);

      // return the value of the optimal move i.e where we minimize the players score
      if (scoreDifferenceIfFirstPicked < scoreDifferenceIfLastPicked) {
        return list[first];
      } else {
        return list[last];
      }

    } else {
      // calculate the score differences if the first or last number is picked for opponents turn
      int scoreDifferenceIfFirstPicked = list[first] - calculateOptimalFirstMove(list, first + 1, last, true);
      int scoreDifferenceIfLastPicked = list[last] - calculateOptimalFirstMove(list, first, last - 1, true);

      // return the largest score difference
      return Math.max(scoreDifferenceIfFirstPicked, scoreDifferenceIfLastPicked);
    }
  }
}
