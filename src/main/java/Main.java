import view.ConsoleView;

public class Main {

  public static void main(String[] args) {
    ConsoleView consoleView = new ConsoleView();
    consoleView.run();

    //Проблемы:
    //1. При удалении не последнего id образуется дыра.
    // И возможно нужно что то придумать, при добавлении элемента эта дыра должна быть заполнена.
  }
}
