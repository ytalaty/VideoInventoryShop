package hw5.shop.main;

import junit.framework.Assert;
import junit.framework.TestCase;
import hw5.shop.command.Command;
import hw5.shop.data.Data;
import hw5.shop.data.Record;
import hw5.shop.data.Video;
import hw5.shop.data.Inventory;
import java.util.Iterator;

// TODO:
// write an integration test that tests the data classes.
// add in some videos, check out, check in, delete videos, etc.
// check that errors are reported when necessary.
// check that things are going as expected.
public class TEST1 extends TestCase {
  private Inventory _inventory = Data.newInventory();
  public TEST1(String name) {
    super(name);
  }
  private void check(Video v, int numOwned, int numOut, int numRentals) {
    Record r = _inventory.get(v);
    assertEquals(numOwned, r.numOwned());
    assertEquals(numOut, r.numOut());
    assertEquals(numRentals, r.numRentals());
  }
    
  public void test1() {
    Command clearCmd = Data.newClearCmd(_inventory);
    clearCmd.run();
    
    Video v1 = Data.newVideo("Title1", 2000, "Director1");
    assertEquals(0, _inventory.size());
    assertTrue(Data.newAddCmd(_inventory, v1, 5).run());
    assertEquals(1, _inventory.size());
    assertTrue(Data.newAddCmd(_inventory, v1, 5).run());
    assertEquals(1, _inventory.size());
    check(v1,10,0,0);
    
    Video v2 = Data.newVideo("Title2",2001,"Director2");
    assertTrue(Data.newAddCmd(_inventory, v2, 1).run());
    assertEquals(2,_inventory.size());
    check(v2,1,0,0);
    assertFalse(Data.newAddCmd(_inventory, null, 5).run());
    assertEquals(2,_inventory.size());
    assertTrue(Data.newOutCmd(_inventory, v2).run());
    check(v2,1,1,1);
    assertTrue(Data.newInCmd(_inventory, v2).run());
    check(v2,1,0,1);
    assertTrue(Data.newAddCmd(_inventory,v2,-1).run());
    assertEquals(1,_inventory.size());
    check(v1,10,0,0);
    assertTrue(Data.newOutCmd(_inventory, v1).run());
    assertTrue(Data.newOutCmd(_inventory, v1).run());
    assertTrue(Data.newOutCmd(_inventory, v1).run());
    assertTrue(Data.newOutCmd(_inventory, v1).run());
    check(v1,10,4,4);
    assertTrue(Data.newInCmd(_inventory, v1).run());
    check(v1,10,3,4);
    assertTrue(Data.newAddCmd(_inventory,v2,5).run());
    assertEquals(2,_inventory.size());
    check(v2,5,0,0);
    check(v1,10,3,4);
  }
}
