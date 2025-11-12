class App {
  public static void main(String[] args) {
    Book.readBook("https://www.gutenberg.org/cache/epub/6130/pg6130.txt");
    System.out.println("count is " + Book.returnCount());
  }
}
