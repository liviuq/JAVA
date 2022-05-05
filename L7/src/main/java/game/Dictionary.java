package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary implements MockDictionary
{
    private Set<String> dictionary;

    public Dictionary()
    {
        //instantiating the dictionary
        dictionary = new HashSet<>();

        //declaring our scanner
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(new File("wordList.txt"));

            //one hour wasted on this regex thanks to trailing newlines!
            scanner.useDelimiter(";|\r?\n|\r");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

        //asserting that our scanner is valid
        assert scanner != null;

        //insert words into dictionary
        while(scanner.hasNext())
        {
            dictionary.add(scanner.next());
        }
    }

    public boolean isWord(String word)
    {
//        //search for word in dictionary using binary search
//        int left = 0, right = dictionary.size() - 1;
//
//        while(left <= right)
//        {
//            int middle = left + (right - left) / 2;
//
//            int comparationResult = word.compareTo(dictionary.get(middle));
//
//            if(comparationResult > 0)
//            {
//                left = middle + 1;
//            }
//            else
//            {
//                right = middle - 1;
//            }
//
//            if(comparationResult == 0)
//            {
//                return true;
//            }
//        }
//        //wasn t found
//        return false;

        return dictionary.contains(word);
    }
}
