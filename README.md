# WorkshopApprovalsJava

How to develop full test coverage on untested code...quickly

## Characterization Tests
* Use the code in a test
* Write an assertion that you know will fail
* Let the failure tell you what the code really does
* Change the test to expect the correct behavior

```Java
GildedRoseService gs = new GildedRoseService(new Item[] {
            new Item("hammer", 0, 0, "weapon", 1, 1,
            new Character("fred", "male", 1, "warrior", "elf"),
            new Realm("Atlantis"))
        });

	new Item[] {
            new Item("hammer", 0, 0, "weapon", 1, 1,
            new Character("fred", "male", 1, "warrior", "elf"),
            new Realm("Atlantis"))
        }

        gs.updateQuality();

        assertEquals(-1000000, gs.items[0].getQuality());
```

## Approval/Snapshot tests
* Use the code in a test
* Verify the result
* Format the output to be human readable and consistent
* Approve the output

```Java
        GildedRoseService gs = new GildedRoseService(new Item[] {
            new Item("hammer", 0, 0, "weapon", 1,1,
            new Character("fred", "M", 1, "warrior", "elf"),
            new Realm("Atlantis"))
        });


        gs.updateQuality();

        Approvals.verify(gs.items.toString());
```

## Combination Approvals
* Refactor an Approval test to an isolated method that:
  * is local to the test
  * where parameters are identified by the data you must vary to generate 100% branch coverage in the production code
  * uses object arrays for parameters to be passed to the test method
    * convert primitive parameters to the Object equivalent (int => Integer, float => Float, etc.)
    * contents of parameter arrays based on the conditional statements found in the production code under test
* Keep adding new data to Object arrays and running coverage until you reach 100% branch coverage in code under test
* Add Mutation testing to ensure you have enough test data (pitest)
* Commit your approved file to Git
* add approval tests to your build pipeline
```Java
package beyond.gilded.rose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    public void whatDoesGildedRoseDo() {
        String [] name = {"hammer", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
        Integer [] sellIn = {-1, 0, 1, 5, 6, 7, 10, 11, 12};
        Integer [] quality = {0, 1, 50};

        CombinationApprovals.verifyAllCombinations(this::doTest, name, sellIn, quality);
    }

    private String doTest(String name, int sellIn, int quality) {
        GildedRoseService gs = new GildedRoseService(new Item[] {
            new Item(name, sellIn, quality, "weapon", 1,1,
            new Character("fred", "M", 1, "warrior", "elf"),
            new Realm("Atlantis"))
        });

        gs.updateQuality();

        String result = gs.items[0].toString();
        return result;
    }
}


public class Item {
    
    ...

    @Override
    public String toString() {
        return "Character [gender=" + gender + ", level=" + level + ", name=" + name + ", race=" + race
                + ", skillClass=" + skillClass + "]";
    }

}

public class Character {

    ...

    @Override
    public String toString() {
        return "Character [gender=" + gender + ", level=" + level + ", name=" + name + ", race=" + race
                + ", skillClass=" + skillClass + "]";
    }

}

public class Realm {

    ...

    @Override
    public String toString() {
        return "Realm [name=" + name + "]";
    }
    
}
```

## Additional study
Check out [Java Koans for Approvals](https://github.com/approvals/ApprovalTests.java.Koans)