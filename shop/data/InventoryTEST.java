package hw5.shop.data;

import junit.framework.Assert;
import junit.framework.TestCase;
import hw5.shop.command.UndoableCommand;
import hw5.shop.command.CommandHistory;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

// TODO:  complete the tests
public class InventoryTEST extends TestCase {
  public InventoryTEST(String name) {
    super(name);
  }
  
  InventorySet a = new InventorySet();
  final Video video = new VideoObj("A", 2000, "B");
  final Video videocopy = new VideoObj("A", 2000, "B");
  final Video video2 = new VideoObj("B", 2000, "B"); 
  
  public void testSize() {
	  assertEquals(0,a.size());
	  a.addNumOwned(video, 1);
	  assertEquals(1,a.size());
	  a.addNumOwned(video, 2);
	  assertEquals(1,a.size());
	  a.addNumOwned(video2, 1);
	  assertEquals(2,a.size());
	  a.addNumOwned(video2, -1);
	  assertEquals(1,a.size());
  }

  public void testAddNumOwned() {
	  assertEquals(null,a.get(video));
	    a.addNumOwned(video,1);
	    assertEquals(video,a.get(video).video());
	    assertEquals(1,a.get(video).numOwned());
	    a.addNumOwned(video, 2);
	    assertEquals(3,a.get(video).numOwned());
	    a.addNumOwned(video, -1);
	    assertEquals(2,a.get(video).numOwned());
	    a.addNumOwned(video2, 1);
	    assertEquals(2,a.get(video).numOwned());
	    a.addNumOwned(videocopy, 1);
	    assertEquals(3,a.get(video).numOwned());
	    a.addNumOwned(video, -3);
	    assertEquals(null,a.get(video));  
  }

  public void testCheckOutCheckIn() {
	  try { a.checkOut(null);     fail(); } catch ( IllegalArgumentException e ) {}
	    try { a.checkIn(null);      fail(); } catch ( IllegalArgumentException e ) {}
	          a.addNumOwned(video, 2); assertTrue( a.get(video).numOut() == 0 && a.get(video).numRentals() == 0 );
	          a.checkOut(video);       assertTrue( a.get(video).numOut() == 1 && a.get(video).numRentals() == 1 );
	    try { a.addNumOwned(video,-3); fail(); } catch ( IllegalArgumentException e ) {}
	    try { a.addNumOwned(video,-2); fail(); } catch ( IllegalArgumentException e ) {}
	          a.addNumOwned(video,-1); assertTrue( a.get(video).numOut() == 1 && a.get(video).numRentals() == 1 );
	          a.addNumOwned(video, 1); assertTrue( a.get(video).numOut() == 1 && a.get(video).numRentals() == 1 );
	          a.checkOut(video);       assertTrue( a.get(video).numOut() == 2 && a.get(video).numRentals() == 2 );
	    try { a.checkOut(video);       fail(); } catch ( IllegalArgumentException e ) {}
	          a.checkIn(video);        assertTrue( a.get(video).numOut() == 1 && a.get(video).numRentals() == 2 );
	          a.checkIn(videocopy);    assertTrue( a.get(video).numOut() == 0 && a.get(video).numRentals() == 2 );
	    try { a.checkIn(video);        fail(); } catch ( IllegalArgumentException e ) {}
	    try { a.checkOut(video2);      fail(); } catch ( IllegalArgumentException e ) {}
	          a.checkOut(video);       assertTrue( a.get(video).numOut() == 1 && a.get(video).numRentals() == 3 );  
  }

  public void testClear() {
	  a.addNumOwned(video, 2);
	    assertEquals(1,a.size());
	    a.addNumOwned(video2, 2);
	    assertEquals(2,a.size());
	    a.clear();
	    assertEquals(0,a.size());  
  }

  public void testGet() {
	  a.addNumOwned(video, 1);
	    Record r1=a.get(video);
	    Record r2=a.get(video);
	    assertTrue(r1==r2);
	    assertTrue(r1.equals(r2));
  }

  public void testIterator1() {
	  Set<Video> expected = new HashSet<Video>();
	    InventorySet inventory = new InventorySet();
	    Video video = new VideoObj("XX",2004,"XX");
	    Video video2 = new VideoObj("XY",2000,"XY");
	    inventory.addNumOwned(video, 10);
	    inventory.addNumOwned(video2, 20);
	    expected.add(video);
	    expected.add(video2);
	    Iterator<Record> i = inventory.iterator();
	    while(i.hasNext()) {
	    	Record record = i.next();
	    	assertTrue(expected.contains(record.video()));
	    	expected.remove(record.video());
	    }
	    assertTrue(expected.isEmpty());
  }
  public void testIterator2() {
	  List<Video> expected = new ArrayList<Video>();
	     InventorySet inventory = new InventorySet();
	     Video video = new VideoObj("XX",2004,"XX");
	     Video video2 = new VideoObj("XY",2000,"XY");
	     expected.add(video2);
	     expected.add(video);
	     inventory.addNumOwned(video, 10);
	     inventory.addNumOwned(video2, 20);
	     Comparator<Record> c = new Comparator<Record>() {
	    	 public int compare(Record r1, Record r2) {
	    		 return r2.numOwned()-r1.numOwned();
	    	 }
	     };
	     Iterator<Record> i = inventory.iterator(c);
	     while (i.hasNext()) {
	    	 Record record = i.next();
	    	 assertTrue(expected.contains(record.video()));
	    	 expected.remove(record.video());
	     }
	     assertTrue(expected.isEmpty()); 
  }
}
