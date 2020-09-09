import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem#841
 * Keys and Rooms
 * <p>
 * There are N rooms and you start in room 0.  Each room has a distinct number
 * in 0, 1, 2, ..., N-1, and each room may have some keys to access the next
 * room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j]
 * is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j]
 * = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 */
public class KeysAndRooms {

  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    explore(rooms, 0, visited);
    for (boolean b : visited) {
      if (!b) {
        return false;
      }
    }
    return true;
  }

  private static void explore(List<List<Integer>> rooms, int room, boolean[] visited) {
    visited[room] = true;
    for (int connectedRoom : rooms.get(room)) {
      if (!visited[connectedRoom]) {
        explore(rooms, connectedRoom, visited);
      }
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> rooms1 = new ArrayList<>();
    rooms1.add(Collections.singletonList(1));
    rooms1.add(Collections.singletonList(2));
    rooms1.add(Collections.singletonList(3));
    rooms1.add(Collections.emptyList());

    System.out.println(canVisitAllRooms(rooms1));

    List<List<Integer>> rooms2 = new ArrayList<>();
    rooms2.add(Arrays.asList(1, 3));
    rooms2.add(Arrays.asList(3, 0, 1));
    rooms2.add(Arrays.asList(2));
    rooms2.add(Arrays.asList(0));

    System.out.println(canVisitAllRooms(rooms2));

  }
}
