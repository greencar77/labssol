package jspecifynull;

public class Scene {

    private final Alpha alpha = new Alpha();
    private final Beta beta = new Beta();

    public void run() {
        //Alpha

        System.out.println(alpha.getName());
        System.out.println(alpha.getName().length());

        System.out.println(alpha.getAddress());
        System.out.println(alpha.getAddress().length());
        System.out.println(alpha.getAddress() == null? "Nothing" : alpha.getAddress().length()); //Q6VS
        if (alpha.getAddress() == null) {
            System.out.println("Nothing");
        } else {
            System.out.println(alpha.getAddress().length());
        }

        String address = alpha.getAddress();
        System.out.println(address.length());

        //Beta

        System.out.println(beta.getName());
        System.out.println(beta.getName().length());

        System.out.println(beta.getId());
        System.out.println(beta.getId().length());
        System.out.println(beta.getId() == null? "Nothing" : beta.getId().length()); //Q3B5

    }
}
