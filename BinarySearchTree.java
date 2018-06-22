package code;

public class BinarySearchTree {
	public static Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public Node find(int id) {
		Node current = root;
		while (current != null) {
			if (current.data == id) {
				return current;
			} else if (current.data > id) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		return root;
	}

	public boolean delete(int id) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while (current.data != id) {
			parent = current;
			if (current.data > id) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}
		// if i am here that means we have found the node
		// Case 1: if node to be deleted has no children
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Case 2 : if node to be deleted has only one child
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.left != null && current.right != null) {

			// now we have found the minimum element in the right sub tree
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}

	public Node getSuccessor(Node deleleNode) {
		Node successsor = null;
		Node successsorParent = null;
		Node current = deleleNode.right;
		while (current != null) {
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		// check if successor has the right child, it cannot have left child for
		// sure
		// if it does have the right child, add it to the left of
		// successorParent.
		// successsorParent
		if (successsor != deleleNode.right) {
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}

	public void insert(int id) {
		Node newNode = new Node(id);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (id < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

	private boolean checkBST(Node n) {
		if (n == null)
			return true;

		if (n.left == null && n.right == null)
			return true;

		if (n.left != null && n.right != null) {
			if ((n.data < n.left.data || n.data > n.right.data))
				return false;
		}

		if (n.left != null && n.right == null)
			if (n.data < n.left.data)
				return false;

		if (n.right != null && n.left == null)
			if (n.data > n.right.data)
				return false;

		boolean isLeftBST = true;

		if (n.left != null)
			isLeftBST = checkBST(n.left);

		if (!isLeftBST)
			return false;

		boolean isRightBST = true;

		if (n.right != null)
			isRightBST = checkBST(n.right);

		if (!isRightBST)
			return false;

		if (isLeftBST && isRightBST)
			return true;

		return true;
	}

	private boolean checkBST2(Node n, int min, int max) {

		if (n == null)
			return true;

		if (n.data > min && n.data <= max) {

			boolean isLeftBST = checkBST2(n.left, min, n.data);
			boolean isRightBST = checkBST2(n.right, n.data, max);

			if (isLeftBST && isRightBST)
				return true;
			return false;
		}

		else
			return false;

	}

	private boolean checkBST3(Node n, int low, int high) {
		if (n == null)
			return true; // handle the leaf condition
		System.out.println("value: " + n.data + ", low: " + low + ",high: " + high);
		if (n.data < low || n.data > high) { // check for violation
			System.out.println("NOT A BST, violating node is --> " + n.data);
			return false;
		}
		return checkBST3(n.left, low, n.data) && checkBST3(n.right, n.data, high);

	}

	// Assumes n1 < n2
	private Node checkLCA(Node root, int n1, int n2) {
		if (root == null)
			return null;

		if (root.left != null && root.right != null) {
			if (root.left.data == n1 && root.right.data == n2)
				return root;
			if (n2 < root.data) {
				return checkLCA(root.left, n1, n2);
			} else if (n1 > root.data) {
				return checkLCA(root.right, n1, n2);
			} else if (n1 < root.data && n2 > root.data) {

			}
		}

		if (root.right == null) {
			return checkLCA(root.left, n1, n2);
		}

		if (root.left == null) {
			return checkLCA(root.right, n1, n2);
		}

		return null;
	}

	private Node findParent(Node root, int n) {
		/// Node current = find(n);

		Node parent = root;
		/*
		 * 
		 * I might need this code later.
		 * 
		 */

		/*
		 * boolean parentFound = false; while(parent != null && !parentFound){
		 * if(parent.left.data == n){ parentFound = true; } parent =
		 * parent.left; }
		 * 
		 * if(!parentFound){ parent=root; while(parent != null && !parentFound){
		 * if(parent.right.data == n){ parentFound = true; } parent =
		 * parent.left; } }
		 */

		return findParentReal(root, n, null);
	}

	private Node findParentReal(Node currentNode, int n, Node parent) {

		if (currentNode == null)
			return null;

		if (currentNode.data == n) {
			return parent; // parent of current node
		}

		Node leftResult = findParentReal(currentNode.left, n, currentNode);
		if (leftResult != null)
			return leftResult;

		Node rightResult = findParentReal(currentNode.right, n, currentNode);
		if (rightResult != null)
			return rightResult;

		return null;
	}

	private Node findNext(Node current, Node parent) {

		boolean isOfRoot = false;

		if (parent == null) { // Successor of ROOT itself
			isOfRoot = true;
			if (root.right == null)
				return new Node(-1);
			// parent = root;

			Node rightMost = current.right;
			while (rightMost.right != null)
				rightMost = rightMost.right;

			Node leftMost = rightMost;
			while (leftMost.left != null)
				leftMost = leftMost.left;
			return leftMost;
		}

		if (parent.right == null && current.data == parent.right.data) {
			Node tempParent = parent;
			Node tempCurrent = current;

			boolean parentNull = false;

			while (!parentNull) {
				System.out.println("Current: "+tempCurrent.data+" Parent: "+tempParent.data);
				tempCurrent = tempParent;
				tempParent = findParent(root, tempParent.data);
				if (tempParent == null) {
					parentNull = true;
				} else if (tempParent.right == null) {
					tempCurrent = tempParent;
					parentNull = true;
				} else if(tempParent.left != null && tempParent.left.data == tempCurrent.data){ //THIS IS WRONG
					System.out.println("**Current: "+tempCurrent.data+" Parent: "+tempParent.data);
					/*Node rightMost = tempParent.right;
					while (rightMost.right != null && rightMost.left == null)
						rightMost = rightMost.right;

					Node leftMost = rightMost;
					while (leftMost.left != null)
						leftMost = leftMost.left;
					return leftMost;*/
					
					return tempParent;
				}
			}

			return tempCurrent;

		}

		if (current.right == null)
			return parent;

		if (current.right != null) {
			Node rightMost = current.right;
			while (rightMost.right != null)
				rightMost = rightMost.right;

			Node leftMost = rightMost;
			while (leftMost.left != null)
				leftMost = leftMost.left;
			return leftMost;
		}

		return null;
	}

	public static void main(String arg[]) {

		// System.out.println(Integer.MAX_VALUE);
		// System.out.println(Integer.MIN_VALUE);
		BinarySearchTree b = new BinarySearchTree();
		/*
		 * 
		 * TEST DATA I:
		 * 
		 * b.insert(100); b.insert(5); b.insert(150); b.insert(2); b.insert(8);
		 * b.insert(1); b.insert(20); b.insert(14);
		 */

		/*
		 * 
		 * TEST DATA II
		 * 
		 * b.insert(1); b.insert(2); b.insert(3);
		 */
		// b.insert(4);

		/*
		 * 
		 * THIS ONE PASSED NOW for CURRENT = 70
		 * 
		 */
		/*
		 * b.insert(100); b.insert(50); b.insert(20); b.insert(5); b.insert(70);
		 * b.insert(25); b.insert(24);
		 */
		/*
		 * 
		 * 
		 * TEST DATA V
		 * 
		 * 
		 * b.insert(100); b.insert(20); b.insert(5); b.insert(70); b.insert(90);
		 * //b.insert(94);
		 * 
		 * b.insert(98); Node n1 = new Node(78); Node n2 = new Node(76); Node n3
		 * = new Node(71); Node z = b.find(98);
		 * 
		 * z.left = n1; n1.left = n2; n2.left=n3;
		 */

		/*
		 * 
		 * IT WORKS FOR THIS TEST DATA
		 * 
		 * 
		b.insert(100);
		b.insert(50);
		b.insert(10);
		b.insert(90);
		b.insert(75);
		b.insert(85);
		b.insert(83);
		b.insert(120);
		b.insert(105);
		b.insert(102);
*/
		b.insert(100);
		b.insert(50);
		b.insert(20);
		b.insert(10);
		b.insert(5);
		b.insert(15);
		b.insert(17);
		b.insert(18);
		b.insert(16);
		b.insert(25);
		b.insert(23);
		b.insert(30);
		b.insert(28);
		b.insert(32);
		
		
		// Find Parent Tester starts here:
		int n = 10;
		Node result = b.findParent(root, n);
		if (result != null) {
			// System.out.println("Parent of " + n + " is: " + result.data);
		} else {
			// System.out.println("Parent not found. Probaly "+n+" is root.");
		}

		// Check LCA
		// System.out.println("COMMON LCA: " + b.checkLCA(root, 1, 2).data);
		/*
		 * b.insert(12); b.insert(20); b.insert(34); b.insert(40);
		 */

		System.out.println("Original Tree (In-Order) : ");
		b.display(b.root);

		System.out.println();

		int currentData = 25;
		Node current = b.find(currentData);
		Node parent = b.findParent(root, currentData);
		System.out.println("Current: " + current.data);
		if (parent != null)
			System.out.println("Parent: " + parent.data);
		Node next = b.findNext(current, parent);
		System.out.println("In-Order Succesor: " + next.data);
		// Node c = new Node(12);
		// h.right = c;

		Node t = b.find(10);
		Node newnode = new Node(10);
		// t.left = newnode;

		Node m = new Node(50);
		// h.left = m;

		Node j = new Node(10);
		// h.right = j;
		// m.left = j;
		// h.left = m;
		// newnode.left = h;

		// t.left = newnode;

		// System.out.println("T DATA: "+t.data);

		System.out.println("Modified Tree (In-Order) : ");
		b.display(b.root);

		System.out.println();
		// System.out.println();
		// System.out.println();
		// System.out.println();
		// System.out.println();
		System.out.println("ROOT: " + b.root.data);

		// System.out.println("IS BST: "+b.checkBST(root));

		// System.out.println("Is a BST? " + b.checkBST3(root,
		// Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}