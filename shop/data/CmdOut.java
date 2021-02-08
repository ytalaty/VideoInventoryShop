package hw5.shop.data;

import hw5.shop.command.UndoableCommand;

/**
 * Implementation of command to check out a video.
 * @see Data
 */
final class CmdOut implements UndoableCommand {
  private InventorySet _inventory;
  private Record _oldvalue;
  private Video _video;
  CmdOut(InventorySet inventory, Video video) {
    _inventory = inventory;
    _video = video;
  }
  public boolean run() {
    if (_oldvalue!=null) {
    	return false;
    }
    try {
    	_oldvalue=_inventory.checkOut(_video);
    	_inventory.getHistory().add(this);
    	return true;
    } catch (ClassCastException e) {
    	return false;
    } catch (IllegalArgumentException e) {
    	return false;
    }
  }
  public void undo() {
    _inventory.replaceEntry(_video, _oldvalue);  
  }
  public void redo() {
    _inventory.checkOut(_video);  
  }
}
