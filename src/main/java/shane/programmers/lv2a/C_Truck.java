package shane.programmers.lv2a;
/* Review
 * when I compared weight like "list.get(0).weight + totalWeight < weight"
 * third example returned 200 all the time, and finally i found a reason, changed to "<="
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class C_Truck {

	public static void main(String[] args) {
		int a = solution(2,10,new int[] {7,4,5,6});
		System.out.println(a);
		int b = solution(100,100,new int[] {10});
		System.out.println(b);
		int c = solution(100,100,new int[] {10,10,10,10,10,10,10,10,10,10});
		System.out.println(c);
	}

	static public int solution(int bridge_length, int weight, int[] truck_weights) {
		class Truck{
			int distance;
			int weight;
			@Override
			public String toString() {
				return "Truck [distance=" + distance + ", weight=" + weight + "]";
			}
			public Truck(int weight, int bridge_length) {
				this.weight = weight;
				this.distance = bridge_length;
			}
		}
		final int SIZE = truck_weights.length;
		ArrayList<Truck> list = new ArrayList<>();
		for(int i=0; i<SIZE; i++)
			list.add(new Truck(truck_weights[i], bridge_length));

		Queue<Truck> queue = new LinkedList<>();
		int totalWeight = 0;
		int time = 1;

		while(list.size() !=0 || queue.size() !=0) {

			if(list.size()!=0 && list.get(0).weight + totalWeight <= weight) {
				totalWeight += list.get(0).weight;
				queue.offer(list.get(0));
				list.remove(0);
			}

			Iterator<Truck> it = queue.iterator();
			Truck truck = it.next();
			if(truck.distance == 1) {
				totalWeight -= truck.weight;
				queue.poll();
			}
			it = queue.iterator();

			while(it.hasNext()) {
				it.next().distance--;
			}

			time++;
		}



		return time;
	}

}
