package lv2;
//Efficient test failed
public class F_Spicier_Binary_Tree_Failed {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1},4) == 2);
		System.out.println(solution(new int[] {10, 10, 10, 10, 10},100) == 4);
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12},7) ==2);
		System.out.println(solution(new int[] {0, 2, 3, 9, 10, 12},7) ==2);
		System.out.println(solution(new int[] {0, 0, 3, 9, 10, 12},7) ==3);	// 해결 필요
		System.out.println(solution(new int[] {0, 0, 0, 0},7) == -1);
		System.out.println(solution(new int[] {0, 0, 3, 9, 10, 12},7000) == -1);
		System.out.println(solution(new int[] {0, 0, 3, 9, 10, 12},0) == 0);	// answer must be 0
		System.out.println(solution(new int[] {0, 0, 3, 9, 10, 12},1) == 2);
		System.out.println(solution(new int[] {0,0},0) == 0); // answer must be 0
		System.out.println(solution(new int[] {0,0},1) == -1);
		System.out.println(solution(new int[] {1,0},1) == 1);
		System.out.println(solution(new int[] {1,2,3},11));

	}
	static public int solution(int[] scoville, int K) {
		class Tree{
			public int value;
			public Tree leftChild;
			public Tree rightChild;
			public Tree parent;

			public Tree(int value, Tree parent) {
				this.value = value;
				this.parent = parent;
				this.leftChild = null;
				this.rightChild = null;
			}

		}

		class BinarySearchTree{
			private Tree root = null;

			public Tree insertKey(Tree root, int value,Tree parent) {
				Tree p = root;
				Tree newTree = new Tree(value, parent);

				if(p==null) {
					return root=newTree;
				}else if(p.value < newTree.value) {
					p.rightChild = insertKey(p.rightChild,value,root);
					return p;
				}else {
					p.leftChild = insertKey(p.leftChild,value,root);
					return p;
				}
			}

			public void removeSmallest() {
				Tree p = searchMin(this.root);
				if(p.parent != null && p.rightChild != null  ) {
					p.parent.leftChild = p.rightChild;
					p.rightChild.parent = p.parent;
				}
				else if(p.rightChild != null) {// parent is null and it has child
					this.root = p.rightChild;
					p.rightChild.parent = null;
				}else if(p.parent !=null) {	// parent is not null, and it doesn't have child
					p.parent.leftChild = null;
				}else {	// parent is null and it doesn't have any children
					this.root = null;
				}

			}

			public void insertBST(int value) {
				root= insertKey(root,value,root);
			}

//			public void inOrder(Tree root) {
//				if(root != null) {
//					inOrder(root.leftChild);
//					System.out.print(root.value + " ");
//					inOrder(root.rightChild);
//				}
//			}

			public Tree searchMin(Tree root) {
				if(root.leftChild != null) {
					return searchMin(root.leftChild);
				}else return root;
			}

			public Tree searchMin() {
				return searchMin(root);
			}

		}

		BinarySearchTree bst = new BinarySearchTree();
		for(int i : scoville) {
			bst.insertBST(i);
		}

		int count = 0;
		while(true) {
			Tree minTree = bst.searchMin();
			int min = minTree.value;
			if(min >= K)
				return count;
			else if(minTree.parent == null && minTree.rightChild ==null)
				return -1;

			bst.removeSmallest();

			Tree nextMinTree = bst.searchMin();
			int minNext = nextMinTree.value;

			bst.removeSmallest();

			bst.insertBST(min + 2 * minNext);
			count++;
		}

	}

}
