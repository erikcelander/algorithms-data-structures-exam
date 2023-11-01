package hemtentamen;

public class PickNumberGame {

  public static void main(String[] args) {
    int[] list1 = { 10, 1, 10, 20 };
    System.out.println("Optimal move according to algorithm is: " + calculateOptimalFirstMove(list1, 2) + ", expected: 10");

    int[] list2 = { 10, 1, 10, 18 };
    System.out.println("Optimal move according to algorithm is: " + calculateOptimalFirstMove(list2, 2) + ", expected: 18");

    int[] list3 = { 4, 10, 2, 5 };
    System.out.println("Optimal move according to algorithm is: " + calculateOptimalFirstMove(list3, 2) + ", expected: 4");

    int[] list4 = { 1, 100, 1, 100 };
    System.out.println("Optimal move according to algorithm is: " + calculateOptimalFirstMove(list4, 2) + ", expected: 1");

    int[] list5 = { 5, 3, 7, 10 };
    System.out.println("Optimal move according to algorithm is: " + calculateOptimalFirstMove(list5, 2) + ", expected: 10");

    int[] list6 = { 8, 15, 3, 7 };
    System.out.println("Optimal move according to algorithm is: " + calculateOptimalFirstMove(list6, 2) + ", expected: 8");

    int[] list7 = { 20, 5, 4, 8, 10, 2 };
    System.out.println("Optimal move according to algorithm is: " + calculateOptimalFirstMove(list7, 2) + ", expected: 2");
  }

  private static int calculateOptimalFirstMove(int[] list, int p) {
    if (p == 2) {
      return calculateOptimalFirstMoveForTwoPlayers(list, 0, list.length - 1, true);
    } else if (p > 2 && p <= 10) {
      // return calculateOptimalFirstMoveForMoreThanTwoPlayers(list, p);
      return -1;
    } else {
      throw new IllegalArgumentException("Number of players must be between 2 and 10");
    }
  }

  private static int calculateOptimalFirstMoveForTwoPlayers(int[] list, int first, int last, boolean isMyTurn) {
    if (first > last) {
      return 0;
    }

    if (isMyTurn) {
      int firstNumberScore = list[first] + calculateOptimalFirstMoveForTwoPlayers(list, first + 1, last, false);
      int lastNumberScore = list[last] + calculateOptimalFirstMoveForTwoPlayers(list, first, last - 1, false);

      if (firstNumberScore < lastNumberScore) {
        return list[first];
      } else {
        return list[last];
      }

    } else {
      int oppFirstNumberScore = calculateOptimalFirstMoveForTwoPlayers(list, first + 1, last, true);
      int oppLastNumberScore = calculateOptimalFirstMoveForTwoPlayers(list, first, last - 1, true);

      if (oppFirstNumberScore > oppLastNumberScore) {
        return oppFirstNumberScore;
      } else {
        return oppLastNumberScore;
      }
    }
  }

}
