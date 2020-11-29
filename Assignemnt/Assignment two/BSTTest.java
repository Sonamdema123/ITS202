public class BSTTest{
	public static void main(String[] args)
	{
		BST<String, Integer> bst = new BST<String, Integer>();

      	bst.put("ABDUL",1);
        System.out.println(bst.get("ABDUL"));

        bst.put("HRITHIK",2);
        bst.put("SAI",3);
        bst.put("SAMAL",6);
        System.out.println(bst.get("SAI"));

        bst.put("TASHI",4);
        System.out.println(bst.size());
        System.out.println(bst.min());
        System.out.println(bst.floor("HRITHIK"));
        System.out.println(bst.floor("HAHA"));
        System.out.println(bst.select(2));

        for (String s : bst.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

        bst.put("CHIMI",5);
        bst.put("SAMAL",4);
        System.out.println(bst.get("SAMAL"));
        bst.put("NIMA",7);
        System.out.println(bst.size());
        System.out.println(bst.get("CHIMI"));
        System.out.println(bst.floor("CHIMA"));
        bst.put("SONAM",8);

        for (String s : bst.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

	}

}