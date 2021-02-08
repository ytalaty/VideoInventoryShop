package hw5.shop.command;

public class CommandHistoryFactory {
  private CommandHistoryFactory() {}
  static public CommandHistory newCommandHistory() {
    return new CommandHistoryObj();
  }
}
