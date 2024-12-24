import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        HashSet<String> iceCreamFlavors = new HashSet<>();
        iceCreamFlavors.add("Strawberry");
        iceCreamFlavors.add("Mint Chocolate Chip");
        iceCreamFlavors.add("Vanilla");
        iceCreamFlavors.add("Chocolate");
        iceCreamFlavors.add("Cookie Dough");

        Map<String, Integer> votes = new HashMap<>();

        ArrayList<String> familyMembers = new ArrayList<>(Arrays.asList("Elizabeth" , "Charles" , "Anne" , "Andrew" , "Edward"));

        printIceCreamFalvors(iceCreamFlavors);

        System.out.println("");
        
        GetVotes(familyMembers, votes, iceCreamFlavors);

        System.out.println("");

        printHighestVoteFlavor(votes);

    }

    public static void printIceCreamFalvors(HashSet<String> iceCreamFalvors)
    {
        System.out.println("Let's Vote on Ice Cream Flavors, Here are your Options:");
        for (String iceCreamFlavor: iceCreamFalvors)
        {
            System.out.println(iceCreamFlavor);
        }
    }

    public static void GetVotes(ArrayList<String> familyMembers, Map<String, Integer> votes, HashSet<String> iceCreamFalvors)
    {
        for (String familyMember: familyMembers)
        {
            boolean isValidVote = false;
            do
            {
                String formattedString = String.format("Which Flavor Do You Want to Vote For %s?" , familyMember);
                System.out.println(formattedString);
    
                Scanner scanner = new Scanner(System.in);
                String flavor = scanner.nextLine();
                
                if (iceCreamFalvors.contains(flavor))
                {
                    isValidVote = true;
                    if (votes.containsKey(flavor))
                    {
                        votes.replace(flavor, votes.get(flavor) + 1);
                    }
                    else 
                    {
                        votes.put(flavor, 1);
                    }
                }
                else
                {
                    System.out.println("That is not a valid flavor. Please try again!");
                }

         
            } while(!isValidVote);

            System.out.println("");

        }
    }

    public static void printHighestVoteFlavor(Map<String, Integer> votes)
    {
        System.out.println("The flavors with the most votes are:"); 

        int maxVote = Collections.max(votes.values());
        
        for (Map.Entry<String, Integer> entry: votes.entrySet())
        {
            if (entry.getValue() == maxVote)
            {
                System.out.println(entry.getKey()); 
            }
            
        }

    }
}
