public class CircularLinkedList {
    
    public class Node {
        String name;
        Node nextNode;

        public Node(String name) {
            this.name = name;
        }
    }

    private Node head = null;
    private Node tail = null;
    CircularLinkedList list;


    public void addNode(String name){  
        //Create new node  
        Node newNode = new Node(name);  
        //Checks if the list is empty.  
        if(head == null) {  
             //If list is empty, both head and tail would point to new node.  
            head = newNode;  
            tail = newNode;  
            newNode.nextNode = head;  
        }  
        else {  
            //tail will point to new node.  
            tail.nextNode = newNode;  
            //New node will become new tail.  
            tail = newNode;  
            //Since, it is circular linked list tail will point to head.  
            tail.nextNode = head;  
        }  
    }  

    public void CreateCircularLinkedList(CircularLinkedList list){
        list.addNode("Alice");
        list.addNode("Bob");
        list.addNode("Devin");
        list.addNode("Lucas");
        list.addNode("Felipe");
        list.addNode("Bruce Montgomery");
        list.addNode("Zach");
        list.addNode("Murray Cox");
        list.addNode("Rachel Cox");
        list.addNode("Dwight");
        list.addNode("Max");
        list.addNode("Roshan");
        list.addNode("Gayathri");
        list.addNode("Vardhini");
        list.addNode("Jon");
        list.addNode("Mathew");
        list.addNode("Julia");
        list.addNode("Andrew");
        list.addNode("Aspen");
        list.addNode("Kate");
        list.addNode("Danny");
        list.addNode("Peter");
        list.addNode("Alice");
        list.addNode("Amanda");
        list.addNode("Chris");
        list.addNode("Tylor");
        list.addNode("Cooper");
        list.addNode("Noah");
        list.addNode("Ali");
        list.addNode("Katie");
        list.addNode("Lauren");
        list.addNode("Juliana");
        list.addNode("Pedro");
        list.addNode("Sherlock");
        list.addNode("Gaia");
        list.addNode("Ayla");
        list.addNode("Melissa");
        list.addNode("Sophie");
        list.addNode("Max");
        list.addNode("Madi");
        list.addNode("Allie");
        list.addNode("Sammie");        
    }


    public void traverseList() {
        Node currentNode = head;
        if (head != null) {
            do {
                System.out.println(currentNode.name + " ");
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
        }
    }

    // Node current = head;
    public String nameSelector(int count) {
        int num = 0;
        Node current = head;
        while(num != count){
            current = current.nextNode;
            num++;
        }
        System.out.println(head);
        return current.name;
    }
}