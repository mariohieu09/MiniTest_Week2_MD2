public class BookTest {
    public static void main(String[] args) {
        Book[] Books = new Book[10];
        Books[0] = new ProgrammingBook("java", "hashcode", 90);
        Books[1] = new ProgrammingBook("JS", "weis nicht" ,  88);
        Books[2] = new ProgrammingBook("PHP", "framework", 99);
        Books[3] = new ProgrammingBook("Python", "worker", 200);
        Books[4] = new ProgrammingBook("Kotlin", "frameshot", 109);
        Books[5] = new FictionBook("Dinosour", 78);
        Books[6] = new FictionBook("Fiction", 90);
        Books[7] = new FictionBook("Space" , 88);
        Books[8] = new FictionBook("Anime", 76);
        Books[9] = new FictionBook("Fiction", 560);
        int countCategory = 0;
        int countPrice = 0;
        int sumOfBooksPrice = 0;
        for(Book s : Books){
            if(s.getPrice() < 100){
                countPrice++;
            }
            if(s instanceof  FictionBook && ((FictionBook)s).getCategory() == "Fiction"){
                countCategory += 1;
            }
            sumOfBooksPrice += s.getPrice();
        }
        Book s = new FictionBook();
        System.out.println(countCategory);
        System.out.println(countPrice);
        System.out.println(sumOfBooksPrice);

    }
}
