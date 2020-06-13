public class BST_Nonrecursive_12_1_3{
	Node root;
	int size;

	static class Node{
		Node right; Node left; Node parent;
		int key;

		public Node(Node l, Node r, int k){
			left = l; right = r; key = k;
		}
	}

	public void recursive_Insert(Node n){
		if (root == null) 
			root = n;
		else recursive_Insert(null, root, n);
	}

	public void recursive_Insert(Node parent, Node x, Node insert){
		if (x==null){
			insert.parent = parent;
			if (insert.key < parent.key)
				parent.left = insert;
			else parent.right = insert;
		}
		else if (insert.key < x.key) 
			recursive_Insert(x, x.left, insert);
		else recursive_Insert(x, x.right, insert);
	}

	

	public void insert(Node n){
		Node y = null;
		Node x = root;
		while (x!= null){
			y = x;
			if (n.key > x.key) x = x.right;
			else x= x.left;
		}
		n.parent = y;
		if (y == null) root = n;
		else {
			if (n.key > y.key) y.right = n;
			else y.left = n;
		}
		size++;
	}

	public void insert(int key){
                Node n = new Node(null, null, key);
                //insert(n);
		recursive_Insert(n); // testing recursive
        }

	public void print_inorder(Node n){
		Node z = null; boolean left_done = false;
		while(n != null){
			// find left most & print it first then go to right subtree
			if (left_done == false) {
				while(n.left != null) {
					n = n.left;
				}
			}

			System.out.print (n.key + ",");
			left_done = true; // left tree of root processed
			// we need to process subtree of right node, so make left_done false
			if ( n.right != null) {
				left_done = false;
				n = n.right;
			}
			// if no right subtree then go back to parent
			// if right child go to parent's parent becoz parent is already printed before right
			else if ( n.parent != null ) {
				while ((n.parent != null) && (n.parent.right == n)) {
					n = n.parent;
				}
				n = n.parent;
			} else break;	
				
		}
	}
		
			

	public static void main(String[] args){
                BST_Nonrecursive_12_1_3 b = new BST_Nonrecursive_12_1_3();
                b.insert(9); b.insert(4); b.insert(14); b.insert(2); b.insert(12); b.insert(16);
                b.insert(1); b.insert(10); b.insert(3); b.insert(18); b.insert(5);
                System.out.println(" ");
                b.print_inorder(b.root);
                //b.iterative_print(9);

        }

}
