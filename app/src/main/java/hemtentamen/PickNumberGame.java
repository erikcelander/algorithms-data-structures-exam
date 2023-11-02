package hemtentamen;

public class PickNumberGame {

  public static void main(String[] args) {
    int[] list = { 4, 1, 3, 2 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list, 2) + ", expected: 2");

    int[] list1 = { 10, 1, 10, 20 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list1, 2) + ", expected: 10");

    int[] list2 = { 10, 1, 10, 18 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list2, 2) + ", expected: 18");

    int[] list3 = { 4, 10, 2, 5 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list3, 2) + ", expected: 4");

    int[] list4 = { 1, 100, 1, 100 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list4, 2) + ", expected: 1");

    int[] list5 = { 5, 3, 7, 10 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list5, 2) + ", expected: 5");

    int[] list6 = { 8, 15, 3, 7 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list6, 2) + ", expected: 8");

    int[] list7 = { 20, 5, 4, 8, 10, 2 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list7, 3) + ", expected: 2");

     int[] list8 = { 20, 5, 4, 30, 10, 50 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list8, 3) + ", expected: 20");

     int[] list9 = { 1, 5, 4, 8, 10, 20 };
    System.out.println("Optimal move is: " + calculateOptimalFirstMove(list9, 3) + ", expected: 1");
  }
  

  private static int calculateOptimalFirstMove(int[] list, int p) {
    int first = 0;
    int last = list.length - 1;
    int firstPlayer = 1;
    
    if (p == 2) {
      return calculateOptimalFirstMoveForTwoPlayers(list, first, last, true);
      
    } else if (p > 2 && p <= 10) {
      int firstNumberSum = calculateOptimalFirstMoveForMoreThanTwoPlayers(list, first + 1, last, firstPlayer, p, list[first]);
      int lastNumberSum = calculateOptimalFirstMoveForMoreThanTwoPlayers(list, first, last - 1, firstPlayer, p, list[last]);

      if (firstNumberSum < lastNumberSum) {
        return list[first];
      } else {
        return list[last];
      }

    } else {
      throw new IllegalArgumentException("Number of players must be between 2 and 10");
    }
  }

  private static int calculateOptimalFirstMoveForMoreThanTwoPlayers(int[] list, int first, int last, int currentPlayer, int totalPlayers,int originalNumberToCheck) {
    if (first > last) {
      return originalNumberToCheck;
    }

    int nextPlayer = (currentPlayer + 1) % totalPlayers;

    int firstPickSum = calculateOptimalFirstMoveForMoreThanTwoPlayers(list, first + 1, last, nextPlayer, totalPlayers, originalNumberToCheck);
    int lastPickSum = calculateOptimalFirstMoveForMoreThanTwoPlayers(list, first, last - 1, nextPlayer, totalPlayers, originalNumberToCheck);
 
    return Math.min(firstPickSum, lastPickSum);
  }


  private static int calculateOptimalFirstMoveForTwoPlayers(int[] list, int first, int last, boolean isMyTurn) {
    if (first > last) {
      return 0;
    }

    if (isMyTurn) {
      int firstNumberSum = list[first] + calculateOptimalFirstMoveForTwoPlayers(list, first + 1, last, false);
      int lastNumberSum = list[last] + calculateOptimalFirstMoveForTwoPlayers(list, first, last - 1, false);

      
      if (firstNumberSum < lastNumberSum) {
        return list[first];
      } else {
        return list[last];
      }

    } else {
      int oppFirstNumberSum = calculateOptimalFirstMoveForTwoPlayers(list, first + 1, last, true);
      int oppLastNumberSum = calculateOptimalFirstMoveForTwoPlayers(list, first, last - 1, true);

      if (oppFirstNumberSum > oppLastNumberSum) {
        return oppFirstNumberSum;
      } else {
        return oppLastNumberSum;
      }
    }
  }

  
}
