package hemtentamen;

public class PickNumberGame {
  public static void main(String[] args) {
    int[] list = { 4, 1, 3, 15 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMoveForTwoPlayers(list));
  }

  private static int calculateOptimalFirstMoveForTwoPlayers(int[] list) {
    return calculateOptimalFirstMove(list, 0, list.length - 1, true);
  }

  private static int calculateOptimalFirstMove(int[] list, int first, int last, boolean isMyTurn) {
    // no numbers left to pick
    if (first > last) {
      return 0;
    }

    if (isMyTurn) {
      int firstPick = list[first] - calculateOptimalFirstMove(list, first + 1, last, false);
      int lastPick = list[last] - calculateOptimalFirstMove(list, first, last - 1, false);

      // return the value of the optimal move
      if (firstPick < lastPick) {
        return list[first];
      } else {
        return list[last];
      }

    } else {
    

      int opponentFirstPick = list[first] - calculateOptimalFirstMove(list, first + 1, last, true);
      int opponentLastPick = list[last] - calculateOptimalFirstMove(list, first, last - 1, true);

      // opponent strategy is to move that is worst for me
      return Math.max(opponentFirstPick, opponentLastPick);
    }
  }
}
